package com.dr0pl3t.lms.mapper;

import com.dr0pl3t.lms.dto.BookDto;
import com.dr0pl3t.lms.entity.Book;

public class BookMapper {

    public static BookDto mapToBookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getNameOfAuthor(),
                book.getNumOfPages(),
                book.getGenre()
        );
    }

    public static Book mapToBook(BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getNameOfAuthor(),
                bookDto.getNumOfPages(),
                bookDto.getGenre()
        );
    }
}
