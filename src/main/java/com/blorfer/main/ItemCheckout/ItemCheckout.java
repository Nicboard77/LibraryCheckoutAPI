package com.blorfer.main.ItemCheckout;

import com.blorfer.main.Item.Item;
import com.blorfer.main.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Item_Checkout")
@Table(name = "item_checkout")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCheckout {
    @Id
    @SequenceGenerator(
            name = "item_checkout_sequence",
            sequenceName = "item_checkout_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "item_checkout_sequence"
    )
    private Long id;
    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(
            name = "customer_checking_out_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "customer_checking_out_id_fk"
            )
    )
    private Customer customerCheckingOut;
    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(
            name = "item_checking_out_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "item_checking_out_id_fk"
            )
    )
    private Item itemCheckingOut;
    @Column(
            name = "item_checout_price_total",
            nullable = false
    )
    private Integer itemCheckoutPriceTotal;
    @Column(
            name = "length_of_checkout_in_days",
            nullable = false
    )
    private Integer lengthOfCheckoutInDays;

    public ItemCheckout(Customer customerCheckingOut, Item itemCheckingOut, Integer itemCheckoutPriceTotal, Integer lengthOfCheckoutInDays) {
        this.customerCheckingOut = customerCheckingOut;
        this.itemCheckingOut = itemCheckingOut;
        this.itemCheckoutPriceTotal = itemCheckoutPriceTotal;
        this.lengthOfCheckoutInDays = lengthOfCheckoutInDays;
    }
}
