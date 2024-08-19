package com.bookstore.book_service.service;


import com.bookstore.book_service.domain.Book;
import com.bookstore.book_service.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //GET All Books
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //Find Book by id
    public Book getBookById(long id){
        return bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book Not found"));
    }

    //Add a book
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    //Update Book
    public Book updateBook(long id,Book book){
        Book book1=bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found"));
        book1.setBookName(book.getBookName());
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());
        book1.setStock(book.getStock());
        bookRepository.save(book1);
        return book1;
    }

    //Delete Book

    public void deleteBook(long id){
        var book=bookRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Book not found"));
        bookRepository.delete(book);
    }


}
