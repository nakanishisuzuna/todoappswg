package com.example.todoappswg.model;

import lombok.Data;

@Data
public class TodoWithoutId {
	private Long userId;
    private String title;
    private String status;
    private String details;

public TodoWithoutId() {
}

public TodoWithoutId(Long userId,String title, String status, String details) {
	this.userId=userId;
	this.title = title;
	this.status = status;
	this.details = details;
}

public void setId(Long id) {
}
}
