package com.example.todoappswg.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todoappswg.model.Todo;
import com.example.todoappswg.service.TodoService;

@RequestMapping("/api/todos")
public class TodoController {
	//フィールド宣言
	private TodoService todoService;

	// コンストラクタでTodoServiceを注入する
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/todos")
	public List<Todo> toDos() {
		return todoService.toDos();
	}

	@PostMapping("/todos")
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo);
	}

}