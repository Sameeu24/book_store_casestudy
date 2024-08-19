package com.bookstore.order_service.controller;


import com.bookstore.order_service.domain.Order;
import com.bookstore.order_service.dto.Book;
import com.bookstore.order_service.dto.OrderDTO;
import com.bookstore.order_service.feignclients.BookServiceClient;
import com.bookstore.order_service.orderrepository.OrderRepository;
import com.bookstore.order_service.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class BookController {

   private final OrderService orderService;
    private final BookServiceClient bookServiceClient;

    public BookController(OrderRepository orderRepository, OrderService orderService, BookServiceClient bookServiceClient) {
        this.orderService = orderService;
        this.bookServiceClient = bookServiceClient;
    }

    @PostMapping("")

    public ResponseEntity<OrderDTO> createOrder(@RequestBody Order order){
        var response=orderService.createOrder(order);
//        Book book=new Book();
        return ResponseEntity.ok(OrderDTO.convertToDto(order,bookServiceClient ));

    }

    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrders(){
        var response=orderService.getAllOrders();
        return ResponseEntity.ok(response);
    }
}
