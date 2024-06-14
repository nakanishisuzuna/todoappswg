package com.example.todoappswg.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todoappswg.model.Todo;

@Service
public class TodoService {

	private List<Todo> toDos = new ArrayList<>(
			Arrays.asList(new Todo(1l, "タスクA", "未着手", "詳細A"), new Todo(2l, "タスクB", "未着手", "詳細B"),
					new Todo(3l, "タスクC", "未着手", "詳細C")));

	public List<Todo> toDos() {
		// TODO 自動生成されたメソッド・スタブ
		return toDos;
	}
}
