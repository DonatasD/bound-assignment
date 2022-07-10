package co.bound.exercise.books;

import co.bound.exercise.thirdparties.boogle.Book;
import co.bound.exercise.thirdparties.boogle.BookSummary;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController()
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // TODO This can be reused for retrieving all available books
    // TODO consider pagination
    @GetMapping(value = "/")
    public List<BookSummary> findBooks(@RequestParam() String author) {
        return this.bookService.findBooks(author);
    }

    @GetMapping(value = "/{bookId}")
    public Book findBookById(@PathVariable int bookId) {
        return this.bookService.findBookById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
