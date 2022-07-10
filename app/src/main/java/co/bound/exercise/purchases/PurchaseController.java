package co.bound.exercise.purchases;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping(value = "/")
    public void createPurchase(@RequestBody PurchaseCreateDTO purchaseCreateDTO) {
        this.purchaseService.createPurchase(purchaseCreateDTO);
    }
}
