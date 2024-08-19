package com.bookstore.order_service.service;


import com.bookstore.order_service.domain.Order;
import com.bookstore.order_service.dto.Book;
import com.bookstore.order_service.dto.OrderDTO;
import com.bookstore.order_service.feignclients.BookServiceClient;
import com.bookstore.order_service.orderrepository.OrderRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookServiceClient bookServiceClient;


    public OrderService(OrderRepository orderRepository, BookServiceClient bookServiceClient) {
        this.orderRepository = orderRepository;
        this.bookServiceClient = bookServiceClient;
    }


    //Create an order that checks with Book stock
    public Order createOrder(Order order){
        //convert to DTO
        Book book=bookServiceClient.findBookById(order.getBookId());
        if (book.stock()<order.getQuantity()){
          order.setStatus("INSUFFICIENT STOCKS");
          return orderRepository.save(order);
        }
        order.setStatus("CONFIRMED");
        return  orderRepository.save(order);

    }

    //GET ALL ORDERS
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }




        //HElper method to convert to DTO
    private OrderDTO convertToDTO(Order order) {
        // Fetch the author information using the Feign client
        Book book = bookServiceClient.findBookById(order.getOrderId());
        return new OrderDTO(order.getOrderId(), order.getCustomerId(), order.getBookId(),order.getQuantity(),order.getStatus(),book);
    }
}
