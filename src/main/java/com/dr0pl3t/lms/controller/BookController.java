package com.dr0pl3t.lms.controller;


import com.dr0pl3t.lms.dto.BookDto;
import com.dr0pl3t.lms.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private BookService bookService;

    // Build Add Book REST API
    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto savedBook = bookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // Build Get Book REST API
    @GetMapping("{id}")
    public ResponseEntity<BookDto> getBookByID (@PathVariable("id") Long bookId) {
        BookDto bookDto = bookService.getBookById(bookId);
        return ResponseEntity.ok(bookDto);
    }

    // Build Get All Books REST API
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Build Update Book REST API
    @PutMapping("{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long bookId, @RequestBody BookDto updatedBook) {
        BookDto bookDto = bookService.updateBook(bookId, updatedBook);
        return ResponseEntity.ok(bookDto);
    }

    // Build Delete Book REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId) {
        bookService.deteleBook(bookId);
        return ResponseEntity.ok("Book deleted successfully!");
    }
}
