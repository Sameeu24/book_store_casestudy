package com.bookstore.customer_service.convertor;


import com.bookstore.customer_service.domain.Customer;
import com.bookstore.customer_service.dto.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOConvertor {

public CustomerDTO customerDTO(Customer customer){
    return new CustomerDTO(customer.getId(),customer.getName(),customer.getEmail(),customer.getPhoneNumber());
}

public Customer toEntity(CustomerDTO dto){
Customer customer=new Customer();
customer.setName(dto.name());
customer.setEmail(dto.email());
customer.setPhoneNumber(dto.phoneNumber());
return customer;
}
}
