package com.dr0pl3t.lms.service;

import com.dr0pl3t.lms.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(long bookId);

    List<BookDto> getAllBooks();

    BookDto updateBook(Long bookId, BookDto updatedBook);

    void deteleBook(Long bookId);
}
