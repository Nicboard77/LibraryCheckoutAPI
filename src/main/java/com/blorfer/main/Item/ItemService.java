package com.blorfer.main.Item;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }


    public Item getItemById(Long id) throws Exception {
        if (itemRepository.findById(id).isPresent()) {
            return itemRepository.findById(id).get();
        } else {
            throw new Exception("Item does not exist!");
        }
    }

    public void createNewItem(
            String itemName,
            String itemDescription,
            String itemType,
            Integer itemRentalPrice) throws Exception {
        Item newItem = new Item(
                itemName,
                itemDescription,
                itemType,
                itemRentalPrice
        );
        if(
                itemName != null &&
                        itemDescription != null &&
                        itemType != null &&
                        itemRentalPrice != null
        ) {
            itemRepository.save(newItem);
        } else {
            throw new Exception("All fields much be filled");}

    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    public void updateItemById(Long id, String itemName, String itemDescription, String itemType, Integer itemRentalPrice)
    {
        if(itemRepository.findById(id).isPresent()) {
            Item itemToEdit = itemRepository.findById(id).get();
            if(itemName != null) {
                itemToEdit.setItemName(itemName);
            }
            if(itemDescription != null) {
                itemToEdit.setItemDescription(itemDescription);
            }
            if(itemType != null) {
                itemToEdit.setItemType(itemType);
            }
            if(itemRentalPrice != null) {
                itemToEdit.setItemRentalPrice(itemRentalPrice);
            }
            itemRepository.save(itemToEdit);
        }


    }
}
