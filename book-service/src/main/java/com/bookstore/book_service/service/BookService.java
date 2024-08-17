package com.bookstore.book_service.service;


import com.bookstore.book_service.domain.Book;
import com.bookstore.book_service.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;


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

    //Update book
    public Book updateBook(Book book){
        Book bookUpdate=bookRepository.findById(book.getBookId()).orElseThrow(()->new RuntimeException("Book not found"));
        bookUpdate.setBookName(book.getBookName());
        bookUpdate.setAuthor(book.getAuthor());
        bookUpdate.setPrice(book.getPrice());
        bookUpdate.setStock(book.getStock());
        return bookRepository.save(book);
    }

    //Delete Book

    public void deleteBook(long id){
        var book=bookRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Book not found"));
        bookRepository.delete(book);
    }


}
