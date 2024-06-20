package com.example.todoappswg.mapper;

import java.util.List;
import java.util.Optional;

import com.example.todoappswg.model.Todo;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todo")
    List<Todo> getAllTodos();

    @Select("SELECT * FROM todo WHERE id = #{id}")
    Optional<Todo> getTodoById(Long id);

    @Insert("INSERT INTO todo (title, status, details) VALUES (#{title}, #{status}, #{details})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addTodo(Todo todo);

    @Update("UPDATE todo SET title = #{title}, status = #{status}, details = #{details} WHERE id = #{id}")
    void updateTodo(Todo todo);

    @Delete("DELETE FROM todo WHERE id = #{id}")
    void deleteTodoById(Long id);
}
