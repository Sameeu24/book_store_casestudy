package com.bookstore.book_service.dto;

public record BookDTO (
        long id,
         String bookName,
          String author,
         double price,
         int stock
){
}
