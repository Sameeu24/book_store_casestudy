package com.bookstore.order_service.dto;

import com.bookstore.order_service.domain.Order;
import com.bookstore.order_service.feignclients.BookServiceClient;
import jakarta.validation.constraints. *;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//TODO : Validation
public class OrderDTO {


    private long orderId;
    private long customerId;

    @NotNull(message = "Book ID cannot be null")
    private long bookId;

    @NotNull(message = "Quantity cannot be null")
    @Positive(message = "Quantity must be greater than 0")
    private int quantity;

    @NotNull(message = "Status cannot be null")
    @Pattern(regexp = "PENDING|CONFIRMED|CANCELLED", message = "Status must be PENDING, CONFIRMED, or CANCELLED")
    private String status;
    private Book book;


    public static OrderDTO convertToDto(Order order, BookServiceClient bookServiceClient) {
        Book book = bookServiceClient.findBookById(order.getBookId());
        return new OrderDTO(order.getOrderId(),order.getCustomerId(),order.getBookId(),order.getQuantity(), order.getStatus(),book);

    }
}
