package com.example.todoappswg.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.example.todoappswg.model.Todo;
import com.example.todoappswg.model.TodoWithoutId;

@Mapper
public interface TodoMapper {

    List<Todo> getAllTodos();

    Optional<Todo> getTodoById(Long id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addTodo(TodoWithoutId todoWithoutId);

    void updateTodo(Todo todo);

    void deleteTodoById(Long id);
}
