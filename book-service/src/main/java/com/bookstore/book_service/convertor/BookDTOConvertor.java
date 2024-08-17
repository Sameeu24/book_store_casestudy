package com.bookstore.book_service.convertor;

import com.bookstore.book_service.domain.Book;
import com.bookstore.book_service.dto.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookDTOConvertor {

    public BookDTO bookDTO(Book book){
        return new BookDTO(book.getBookId(),book.getBookName(),book.getAuthor(),book.getPrice(), book.getStock());

    }

    public Book toEntity(BookDTO dto){

    Book book=new Book();
    book.setBookName(dto.bookName());
    book.setAuthor(dto.author());
    book.setPrice(dto.price());
    book.setStock(dto.stock());

        return book;

    }
}
