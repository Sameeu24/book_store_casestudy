package com.bookstore.customer_service.dto;

public record CustomerDTO(
        long id,
        String name,
        String email,
        String phoneNumber
) {

}
