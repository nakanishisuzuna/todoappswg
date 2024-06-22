package com.example.todoappswg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoappswg.model.Todo;
import com.example.todoappswg.model.TodoWithoutId;
import com.example.todoappswg.service.TodoService;

@RestController
@RequestMapping("/api")
public class TodoController {
	//フィールド宣言
	private TodoService todoService;

	// コンストラクタでTodoServiceを注入する
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/todos")
	public List<Todo> getAllTodos() {
		System.out.println("中西さん");
		return todoService.getAllTodos();
	}

	@PostMapping("/todos")
	public TodoWithoutId addTodo(@RequestBody TodoWithoutId todoWithoutId) {
		System.out.println("POST中西さん1");
		return todoService.addTodo(todoWithoutId);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/todo2")
	public Todo addTodo2(@RequestBody Todo todo) {
		System.out.println("POST中西さん2");
		return todoService.addTodo(todo);
	}

	//idのTodo一覧を取得
	//PathVariable:URLのパス部分に渡された値を変数として取り出して利用する機能
	@GetMapping("/todos/{id}")
	public Optional<Todo> getTodoById(@PathVariable Long id) {
		return todoService.getTodoById(id);
	}

	@DeleteMapping("/todos/{id}")
	public void deleteTodoById(@PathVariable Long id) {
		todoService.deleteTodoById(id);
	}

	@PutMapping("/todos/{id}")
	public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
		return todoService.updateTodo(id, todo);
	}

	@PutMapping("/todos2/{id}")
	public void updateTodo2(@PathVariable Long id, @RequestBody Todo todo) {
		todoService.updateTodo(id, todo);
	}

}