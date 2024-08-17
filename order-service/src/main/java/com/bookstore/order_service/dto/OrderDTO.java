package com.bookstore.order_service.dto;

import com.bookstore.order_service.domain.Order;
import com.bookstore.order_service.feignclients.BookServiceClient;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private long orderId;
    private long customerId;
    private long bookId;
    private int quantity;
    private String status;
    private Book book;


    public static OrderDTO convertToDto(Order order, BookServiceClient bookServiceClient) {
        Book book = bookServiceClient.findBookById(order.getBookId());
        return new OrderDTO(order.getOrderId(),order.getCustomerId(),order.getBookId(),order.getQuantity(), order.getStatus(),book);

    }
}
