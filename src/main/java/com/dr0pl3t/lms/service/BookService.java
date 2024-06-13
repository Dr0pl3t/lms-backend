package com.dr0pl3t.lms.service;

import com.dr0pl3t.lms.dto.BookDto;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(long bookId);
}
