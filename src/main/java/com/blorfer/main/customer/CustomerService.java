package com.blorfer.main.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@AllArgsConstructor

public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void createNewCustomer(
            String firstName,
            String lastName,
            String email,
            Integer age,
            String phoneNumber
    ) throws Exception {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(lastName);
        newCustomer.setEmail(email);
        newCustomer.setAge(age);
        newCustomer.setPhoneNumber(phoneNumber);
        if(customerRepository.findByEmail(email) == null)
            customerRepository.save(newCustomer);
        else {
            throw new Exception("Email already exists!");
        }



    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomerById(Long id, String firstName, String lastName, String email, Integer age, String phoneNumber)
    {
        Customer customerToEdit = customerRepository.getById(id);
        if(firstName != null) {
            customerToEdit.setFirstName(firstName);
        }
        if(lastName!= null) {
            customerToEdit.setFirstName(lastName);
        }
        if(email!= null) {
            customerToEdit.setEmail(email);
        }
        if(phoneNumber!= null) {
            customerToEdit.setPhoneNumber(phoneNumber);
        }
        if(age!= null) {
            customerToEdit.setAge(age);
        }
        customerRepository.save(customerToEdit);
    }

    public Customer getCustomerById(Long id) throws Exception {
        if(customerRepository.findById(id).isPresent()) {
            return customerRepository.findById(id).get();
        } else {
            throw new Exception("User does not exist!");
        }

    }

    public Customer getCustomerByEmail(String email) throws Exception {
        if(customerRepository.findByEmail(email) != null) {
            return customerRepository.findByEmail(email);
        } else {
            throw new Exception("Customer with email: " + email+ " doesnt exist!");
        }

    }
}
