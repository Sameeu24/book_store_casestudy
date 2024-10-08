package com.bookstore.customer_service.controller;
import com.bookstore.customer_service.convertor.CustomerDTOConvertor;
import com.bookstore.customer_service.domain.Customer;
import com.bookstore.customer_service.dto.CustomerDTO;
import com.bookstore.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {


    private final CustomerService customerService;
    private final CustomerDTOConvertor convertor;

    public CustomerController(CustomerService customerService, CustomerDTOConvertor convertor) {
        this.customerService = customerService;
        this.convertor = convertor;
    }


    //Create a Customer
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO dto) {
        // TODO handle DuplicatePatientException
        // Create a new patient
        Customer customer = convertor.toEntity(dto);
        // Save the patient to the database
        customer = customerService.createCustomer(customer);
        var responseBody = convertor.customerDTO(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    //GET all Customers
    @GetMapping("")
    public ResponseEntity<List<Customer>> findAllCustomers(){
        var response=customerService.getAllCustomers();
        return ResponseEntity.ok(response);

    }

    //GET Customer by id
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@Valid @PathVariable  long id){
        Customer customer=customerService.getCustomerById(id);
        var response=convertor.customerDTO(customer);
        return ResponseEntity.ok(response);

    }

//    UPDATE By ID method
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateBookById(@PathVariable long id, @RequestBody CustomerDTO customer){
        Customer updatecustomer=convertor.toEntity(customer);
        var responseBody=customerService.updateCustomer(id,updatecustomer);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public  void deleteCustomerById(@Valid @PathVariable long id){
        Customer customer=customerService.getCustomerById(id);
     customerService.deleteCustomer(id);

    }
}
