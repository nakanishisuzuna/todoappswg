package com.example.todoappswg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoappswg.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}

//「ToDo」オブジェクトのためのリポジトリ