package com.blorfer.main.Item;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/item")
public class ItemController {

    private ItemService itemService;

    @GetMapping(path = "/getAllItems")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(path = "/getItemById/{id}")
    public Item getItemById(@PathVariable Long id) throws Exception {
        return itemService.getItemById(id);
    }

    @PostMapping(path = "/createNewItem")
    public void createNewItem(
            @RequestParam String itemName,
            @RequestParam String itemDescription,
            @RequestParam String itemType,
            @RequestParam Integer itemRentalPrice
    ) throws Exception {
        itemService.createNewItem(
                itemName,
                itemDescription,
                itemType,
                itemRentalPrice
        );
    }

    @DeleteMapping(path = "/deleteItemById/{id}")
    public void deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
    }
    @PutMapping(path="/updateItemById/{id}")
    public void updateItemById(
            @PathVariable Long id,
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) String itemDescription,
            @RequestParam(required = false) String itemType,
            @RequestParam(required = false) Integer itemRentalPrice
    ) {
        itemService.updateItemById(id, itemName, itemDescription, itemType, itemRentalPrice);
    }
}
