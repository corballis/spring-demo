package hu.greencode.spring.demo.todo;

import hu.greencode.spring.demo.todo.core.CoreConfiguration;
import hu.greencode.spring.demo.todo.core.TodoManager;
import hu.greencode.spring.demo.todo.memory.InMemoryConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TodoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(CoreConfiguration.class, InMemoryConfiguration.class);

        TodoManager todoManager = context.getBean(TodoManager.class);
        todoManager.manageTodos();
    }

}
