package com.me.dora.todos.repository;

import com.me.dora.todos.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, String> {
    Optional<Todo> readOneByText(String text);

}
