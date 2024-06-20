package com.example.todoappswg.model;

import lombok.Data;

@Data
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



	/*public void remove() {

	}*/

}

//ToDoアプリケーションで使用する「ToDo」オブジェクトを定義
//ToDo項目のデータモデル
