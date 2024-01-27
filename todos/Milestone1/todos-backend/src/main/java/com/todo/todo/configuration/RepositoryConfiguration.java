package com.todo.todo.configuration;

import com.todo.todo.model.Todo;
import com.todo.todo.repository.TodoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RepositoryConfiguration {

    @Bean
    TodoRepository todoRepository(){
        Set<Todo> todos = new HashSet<>();
        return new TodoRepository(todos);
    }
}
