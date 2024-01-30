package com.me.dora.todos.controller;

import com.me.dora.todos.model.Todo;
import com.me.dora.todos.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @PostMapping
    Todo create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping
    Set<Todo> readAll() {
        return todoService.readAll();
    }

    @GetMapping("{text}")
    Todo readOneByText(@PathVariable String text) throws TodoNotFound {
        return todoService.readOneByText(text)
                .orElseThrow(TodoNotFound::new);
    }

    @PatchMapping
    Todo update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    void deleteOneById(@PathVariable String id) {
        todoService.deleteOneById(id);
    }

    @DeleteMapping
    void deleteAll() {
        todoService.deleteAll();
    }
}
