package co.bound.exercise.marketing;

import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class MarketingService {

    // TODO store this to some persistent layer
    private final Map<Integer, AtomicInteger> bookSearches = new Hashtable<>();

    private final Map<String, AtomicInteger> bookPurchases = new Hashtable<>();

    public int addBookAsSearched(Integer bookId) {
        return bookSearches.computeIfAbsent(bookId, key -> new AtomicInteger(0)).incrementAndGet();
    }

    public int addBookAsPurchased(String bookId) {
        return bookPurchases.computeIfAbsent(bookId, key -> new AtomicInteger(0)).incrementAndGet();
    }

    public List<Integer> findPopularBooks(Integer limit) {
        return bookSearches.values().stream()
                .sorted()
                .limit(limit)
                .map((val) -> (Integer) val.get())
                .collect(Collectors.toList());
    }

    public List<Integer> findPopularBookPurchases(Integer limit) {
        return bookSearches.values().stream()
                .sorted()
                .limit(limit)
                .map((val) -> (Integer) val.get())
                .collect(Collectors.toList());
    }
}
