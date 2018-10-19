package com.alevel.todos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Todo {
    private final Long id;
    private String text;
    private Boolean done;

    public Todo(String text) {
        this.id = null;
        this.text = text;
        this.done = false;
    }
    @JsonCreator
    public Todo(
        @JsonProperty("id") Long id,
        @JsonProperty("text") String text,
        @JsonProperty("done") Boolean done
    ){
        this.id=id;
        this.text=text;
        this.done=done;
    }


    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public boolean equals(Object o) {
        if (
                this == o
        ) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return done == todo.done &&
                Objects.equals(id, todo.id) &&
                Objects.equals(text, todo.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, done);
    }
}
