package com.me.dora.todos.service;

import com.me.dora.todos.model.Todo;
import com.me.dora.todos.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Set<Todo> readAll() {
        return new HashSet<>(todoRepository.findAll());
    }

    public Optional<Todo> readOneByText(String text) {
        return todoRepository.readOneByText(text);
    }

    public Todo update(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteOneById(String id) {
        todoRepository.deleteById(id);
    }

    public void deleteAll() {
        todoRepository.deleteAll();
    }
}
