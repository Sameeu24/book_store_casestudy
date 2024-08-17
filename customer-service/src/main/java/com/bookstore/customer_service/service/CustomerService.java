package com.bookstore.customer_service.service;
import com.bookstore.customer_service.domain.Customer;
import com.bookstore.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

   private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    //GET All Customers
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //Find Book by id
    public Customer getCustomerById(long id){
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Book Not found"));
    }

    //Add a Customer
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    //Update Customer
    public Customer updateCustomer(Customer customer){
        Customer customerUpdate=customerRepository.findById(customer.getId()).orElseThrow(()->new RuntimeException("Book not found"));
        customerUpdate.setName(customer.getName());
        customerUpdate.setEmail(customer.getEmail());
        customerUpdate.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(customer);
    }

    //Delete Customer

    public void deleteCustomer(long id){
        var book=customerRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Book not found"));
        customerRepository.delete(book);
    }


}
