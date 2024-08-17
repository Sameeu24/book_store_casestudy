package com.bookstore.book_service.controller;


import com.bookstore.book_service.convertor.BookDTOConvertor;
import com.bookstore.book_service.domain.Book;
import com.bookstore.book_service.dto.BookDTO;
import com.bookstore.book_service.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {


    private final BookService bookService;
    private final BookDTOConvertor convertor;


    public BookController(BookService bookService, BookDTOConvertor convertor) {
        this.bookService = bookService;
        this.convertor = convertor;
    }

    //Create a book
    @PostMapping
    public ResponseEntity<BookDTO> createPatient( @RequestBody BookDTO dto) {
        // TODO handle DuplicatePatientException
        // Create a new patient
        Book book = convertor.toEntity(dto);
        // Save the patient to the database
        book = bookService.createBook(book);
        var responseBody = convertor.bookDTO(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    //GET all books
    @GetMapping("")
    public ResponseEntity<List<Book>> findAllBooks(){
        var response=bookService.getAllBooks();
        return ResponseEntity.ok(response);

    }

    //GET book by id
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable  long id){
        Book book=bookService.getBookById(id);
        var response=convertor.bookDTO(book);
        return ResponseEntity.ok(response);

    }

    //UPDATE By ID method
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable long id,@RequestBody BookDTO book){
        Book updateBook=convertor.toEntity(book);
        var responseBody=bookService.updateBook(updateBook);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public  void deleteBookById(@PathVariable long id){
        Book book=bookService.getBookById(id);
     bookService.deleteBook(id);

    }
}
