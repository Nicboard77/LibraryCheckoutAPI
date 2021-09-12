package com.blorfer.main.ItemCheckout;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/itemCheckout")
public class ItemCheckoutController {

    private ItemCheckoutService itemCheckoutService;

    @GetMapping(path = "/getAllItemCheckout")
    public List<ItemCheckout> getAllItemCheckouts() throws Exception {
        return itemCheckoutService.getAllItemCheckouts();
    }

    @GetMapping(path = "/getItemCheckoutById/{id}")
    public ItemCheckout getItemCheckoutById(
            @PathVariable Long id
    ) throws Exception {
        return itemCheckoutService.getItemCheckoutById(id);
    }

    @PostMapping(path = "/createNewItemCheckout")
    public void createNewItemCheckout(
            @RequestParam Long customerCheckingOutId,
            @RequestParam Long itemCheckingOutId,
            @RequestParam Integer itemCheckoutLengthInDays
            ) {
        itemCheckoutService.createNewItemCheckout(
                customerCheckingOutId,
                itemCheckingOutId,
                itemCheckoutLengthInDays
        );
    }
    @DeleteMapping(path = "/deleteItemCheckoutById/{id}")
    public void deleteItemCheckoutById(
            @PathVariable Long id
    ) {
        itemCheckoutService.deleteItemCheckoutById(id);
    }
}
