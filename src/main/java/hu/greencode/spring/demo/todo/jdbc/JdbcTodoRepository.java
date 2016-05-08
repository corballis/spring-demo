package hu.greencode.spring.demo.todo.jdbc;

import hu.greencode.spring.demo.todo.core.Todo;
import hu.greencode.spring.demo.todo.core.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Repository("db")
public class JdbcTodoRepository implements TodoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Todo> rowMapper = new RowMapper<Todo>() {
        @Override
        public Todo mapRow(ResultSet resultSet, int i) throws SQLException {
            Todo todo = new Todo();
            todo.setId(resultSet.getString("id"));
            todo.setTask(resultSet.getString("task"));
            return todo;
        }
    };

    @PostConstruct
    public void createTodoTable() {
        jdbcTemplate.execute("create table todo (id VARCHAR(200), task VARCHAR(500))");
    }

    @Override
    public void save(Todo todo) {
        jdbcTemplate.update("insert into todo (id, task) values (?, ?)", todo.getId(), todo.getTask());
    }

    @Override
    public Todo find(String id) {
        return jdbcTemplate.queryForObject("select id, task from todo where id = ?", new Object[] {id}, rowMapper);
    }

    @Override
    public Collection<Todo> findAll() {
        return jdbcTemplate.query("select id, task from todo", rowMapper);
    }

    @Override
    public void delete(String id) {
        jdbcTemplate.update("delete from todo where id = ?", id);
    }
}
