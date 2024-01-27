package com.me.project.books.service;

import com.me.project.books.model.Book;
import com.me.project.books.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class BookServiceTest {

    BookRepository bookRepository = Mockito.mock(BookRepository.class);

    BookService bookService = new BookService(bookRepository);

    Book book = new Book("1", "LOTR", 8);

    @Test
    void create() {
        Mockito.when(bookRepository.create(book)).thenReturn(book);

        Book result = bookService.create(book);

        Assertions.assertEquals(result, book);
        Mockito.verify(bookRepository).create(book);
    }

    @Test
    void readAll() {
        Set<Book> books = new HashSet<>();

        Mockito.when(bookRepository.readAll()).thenReturn(books);

        Set<Book> result = bookService.readAll();

        Assertions.assertEquals(result, books);
        Mockito.verify(bookRepository).readAll();
    }

    @Test
    void readOneByTitle() {
        Mockito.when(bookRepository.readOneByTitle(book.title())).thenReturn(Optional.of(book));

        Optional<Book> result = bookService.readOneByTitle(book.title());

        Assertions.assertEquals(result, Optional.of(book));
        Mockito.verify(bookRepository).readOneByTitle(book.title());
    }

    @Test
    void update() {

        Mockito.when(bookRepository.update(book)).thenReturn(book);

        Book result = bookService.update(book);

        Assertions.assertEquals(result, book);
        Mockito.verify(bookRepository).update(book);
    }

    @Test
    void deleteAll() {
        bookService.deleteAll();

        Mockito.verify(bookRepository).deleteAll();
    }

    @Test
    void deleteOneById() {
        bookService.deleteOneById(book.id());

        Mockito.verify(bookRepository).deleteOneById(book.id());
    }
}