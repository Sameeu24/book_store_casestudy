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
    public Customer updateCustomer(long id,Customer customer){
       Customer customer1=customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
       customer1.setName(customer.getName());
       customer1.setEmail(customer.getEmail());
       customer1.setPhoneNumber(customer.getPhoneNumber());
       customerRepository.save(customer1);
       return customer1;
    }

    //Delete Customer

    public void deleteCustomer(long id){
        var book=customerRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Book not found"));
        customerRepository.delete(book);
    }


}
