package co.bound.exercise.marketing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MarketingServiceTest {

    @Autowired
    private MarketingService service;

    @Test
    public void shouldTrackBookSearches() {
        var bookId = 1;
        var result = service.addBookAsSearched(bookId);
        assertEquals(result, 1);
        var result1 = service.addBookAsSearched(bookId);
        assertEquals(result1, 2);
    }

    @Test
    public void shouldTrackBookPurchases() {
        var bookId = "1";
        var result = service.addBookAsPurchased(bookId);
        assertEquals(result, 1);
        var result1 = service.addBookAsPurchased(bookId);
        assertEquals(result1, 2);
    }
}
