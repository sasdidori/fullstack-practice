package com.me.project.books.repository;

import com.me.project.books.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RepositoryConfiguration {
    @Bean

    BookRepository bookRepository() {
        Set<Book> books = new HashSet<>();
        return new BookRepository(books);
    }
}
