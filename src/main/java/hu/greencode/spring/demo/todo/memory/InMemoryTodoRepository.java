package hu.greencode.spring.demo.todo.memory;

import hu.greencode.spring.demo.todo.core.Todo;
import hu.greencode.spring.demo.todo.core.TodoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryTodoRepository implements TodoRepository {

    public Map<String, Todo> todos = new HashMap<String, Todo>();

    @Override
    public void save(Todo todo) {
        todos.put(todo.getId(), todo);
    }

    @Override
    public Todo find(String id) {
        return todos.get(id);
    }

    @Override
    public Collection<Todo> findAll() {
        return todos.values();
    }

    @Override
    public void delete(String id) {
        todos.remove(id);
    }
}