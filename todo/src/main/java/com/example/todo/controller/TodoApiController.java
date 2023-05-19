package com.example.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.domain.Todo;
import com.example.todo.service.TodoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
@Tag(name="todos", description = "ToDo api!!!")
public class TodoApiController {
	
	private final TodoService todoService;
	
//	public TodoApiController(TodoService todoService) {
//		this.todoService = todoService;
//	}
	
	@Operation(summary = "get Todos", description = "모든 할일 목록을 가져옵니다.")
	@GetMapping
	public List<Todo> getTodos(){
		return todoService.getTodos();
	}
	
	@Parameters({
		@Parameter(name="id", description = "Todo id", example = "7")
	})
	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable("id")Long id) {
		return todoService.getTodo(id);
	}
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK!!"),
			@ApiResponse(responseCode = "400", description = "요청을 살펴봐요..")
	})
	@PostMapping
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo.getTodo());
	}
	
	@PatchMapping
	public Todo updatTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo.getId());
	}
	@DeleteMapping("/{id}")
	public String deleteTodo(@PathVariable("id") Long id) {
		todoService.deleteTodo(id);
		return "delete Ok!!";
	}
	
}
