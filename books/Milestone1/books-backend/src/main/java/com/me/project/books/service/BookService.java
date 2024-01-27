package com.me.project.books.service;

import com.me.project.books.repository.BookRepository;
import org.springframework.stereotype.Service;

import com.me.project.books.model.Book;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(Book book) {
        return bookRepository.create(book);

    }

    public Set<Book> readAll() {
        return bookRepository.readAll();
    }

    public Optional<Book> readOneByTitle(String title) {
        return bookRepository.readOneByTitle(title);
    }

    public Book update(Book book) {
        return bookRepository.update(book);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }

    public void deleteOneById(String id) {
        bookRepository.deleteOneById(id);
    }
}
