package com.todo.todo.repository;

import com.todo.todo.model.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TodoRepositoryTest {

    Todo todo = new Todo("1", "Workout", true);


    @Test
    void create() {
        Set<Todo> todos = new HashSet<>();
        TodoRepository todoRepository = new TodoRepository(todos);

        Todo result = todoRepository.create(todo);

        Assertions.assertEquals(todo.id(), result.id());
        Assertions.assertEquals(todo.text(), result.text());
        Assertions.assertEquals(todo.isCompleted(), result.isCompleted());
        Assertions.assertTrue(todos.contains(todo));
        Assertions.assertEquals(1, todos.size());
    }

    @Test
    void readAll() {

        Set<Todo> todos = new HashSet<>();
        TodoRepository todoRepository = new TodoRepository(todos);

        Set<Todo> result = todoRepository.readAll();

        Assertions.assertEquals(todos, result);
        Assertions.assertEquals(todos.size(), result.size());
    }

    @Test
    void readOneByText() {
        Todo todo2 = new Todo("2", "Cooking", true);
        Set<Todo> todos = new HashSet<>();
        todos.add(todo2);
        todos.add(todo);
        TodoRepository todoRepository = new TodoRepository(todos);

        Optional<Todo> result = todoRepository.readOneByText(todo2.text());

        Assertions.assertEquals(result, Optional.of(todo2));
    }

    @Test
    void update() {
        Todo updated = new Todo("1", "Workout", false);
        Set<Todo> todos = new HashSet<>();
        todos.add(todo);
        TodoRepository todoRepository = new TodoRepository(todos);

        Todo result = todoRepository.update(updated);

        Assertions.assertEquals(updated, result);
        Assertions.assertEquals(1, todos.size());

    }

    @Test
    void deleteOneById() {
        Todo otherTodo = new Todo("3", "Programming", true);
        Set<Todo> todos = new HashSet<>();
        todos.add(todo);
        todos.add(otherTodo);
        TodoRepository todoRepository = new TodoRepository(todos);

        todoRepository.deleteOneById(otherTodo.id());

        Assertions.assertTrue(todos.contains(todo));
        Assertions.assertEquals(1, todos.size());
    }

    @Test
    void deleteAll() {
        Set<Todo> todos = new HashSet<>();
        todos.add(todo);
        TodoRepository todoRepository = new TodoRepository(todos);

        todoRepository.deleteAll();

        // Assertions.assertTrue(todos.isEmpty());
        Assertions.assertEquals(0, todos.size());
    }
}