package com.bookstore.book_service.dto;

import jakarta.validation.constraints.*;


//TODO : Validation
public record BookDTO (

        long id,


        @NotNull(message = "Title should not be empty")
        @NotEmpty(message = "Title should not be null")
        @Size(min=1, max=255, message = "Title length must be between 1 and 255 characters")
        String bookName,

        @NotNull(message = "Author should not be empty")
        @NotEmpty(message = "Author should not be null")
        @Size(min=1, max=255, message = "Title length must be between 1 and 255 characters")
        String author,

        @NotNull(message = "Price cannot be null")
        @Positive(message = "Price must be greater than zero")
        @Digits(integer = 10, fraction = 2, message = "Price must have up to 2 decimal places")
        double price,

        @NotNull(message = "Stock cannot be null")
        @Min(value = 0, message = "Stock must be 0 or more")
        int stock
){
}
