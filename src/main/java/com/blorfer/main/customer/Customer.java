package com.blorfer.main.customer;

import lombok.*;

import javax.persistence.*;


import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Customer")
@Table(
        name = "Customer",
        uniqueConstraints = @UniqueConstraint(
                name = "customer_email_unique",
                columnNames = "email"
        ))

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer{
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;
    @Column(
            name = "email"
    )

    private String email;
    @Column(
            name = "age"
    )
    private Integer age;
    @Column(
            name = "phone_number"
    )
    private String phoneNumber;


    // CONSTRUCTOR WITHOUT AUTO-GENERATED ID
    public Customer(String firstName, String lastName, String email, Integer age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}