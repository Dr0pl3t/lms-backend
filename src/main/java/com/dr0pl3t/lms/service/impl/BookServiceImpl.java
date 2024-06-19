package com.dr0pl3t.lms.service.impl;

import com.dr0pl3t.lms.dto.BookDto;
import com.dr0pl3t.lms.entity.Book;
import com.dr0pl3t.lms.exception.ResourceNotFoundException;
import com.dr0pl3t.lms.mapper.BookMapper;
import com.dr0pl3t.lms.repository.BookRepository;
import com.dr0pl3t.lms.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book does not exist with given id: " + bookId)
        );

        return BookMapper.mapToBookDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((book) -> BookMapper.mapToBookDto(book))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(Long bookId, BookDto updatedBook) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book does not exist with given id: " + bookId)
        );

        book.setTitle(updatedBook.getTitle());
        book.setNameOfAuthor(updatedBook.getNameOfAuthor());
        book.setNumOfPages(updatedBook.getNumOfPages());
        book.setGenre(updatedBook.getGenre());

        Book updatedBookObj = bookRepository.save(book);

        return BookMapper.mapToBookDto(updatedBookObj);
    }

    @Override
    public void deteleBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book does not exist with given id: " + bookId)
        );

        bookRepository.deleteById(bookId);
    }
}
