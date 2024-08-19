package com.bookstore.customer_service.dto;



//TODO : Validation
public record CustomerDTO(
        long id,
        String name,
        String email,
        String phoneNumber
) {

}
