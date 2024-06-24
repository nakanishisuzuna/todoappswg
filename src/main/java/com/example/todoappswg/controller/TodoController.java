package com.example.todoappswg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoappswg.model.Todo;
import com.example.todoappswg.model.TodoWithoutId;
import com.example.todoappswg.service.TodoService;

import lombok.Data;

@RestController
@RequestMapping("/api")
public class TodoController {
	
	//フィールド宣言
	@Autowired
	private TodoService todoService;

	// コンストラクタでTodoServiceを注入する
	//public TodoController(TodoService todoService) {
		//this.todoService = todoService;
	//}

	@GetMapping("/todos")
	@ResponseStatus(HttpStatus.OK)
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

	@PostMapping("/todos")
	public ResponseEntity<TodoWithoutId> addTodo(@RequestBody TodoWithoutId todoWithoutId) {
		TodoWithoutId createdTodo = todoService.addTodo(todoWithoutId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
		//return todoService.addTodo(todoWithoutId);
	}

	//idのTodo一覧を取得
	//PathVariable:URLのパス部分に渡された値を変数として取り出して利用する機能
	@GetMapping("/todos/{id}")
	public ResponseEntity<?> getTodoById(@PathVariable Long id) {
        try {
            Optional<Todo> todo = todoService.getTodoById(id);
            if (todo == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Not Found", "TODO not found"));
            }
            return ResponseEntity.ok(todo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Unauthorized", e.getMessage()));
        }
    }

	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<String> deleteTodoById(@PathVariable Long id) {
        /*try {
            boolean deleted = todoService.deleteTodoById(id);
            if (!deleted) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Not Found", "Todo not found"));
            }*/
            return ResponseEntity.ok("TODO deleted");
        /*} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Unauthorized", e.getMessage()));
        }*/
    }

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/todos/{id}")
	public void updateTodoById(@PathVariable Long id,@RequestBody Todo todo) {
		todoService.updateTodo(id, todo);
	}
	
	@GetMapping("/todos/filter")
    public List<Todo> filterTodos(@RequestParam(required = false) String status,
                                  @RequestParam(required = false) String title) {
        if (status != null && title != null) {
            return todoService.getTodosByStatusAndTitle(status, title);
        } else if (status != null) {
            return todoService.getTodosByStatus(status);
        } else if (title != null) {
            return todoService.getTodosByTitle(title);
        } else {
            return todoService.getAllTodos();
        }
    }
	
	 @GetMapping("/success")
	    @ResponseStatus(HttpStatus.OK) // 200 OKを指定
	    public String success() {
	        return "Success";
	    }

	    @GetMapping("/created")
	    @ResponseStatus(HttpStatus.CREATED) // 201 Createdを指定
	    public String created() {
	        return "TODO Created";
	    }

	    @GetMapping("/notfound")
	    @ResponseStatus(HttpStatus.NOT_FOUND) // 404 Not Foundを指定
	    public String notFound() {
	        return "TODO Not Found";
	    }

	
	@Data
	private static class ErrorResponse {
        private String error;
        private String message;

        public ErrorResponse(String error, String message) {
            this.error = error;
            this.message = message;
        }
	}


}