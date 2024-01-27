package com.todo.todo.service;

import com.todo.todo.model.Todo;
import com.todo.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(Todo todo) {
        return todoRepository.create(todo);
    }

    public Set<Todo> readAll() {
        return todoRepository.readAll();
    }

    public Optional<Todo> readOneByText(String text) {
        return todoRepository.readOneByText(text);
    }

    public Todo update(Todo todo) {
        return todoRepository.update(todo);
    }

    public void deleteOneById(String id) {
        todoRepository.deleteOneById(id);
    }

    public void deleteAll() {
        todoRepository.deleteAll();
    }
}
