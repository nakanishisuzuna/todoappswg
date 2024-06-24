package com.example.todoappswg.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.todoappswg.model.Todo;
import com.example.todoappswg.model.TodoWithoutId;

@Mapper
public interface TodoMapper {

    List<Todo> getAllTodos();

    Optional<Todo> getTodoById(Long id);

    void addTodo(TodoWithoutId todoWithoutId);

    //void updateTodo(Todo todo);
    
    void updateTodoNew(@Param("id") Long id, @Param("todo") Todo todo);

    void deleteTodoById(Long id);
    
    List<Todo> getTodosByStatus(String status);
    
    List<Todo> getTodosByTitle(String title);
    
    List<Todo> getTodosByStatusAndTitle(@Param("status") String status, @Param("title") String title);

}
