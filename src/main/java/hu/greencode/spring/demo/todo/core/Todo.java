package hu.greencode.spring.demo.todo.core;

import java.util.UUID;

public class Todo {

    private String id;

    private String task;

    public Todo() {
        this.id = UUID.randomUUID().toString();
    }

    public Todo(String task) {
        this();
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Todo");
        sb.append("[id='").append(id).append('\'');
        sb.append(", task='").append(task).append('\'');
        sb.append(']');
        return sb.toString();
    }
}