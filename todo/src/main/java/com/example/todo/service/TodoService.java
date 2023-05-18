package com.example.todo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.domain.Todo;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
	@Transactional
	public Todo updateTodo(Long id) {
		System.out.println("TodoService updateTodo 메소드 시작!! ");
		Todo updateTodo = null;
		try {
			updateTodo = todoRepository.findById(id).orElseThrow();
			updateTodo.setDone(!updateTodo.isDone());
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("TodoService updateTodo 메소드 끝!!!! ");
		}
		return updateTodo;
	}
	
	public void deleteTodo(Long id) {
		Optional<Todo> result =	todoRepository.findById(id);
		if(result.isEmpty())
			return;
		
		todoRepository.delete(result.get());
	}
}
