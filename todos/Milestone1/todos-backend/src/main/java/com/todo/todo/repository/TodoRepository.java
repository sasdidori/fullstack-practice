package com.todo.todo.repository;

import com.todo.todo.model.Todo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class TodoRepository {

    private final Set <Todo> todos;
    public TodoRepository(Set<Todo> todos) {
        this.todos = todos;
    }

    public Todo create(Todo todo) {
        Todo newTodo = new Todo(todo.id(), todo.text(), todo.isCompleted());
        todos.add(newTodo);
        return newTodo;
    }

    public Set<Todo> readAll() {
        return new HashSet<>(todos);
    }

    public Optional<Todo> readOneByText(String text) {
       return todos.stream()
                .filter(todo -> todo.text().equals(text))
                .findFirst();
    }

    public Todo update(Todo todo) {
        deleteOneById(todo.id());
        todos.add(todo);
        return todo;
    }

    public void deleteOneById(String id) {
        todos.removeIf(todo -> todo.id().equals(id));
    }

    public void deleteAll() {
        todos.clear();
    }
}
