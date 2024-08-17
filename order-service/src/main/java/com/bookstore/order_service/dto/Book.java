package com.bookstore.order_service.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(
        long id,
        int stock
) {
}
