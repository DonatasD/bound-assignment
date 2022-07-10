package co.bound.exercise.purchases;

import co.bound.exercise.marketing.MarketingService;
import co.bound.exercise.thirdparties.valdivia.ValdiviaClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PurchaseService {

    private final ValdiviaClient valdiviaClient;

    private final MarketingService marketingService;

    public PurchaseService(MarketingService marketingService) {
        this.valdiviaClient = new ValdiviaClient();
        this.marketingService = marketingService;
    }

    public void createPurchase(PurchaseCreateDTO purchaseCreateDTO) {
        switch (purchaseCreateDTO.type()) {
            case Book -> this.createPurchaseWithValdivia(purchaseCreateDTO.id());
            default -> throw new IllegalArgumentException("Implementation not available for this purchase type");
        }
    }

    private void createPurchaseWithValdivia(String isbn) {
        try {
            var bookQuote = this.valdiviaClient.getBookQuote(isbn);
            this.valdiviaClient.purchaseBook(bookQuote.id());
            this.marketingService.addBookAsPurchased(isbn);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
        }
    }
}
