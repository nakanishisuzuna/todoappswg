package com.example.todoappswg.model;

import lombok.Data;

@Data
public class TodoWithoutId {
    private String title;
    private String status;
    private String details;

public TodoWithoutId() {
}

public TodoWithoutId(String title, String status, String details) {

	this.title = title;
	this.status = status;
	this.details = details;
}
}
