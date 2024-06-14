package com.example.todoappswg.model;

public class Todo {
	//Todoクラスのインスタンスが持つ5つの属性（フィールド）を定義
	private Long id;
	private String title;
	private String status;
	private long createdAt;//作成タイムスタンプ
	private long updatedAt;//更新タイムスタンプ

	public Todo() {
	}

	public Todo(Long id, String title, String status) {

		this.id = id;
		this.title = title;
		this.status = status;
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

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}

}

//ToDoアプリケーションで使用する「ToDo」オブジェクトを定義
//ToDo項目のデータモデル
