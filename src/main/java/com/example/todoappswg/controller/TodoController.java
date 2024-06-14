package com.example.todoappswg.controller;

import com.example.todoappswg.service.TodoService;

public class TodoController {
	//フィールド宣言
	private TodoService todoService;

	// コンストラクタでTodoServiceをインジェクトする
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

}

//githubテスト