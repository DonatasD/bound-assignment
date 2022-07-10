package co.bound.exercise.marketing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/marketing")
// TODO protect controller for marketing users only
public class MarketingController {

    private final MarketingService marketingService;

    public MarketingController(MarketingService marketingService) {
        this.marketingService = marketingService;
    }

    // TODO change to return List<Book> or List<BookSummary>
    @GetMapping(value = "/books/searches")
    public List<Integer> findPopularBooks(@RequestParam(defaultValue = "5") Integer limit) {
        return this.marketingService.findPopularBooks(limit);
    }

    @GetMapping(value = "/books/purchases")
    public List<Integer> findPopularPurchasedBooks(@RequestParam(defaultValue = "5") Integer limit) {
        return this.marketingService.findPopularBookPurchases(limit);
    }
}
