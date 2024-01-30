package com.me.dora.todos.controller;

import com.me.dora.todos.model.Todo;
import com.me.dora.todos.service.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class TodoControllerTest {

    @MockBean
    TodoService todoService;

    @Autowired
    MockMvc mockMvc;

    String url = "/todos";

    @Test
    void create() throws Exception {
        Todo todo = new Todo("playing mage", true);
        String json = """
                {"text": "playing mage", "isCompleted": true }
                """;
        mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        Mockito.verify(todoService).create(todo);
    }


    @Test
    void readAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(todoService).readAll();
    }

    @Test
    void readOneByText() throws Exception {
        String text = "text";
        String urlWithText = url + "/" + text;
        Mockito.when(todoService.readOneByText(text)).thenReturn(Optional.of(new Todo("text", true)));
        mockMvc.perform(MockMvcRequestBuilders.get(urlWithText).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(todoService).readOneByText(text);
    }

    @Test
    void update() throws Exception {
        Todo todo = new Todo("playing mage", true);
        String json = """
                {"text": "playing mage", "isCompleted": true }
                """;
        mockMvc.perform(MockMvcRequestBuilders.patch(url).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        Mockito.verify(todoService).update(todo);

    }

    @Test
    void deleteOneById() throws Exception {
        String id = "id";
        String urlWithId = url + "/" + id;
        mockMvc.perform(MockMvcRequestBuilders.delete(urlWithId))
                .andExpect(status().isOk());
        Mockito.verify(todoService).deleteOneById(id);
    }

    @Test
    void deleteAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(todoService).deleteAll();
    }
}