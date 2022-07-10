package co.bound.exercise.books;

import co.bound.exercise.marketing.MarketingService;
import co.bound.exercise.thirdparties.boogle.BoogleClient;
import co.bound.exercise.thirdparties.boogle.Book;
import co.bound.exercise.thirdparties.boogle.BookSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BoogleClient boogleClient;

    private final MarketingService marketingService;

    @Autowired
    public BookService(MarketingService marketingService) {
        this.boogleClient = new BoogleClient();
        this.marketingService = marketingService;
    }

    public List<BookSummary> findBooks(String author) {
        return boogleClient.searchBooksByAuthor(author);
    }

    public Optional<Book> findBookById(int bookId) {
        try {
            var result = Optional.of(this.boogleClient.getBookDetails(bookId));
            marketingService.addBookAsSearched(bookId);
            return result;
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
