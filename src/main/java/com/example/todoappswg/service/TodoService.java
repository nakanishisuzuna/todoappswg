package com.example.todoappswg.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.todoappswg.model.Todo;

@Service
public class TodoService {

	private List<Todo> toDos = new ArrayList<>(
			Arrays.asList(new Todo(1l, "タスクA", "未着手", "詳細A"), new Todo(2l, "タスクB", "未着手", "詳細B"),
					new Todo(3l, "タスクC", "未着手", "詳細C")));

	//idCounter を最大 ID + 1 で初期化
	//map:Todoオブジェクト内のid分野
	public TodoService() {
		long maxId = toDos.stream().mapToLong(Todo::getId).max().orElse(0L);
		idCounter = new AtomicLong(maxId + 1);
	}

	public List<Todo> getAllTodos() {
		return toDos;
	}

	private AtomicLong idCounter = new AtomicLong(); // 次に使用するIDを管理

	public Todo addTodo(Todo todo) {
		todo.setId(idCounter.getAndIncrement()); // IDを自動的に設定
		toDos.add(todo);
		return todo;
	}

	//toDosリスト
	//filter()ストリームの中から条件に一致する要素だけを残す
	//ラムダ式(->)todoオブジェクトのgetIdメソッドを呼び出す
	//equals(id)現在のtodoのIDを取得・取得したIDと指定されたIDの比較
	//.findFirst()フィルタリングされたストリームの中から最初の要素を返す
	public Optional<Todo> getTodoById(Long id) {
		//toDosリスト内for文
		//equals(id)現在のtoのIDを取得・取得したIDと指定されたIDの比較
		for (Todo todo : toDos) {
			if (todo.getId().equals(id)) {
				return Optional.of(todo);
			}
		}
		return null;
		//return toDos.stream().filter(todo -> todo.getId().equals(id)).findFirst();
	}

	public Optional<Todo> deleteTodoById(Long id) {
		//toDosリスト内for文
		//equals(id)現在のtoのIDを取得・取得したIDと指定されたIDの比較
		//Optional<Todo> todoDelete = getTodoById(id);
		for (int i = 0; i < toDos.size(); i++) {
			if (toDos.get(i).getId().equals(id)) {
				Todo removedTodo=toDos.remove(i);
				return Optional.of(removedTodo);
			}
		}
		//toDos.removeIf(todo -> todo.getId().equals(id));
		return null;

	}

	public Todo updateTodo(Long id, Todo todo) {
		//toDosリスト内for文
		//equals(id)現在のtoのIDを取得・取得したIDと指定されたIDの比較
		for (int i = 0; i < toDos.size(); i++) {
			Todo to = toDos.get(i);
			if (to.getId().equals(id)) {
				todo.setId(id);//元のIDを保存しておく
				toDos.set(i, todo);
				return todo;
			}
		}
		return null;
	}
}
