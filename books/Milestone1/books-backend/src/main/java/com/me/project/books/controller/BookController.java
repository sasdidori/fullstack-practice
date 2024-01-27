package com.me.project.books.controller;

import com.me.project.books.model.Book;
import com.me.project.books.service.BookService;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:5174/")
@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //create
    @PostMapping
    Book create (@RequestBody Book book) {
        return bookService.create(book);
    }

    //readAll
    @GetMapping
    Set<Book> readAll () {
        return bookService.readAll();
    }

    //readOneByTitle
    @GetMapping("{title}")
    Book readOneByTitle(@PathVariable String title) throws BookNotFound{
        return bookService.readOneByTitle(title)
                .orElseThrow(BookNotFound::new);
    }

    //update
    @PatchMapping
    Book update(@RequestBody Book book){
        return bookService.update(book);
    }
    // deleteAll
    @DeleteMapping
    void deleteAll(){
        bookService.deleteAll();
    }

    //deleteOneById
    @DeleteMapping("{id}")
    void deleteOneById(@PathVariable String id){
        bookService.deleteOneById(id);
    }
}
