package com.me.project.books.repository;

import com.me.project.books.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class BookRepositoryTest {

    Book book = new Book("1", "LOTR", 8);

    @Test
    void create() {
        Set<Book> books = new HashSet<>();

        BookRepository bookRepository = new BookRepository(books);

        Book result = bookRepository.create(book);

        Assertions.assertTrue(books.contains(result));
        Assertions.assertEquals(book.title(), (result.title()));
        Assertions.assertEquals(book.rating(), result.rating());
        Assertions.assertEquals(books.size(), 1);
        Assertions.assertNotEquals(book.id(), result.id());
    }

    @Test
    void readAll() {
        Set<Book> books = new HashSet<>();

        BookRepository bookRepository = new BookRepository(books);

        Set<Book> result = bookRepository.readAll();

        Assertions.assertEquals(result, books);
    }

    @Test
    void readOneByTitle() {

        Book book2 = new Book("2", "HP", 10);
        Set<Book> books = new HashSet<>();
        books.add(book2);
        books.add(book);

        BookRepository bookRepository = new BookRepository(books);

        Optional<Book> result = bookRepository.readOneByTitle(book2.title());

        Assertions.assertEquals(result, Optional.of(book2));


    }

    @Test
    void update() {

        Book book2 = new Book("1", "LOTR", 10);
        Set<Book> books = new HashSet<>();
        BookRepository bookRepository = new BookRepository(books);
        books.add(book2);
        books.add(book);

        Book result = bookRepository.update(book2);

        Assertions.assertEquals(result, book2);
        Assertions.assertEquals(1, books.size());
    }

    @Test
    void deleteAll() {
        Set<Book> books = new HashSet<>();
        books.add(book);
        BookRepository bookRepository = new BookRepository(books);

        bookRepository.deleteAll();

        Assertions.assertEquals(0, books.size());
    }

    @Test
    void deleteOneById() {
        Set<Book> books = new HashSet<>();
        books.add(book);
        BookRepository bookRepository = new BookRepository(books);

        bookRepository.deleteOneById(book.id());

        Assertions.assertEquals(0, books.size());
        Assertions.assertFalse(books.contains(book));
        Assertions.assertTrue(books.isEmpty());
    }
}