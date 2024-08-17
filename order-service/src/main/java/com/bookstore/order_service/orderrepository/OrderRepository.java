package com.bookstore.order_service.orderrepository;

import com.bookstore.order_service.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order,Long> {
}
