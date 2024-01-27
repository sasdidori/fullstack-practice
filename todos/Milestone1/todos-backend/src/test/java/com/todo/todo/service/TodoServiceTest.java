package com.todo.todo.service;

import com.todo.todo.model.Todo;
import com.todo.todo.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {

    TodoRepository todoRepository = Mockito.mock(TodoRepository.class);

    TodoService todoService = new TodoService(todoRepository);

    Todo todo = new Todo("1", "Workout", true);


    @Test
    void create() {
        Mockito.when(todoRepository.create(todo)).thenReturn(todo);
        Todo expected = todo;

        Todo result = todoService.create(todo);

        Assertions.assertEquals(expected, result);
        Mockito.verify(todoRepository).create(todo);
    }

    @Test
    void readAll() {
        Set<Todo>todos = Set.of();
        Mockito.when(todoRepository.readAll()).thenReturn(todos);

        Set<Todo> result = todoService.readAll();

        Assertions.assertEquals(todos, result);
        Mockito.verify(todoRepository).readAll();
    }

    @Test
    void readOneByText() {
        Todo expected = todo;
        Mockito.when(todoRepository.readOneByText(todo.text())).thenReturn(Optional.of(expected));

        Optional<Todo> result = todoService.readOneByText(todo.text());

        Assertions.assertEquals(Optional.of(expected), result);
        Mockito.verify(todoRepository).readOneByText(todo.text());
    }

    @Test
    void update() {
        Mockito.when(todoRepository.update(todo)).thenReturn(todo);

        Todo result = todoService.update(todo);

        Assertions.assertEquals(result, todo);
        Mockito.verify(todoRepository).update(todo);
    }

    @Test
    void deleteOneById() {

        todoService.deleteOneById(todo.id());

        Mockito.verify(todoRepository).deleteOneById(todo.id());
    }

    @Test
    void deleteAll() {

        todoService.deleteAll();

        Mockito.verify(todoRepository).deleteAll();
    }
}