package com.me.project.books.controller;

import com.me.project.books.model.Book;
import com.me.project.books.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @MockBean
    BookService bookService;

    @Autowired
    MockMvc mockMvc;

    String url = "/books";


    @Test
    void create() throws Exception {
        Book book = new Book("1", "Harry Potter", 10);
        String json = """
                {"id": "1", "title": "Harry Potter", "rating": 10}
                """;

        mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        Mockito.verify(bookService).create(book);
    }

    @Test
    void readAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(bookService).readAll();
    }

    @Test
    void readOneByTitle() throws Exception {
        String title = "title";
        String readUrl = url + "/" + title;
        when(bookService.readOneByTitle(title)).thenReturn(Optional.of(new Book(null, title, 9)));
        mockMvc.perform(MockMvcRequestBuilders.get(readUrl).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(bookService).readOneByTitle(title);
    }

    @Test
    void update() throws Exception {
        Book book = new Book("2", "Hunger Games", 8);
        String json = """
                {"id": "2", "title": "Hunger Games", "rating": 8}
                """;

        mockMvc.perform(MockMvcRequestBuilders.patch(url).contentType(APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        Mockito.verify(bookService).update(book);

    }

    @Test
    void deleteAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(url).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(bookService).deleteAll();
    }

    @Test
    void deleteOneById() throws Exception {
        String id = "1";
        String deleteOneWithId = url + "/" + id;
        mockMvc.perform(MockMvcRequestBuilders.delete(deleteOneWithId).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(bookService).deleteOneById(id);

    }
}