package hu.greencode.spring.demo.todo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoManager {

    @Autowired
    private TodoRepository repository;

    public void manageTodos() {
        System.out.println("TODOs at startup");
        System.out.println(repository.findAll());

        System.out.println("Create some todos");
        Todo todo1 = new Todo("first task");
        repository.save(todo1);
        repository.save(new Todo("second task"));

        System.out.println("TODOs after creation");
        System.out.println(repository.findAll());

        System.out.println("Find first task");
        System.out.println(repository.find(todo1.getId()));

        System.out.println("Delete first task");
        repository.delete(todo1.getId());

        System.out.println("TODOs at the end");
        System.out.println(repository.findAll());
    }

}
