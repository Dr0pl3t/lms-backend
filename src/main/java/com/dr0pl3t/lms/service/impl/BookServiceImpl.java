package com.dr0pl3t.lms.service.impl;

import com.dr0pl3t.lms.dto.BookDto;
import com.dr0pl3t.lms.entity.Book;
import com.dr0pl3t.lms.exception.ResourceNotFoundException;
import com.dr0pl3t.lms.mapper.BookMapper;
import com.dr0pl3t.lms.repository.BookRepository;
import com.dr0pl3t.lms.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {

        Book book = BookMapper.mapToBook(bookDto);
        Book savedBook = bookRepository.save(book);
        return BookMapper.mapToBookDto(savedBook);
    }

    @Override
    public BookDto getBookById(long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book does not exist with given id: " + bookId));

        return BookMapper.mapToBookDto(book);
    }
}
