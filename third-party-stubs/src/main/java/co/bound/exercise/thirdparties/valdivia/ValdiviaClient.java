package co.bound.exercise.thirdparties.valdivia;

import java.util.UUID;

public class ValdiviaClient {
    public BookQuote getBookQuote(String isbn) {
        return new BookQuote(
                10.99,
                UUID.randomUUID().toString()
        );
    }

    public void purchaseBook(String quoteId) {
        // Let's pretend there's a remote call in here
    }
}
