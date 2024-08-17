package com.bookstore.order_service.feignclients;


import com.bookstore.order_service.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service",url = "http://localhost:8100/api/v1/books")
public interface BookServiceClient {

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable long id);

}
