package com.todo.todo.controller;

import com.todo.todo.model.Todo;
import com.todo.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @MockBean
    TodoService todoService;

    @Autowired
    MockMvc mockMvc;

    String url = "/todos";

    @Test
    void create() throws Exception {
        Todo todo = new Todo(null, "Vacuum cleaning", false);
        String json = """
                {"text": "Vacuum cleaning", "isCompleted": false},
                """;

        mockMvc.perform(post(url).contentType(APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        verify(todoService).create(todo);
    }

    @Test
    void readAll() throws Exception {
        mockMvc.perform(get(url).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(todoService).readAll();

    }

    @Test
    void readOneByText() throws Exception {
        String text = "text";
        String urlWithText = url + "/" + text;

        when(todoService.readOneByText(text)).thenReturn(Optional.of(new Todo(null, text, true)));
        mockMvc.perform(get(urlWithText).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(todoService).readOneByText(text);

    }

    @Test
    void update() throws Exception {
        Todo todo = new Todo("1", "Workout", false);
        String json = """
                {"id": "1", "text": "Workout", "isComplete": false}
                """;

        mockMvc.perform(patch(url).contentType(APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        Mockito.verify(todoService).update(todo);
    }

    @Test
    void deleteOneById() throws Exception {
        String id = "id";
        String urlWithId = url + "/" + id;

        mockMvc.perform(delete(urlWithId).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(todoService).deleteOneById(id);
    }

    @Test
    void deleteAll() throws Exception {

        mockMvc.perform(delete(url).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(todoService).deleteAll();
    }
}