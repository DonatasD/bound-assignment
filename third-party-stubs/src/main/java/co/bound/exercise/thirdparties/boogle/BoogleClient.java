package co.bound.exercise.thirdparties.boogle;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import static co.bound.exercise.thirdparties.boogle.Genre.*;

public class BoogleClient {
    /**
     * Retrieve a list of books by author.
     * @param author the author
     * @return a list of books
     */
    List<BookSummary> searchBooksByAuthor(String author) {
        return Collections.emptyList();
    }

    /**
     * Get a list of all books.
     * @return all the books
     */
    List<BookSummary> getBooks() {
        // TODO: Return some books
        return Collections.emptyList();
    }

    Book getBookDetails(int bookId) {
        return switch (bookId) {
            case 1 -> new Book(bookId, "Gabriel Garcia Marquez", "One Hundred Years of Solitude", "978-0141184999",
                    EnumSet.of(FICTION, FANTASY, CONTEMPORARY), "Penguin", Format.PAPERBACK);
            case 2 -> new Book(bookId, "Bruce Chatwin", "In Patagonia", "978-0099769514",
                    EnumSet.of(NON_FICTION, TRAVEL), "Vintage Classics", Format.PAPERBACK);
            case 3 -> new Book(bookId, "Katie Mack", "The End of Everything: (Astrophysically Speaking)", "978-0141989587",
                    EnumSet.of(NON_FICTION, SCIENCE), "Penguin", Format.PAPERBACK);
            default -> throw new IllegalArgumentException("Unknown book");
        };
    }
}
