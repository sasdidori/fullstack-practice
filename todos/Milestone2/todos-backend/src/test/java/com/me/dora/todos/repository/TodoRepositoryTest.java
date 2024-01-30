package com.me.dora.todos.repository;

import com.me.dora.todos.model.Todo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    TodoRepository todoRepository;

    Todo todo = new Todo("programming", true);

    @BeforeEach
    void save() {
        todoRepository.save(todo);
    }

    @AfterEach
    void delete() {
        todoRepository.deleteAll();
    }

    @Test
    void readOneByText() {
        Optional<Todo> result = todoRepository.readOneByText(todo.getText());
        Assertions.assertEquals(Optional.of(todo), result);
    }
}
