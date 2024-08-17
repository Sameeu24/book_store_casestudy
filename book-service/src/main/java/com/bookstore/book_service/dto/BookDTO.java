package com.bookstore.book_service.dto;

import jakarta.validation.constraints.*;

public record BookDTO (
        long id,


        @NotBlank(message = "Title must be provided.")
        @Size(min = 1, max = 255, message = "Title length must be between 1 and 255 characters.")
        String bookName,

        @NotBlank(message = "Author name must be provided.")
        @Size(min = 1, max = 255, message = "Author name length must be between 1 and 255 characters.")
        String author,

        @Min(value = 1, message = "Price must be greater than 0.")
        @Digits(integer = 10, fraction = 2, message = "Price must have up to 2 decimal places.")
        double price,

        @Min(value = 0, message = "Stock must be 0 or more.")
        int stock
){
}
