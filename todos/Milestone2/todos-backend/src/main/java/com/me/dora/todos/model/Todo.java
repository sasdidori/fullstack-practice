package com.me.dora.todos.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String text;
    boolean isCompleted;

    public Todo(String text, boolean isCompleted) {
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public Todo(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return isCompleted == todo.isCompleted && Objects.equals(id, todo.id) && Objects.equals(text, todo.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, isCompleted);
    }
}
