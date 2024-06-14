package com.example.todoappswg.model;

public class Todo {
	//Todoクラスのインスタンスが持つ４つの属性（フィールド）を定義
	private Long id;
	private String title;
	private String status;
	private String details;

	public Todo() {
	}

	public Todo(Long id, String title, String status, String details) {

		this.id = id;
		this.title = title;
		this.status = status;
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}

//ToDoアプリケーションで使用する「ToDo」オブジェクトを定義
//ToDo項目のデータモデル
