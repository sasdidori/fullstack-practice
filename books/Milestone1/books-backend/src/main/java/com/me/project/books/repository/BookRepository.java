package com.me.project.books.repository;

import org.springframework.stereotype.Repository;

import com.me.project.books.model.Book;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;


public class BookRepository {

    private final Set<Book> books;

    public BookRepository(Set<Book> books) {
        this.books = books;
    }

    public Book create(Book book) {
        String id = UUID.randomUUID().toString();
        Book newBook = new Book(id, book.title(), book.rating());
        books.add(newBook);
        return newBook;
    }

    public Set<Book> readAll() {
        return new HashSet<>(books);
    }

    public Optional<Book> readOneByTitle(String title) {
        return books.stream()
                .filter(book -> book.title().equals(title))
                .findFirst();
    }

    public Book update(Book book) {
        deleteOneById(book.id());
        books.add(book);
        return book;
    }

    public void deleteAll() {
        books.clear();
    }

    public void deleteOneById(String id) {
        books.removeIf(book -> book.id().equals(id));
    }
}
