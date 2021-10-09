package com.blorfer.main.ItemCheckout;

import com.blorfer.main.Item.Item;
import com.blorfer.main.Item.ItemRepository;
import com.blorfer.main.customer.Customer;
import com.blorfer.main.customer.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemCheckoutService {

    private ItemCheckoutRepository itemCheckoutRepository;
    private ItemRepository itemRepository;
    private CustomerRepository customerRepository;

    public List<ItemCheckout> getAllItemCheckouts() throws Exception {
        if(!itemCheckoutRepository.findAll().isEmpty()) {
            return itemCheckoutRepository.findAll();
        } else {
            throw new Exception("There are no items checked out currently!");
        }

    }

    public ItemCheckout getItemCheckoutById(Long id) throws Exception {
        if(itemCheckoutRepository.findById(id).isPresent()) {
            return itemCheckoutRepository.findById(id).get();
        } else {
            throw new Exception("Item Checkout is not found!");
        }
    }

    public void createNewItemCheckout(
            Long customerCheckingOutId,
            Long itemCheckingOutId,
            Integer itemCheckoutLengthInDays) {
        if(
                customerCheckingOutId != null &&
                        itemCheckingOutId != null &&
                        itemCheckoutLengthInDays != null
        ) {
            Customer customerToUse = customerRepository.getById(customerCheckingOutId);
            Item itemToUse = itemRepository.getById(itemCheckingOutId);

            Integer totalRentalCost =
                    itemCheckoutLengthInDays * itemToUse.getItemRentalPrice();

            ItemCheckout newItem = new ItemCheckout(
                    customerToUse,
                    itemToUse,
                    totalRentalCost,
                    itemCheckoutLengthInDays
            );
            itemCheckoutRepository.save(newItem);


        }
    }

    public void deleteItemCheckoutById(Long id) {
        itemCheckoutRepository.deleteById(id);
    }
}
