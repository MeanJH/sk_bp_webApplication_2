package com.example.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.todo.domain.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	TodoService todoService;
	@Override
	public void run(String... args) throws Exception {
		//1. 저장 
//		Todo todo = new Todo();
//		todo.setTodo("jpa study!!! 666");  // 비영속상태
//		
//		Todo saveTodo = todoRepository.save(todo);
//		
//		System.out.println(saveTodo);
//		System.out.println(todo);
//		System.out.println(saveTodo == todo);
//		
		
		//2. 한 건 조회
//		Todo findTodo = todoRepository.findById(4L).orElseThrow();
//		System.out.println(findTodo);
		
		//3. 여러건 조회 
		List<Todo> todos = null;
		
//		todos = todoRepository.findAll();
		
		Pageable pageable = PageRequest.of(1, 3, Sort.by("id").descending());
		
//		todos = todoRepository.findAll(pageable).getContent();
				
		
		
		
		//4. 수정 
//		Todo updateTodo = todoRepository.findById(4L).get();
//		
////		updateTodo.setDone(true);
//		System.out.println("before");
//		todoService.updateTodo(4L);
//		System.out.println("after!!");
		
		//5. 삭제
//		todoService.deleteTodo(4L);
//		
//		//6. findByTodo 를 이용한 조회
//		Todo findTodo = todoRepository.findByTodo("jpa study!!! 111").get(); 
//		
//		System.out.println(findTodo);
//		
		
		//7. findByTodoContaining 이용한 조회
		
//		todos = todoRepository.findByTodoContaining("jpa", pageable);
		
//		todos = todoRepository.findByTodoAndDone("jpa", false);
		
//		todos = todoRepository.findTodos("jpa",pageable);
		
		todos = todoRepository.findTodos2("jpa",pageable);
		
		for (Todo todo : todos) {
			System.out.println(todo);
		}
		
	}

}
