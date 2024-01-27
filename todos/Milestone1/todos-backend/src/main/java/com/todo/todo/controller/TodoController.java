package com.todo.todo.controller;

import com.todo.todo.model.Todo;
import com.todo.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:5173/" )
@RestController
@RequestMapping("todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    //create
    Todo create (@RequestBody Todo todo){
        return todoService.create(todo);
    }

    @GetMapping
    //readAll
    Set <Todo> readAll(){
        return todoService.readAll();
    }

    @GetMapping("{text}")
    //readOne
    Todo readOneByText(@PathVariable String text) throws TodoNotFound{
        return todoService.readOneByText(text)
                .orElseThrow(TodoNotFound::new);
    }

    @PatchMapping
    //update
    Todo update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    //delete
    void deleteOneById(@PathVariable String id){
        todoService.deleteOneById(id);
    }

    @DeleteMapping
    //deleteAll
    void deleteAll(){
        todoService.deleteAll();
    }

}
