package com.example.todoappswg.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todoappswg.model.Todo;

@Service
public class TodoService {

	private List<Todo> toDos = new ArrayList<>(
			Arrays.asList(new Todo(1l, "タスクA", "未着手", "詳細A"), new Todo(2l, "タスクB", "未着手", "詳細B"),
					new Todo(3l, "タスクC", "未着手", "詳細C")));

	public List<Todo> getAllTodos() {
		return toDos;
	}

	public Todo addTodo(Todo todo) {
		toDos.add(todo);
		return todo;
	}

	//toDosリスト
	//filter()ストリームの中から条件に一致する要素だけを残す
	//ラムダ式(->)todoオブジェクトのgetIdメソッドを呼び出す
	//equals(id)現在のtodoのIDを取得・取得したIDと指定されたIDの比較
	//.findFirst()フィルタリングされたストリームの中から最初の要素を返す
	public Optional<Todo> getTodoById(Long id) {
		return toDos.stream().filter(todo -> todo.getId().equals(id)).findFirst();
	}

	public void deleteTodoById(Long id) {
		toDos.removeIf(todo -> todo.getId().equals(id));

	}
}
