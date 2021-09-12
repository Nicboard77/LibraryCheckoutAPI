package com.blorfer.main.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Item")
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "item_sequence"
    )
    private Long id;
    @Column(
            name = "item_name",
            nullable = false
    )
    private String itemName;
    @Column(
            name = "item_description"
    )
    private String itemDescription;
    @Column(
            name = "item_type"
    )
    private String itemType;
    @Column(
            name = "item_rental_price"
    )
    private Integer itemRentalPrice;

    public Item(String itemName, String itemDescription, String itemType, Integer itemRentalPrice) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
        this.itemRentalPrice = itemRentalPrice;
    }
}
