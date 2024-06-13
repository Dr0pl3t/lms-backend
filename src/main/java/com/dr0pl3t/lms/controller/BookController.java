package com.dr0pl3t.lms.controller;


import com.dr0pl3t.lms.dto.BookDto;
import com.dr0pl3t.lms.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
