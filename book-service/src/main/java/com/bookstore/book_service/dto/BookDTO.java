package com.bookstore.book_service.dto;

import jakarta.validation.constraints.*;

public record BookDTO (

        long id,



        String bookName,


        String author,


        double price,

        int stock
){
}
