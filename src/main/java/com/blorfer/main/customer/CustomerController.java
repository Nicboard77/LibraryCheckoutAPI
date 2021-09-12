package com.blorfer.main.customer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/Customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping(path = "/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    @GetMapping(path = "/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable Long id) throws Exception {
        return customerService.getCustomerById(id);
    }
    @GetMapping(path = "/getCustomerByEmail/{email}")
    public Customer getCustomerByEmail(@PathVariable String email) throws Exception {
        return customerService.getCustomerByEmail(email);
    }

    @PostMapping(path = "/createNewCustomer")
    public void createNewCustomer(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam Integer age,
            @RequestParam String phoneNumber
            ) throws Exception {
        customerService.createNewCustomer(
                firstName,
                lastName,
                email,
                age,
                phoneNumber
        );
    }
    @DeleteMapping(path = "/deleteCustomerById/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }
    @PutMapping(path = "/updateCustomerById/{id}")
    public void updateCustomerById(
            @PathVariable Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String phoneNumber
    ) {
        customerService.updateCustomerById(id, firstName, lastName, email, age, phoneNumber);
    }




}
