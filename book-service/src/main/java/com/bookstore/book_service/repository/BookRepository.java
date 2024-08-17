package com.bookstore.book_service.repository;

import com.bookstore.book_service.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
