package hu.greencode.spring.demo.todo.core;

import java.util.Collection;

public interface TodoRepository {

    void save(Todo todo);

    Todo find(String id);

    Collection<Todo> findAll();

    void delete(String id);

}