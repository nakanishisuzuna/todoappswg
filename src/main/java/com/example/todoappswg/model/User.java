package com.example.todoappswg.model;

import lombok.Data;

@Data
public class User {
	private Long id;
    private Long userId;
    private String password; // ハッシュ化して保存する
    private String email;
}
