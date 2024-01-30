package com.me.dora.todos.service;

import com.me.dora.todos.model.Todo;
import com.me.dora.todos.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.Set;

class TodoServiceTest {

    TodoRepository todoRepository = Mockito.mock(TodoRepository.class);

    TodoService todoService = new TodoService(todoRepository);

    Todo todo = new Todo("Programming", true);

    @Test
    void create() {
        Mockito.when(todoRepository.save(todo)).thenReturn(todo);
        Todo result = todoService.create(todo);

        Assertions.assertEquals(todo, result);
        Mockito.verify(todoRepository).save(todo);
    }

    @Test
    void readAll() {
        Mockito.when(todoRepository.findAll()).thenReturn(List.of(todo));
        Set<Todo> result = todoService.readAll();

        Set<Todo> expected = Set.of(todo);
        Assertions.assertEquals(expected, result);
        Mockito.verify(todoRepository).findAll();
    }

    @Test
    void readOneByText() {
        Mockito.when(todoRepository.readOneByText(todo.getText())).thenReturn(Optional.of(todo));

        Optional<Todo> result = todoService.readOneByText(todo.getText());
        Assertions.assertEquals(Optional.of(todo), result);
        Mockito.verify(todoRepository).readOneByText(todo.getText());
    }

    @Test
    void update() {
        Mockito.when(todoRepository.save(todo)).thenReturn(todo);
        Todo result = todoService.update(todo);

        Assertions.assertEquals(todo, result);
        Mockito.verify(todoRepository).save(todo);
    }

    @Test
    void deleteOneById() {
        todoService.deleteOneById(todo.getId());
        Mockito.verify(todoRepository).deleteById(todo.getId());
    }

    @Test
    void deleteAll() {
        todoService.deleteAll();
        Mockito.verify(todoRepository).deleteAll();
    }
}
