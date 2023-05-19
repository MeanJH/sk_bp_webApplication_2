package com.example.todo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.domain.Todo;

@SpringBootTest
@Transactional
public class TodoServiceTest {
	@Autowired
	TodoService todoService;
	
	private static Logger logger = LoggerFactory.getLogger(TodoService.class);
	
	@BeforeAll
	static void setUp() {
		logger.info("---------> @BeforeAll  전체 테스트가 시작되기 전!! ");
	}
	
	@AfterAll
	static void tearDown() {
		logger.info("---------> @AfterAll  전체 테스트가 끝난 후!! ");
	}
	
	@Test
	void test() {
		logger.info("test 메소드 실행!! ");
	}
	
	@BeforeEach
	void intit() {
		logger.info("---------> @BeforeEach  각각 테스트가 시작되기 전 매번 실행! ");
	}
	@AfterEach
	void dispose() {
		logger.info("---------> @AfterEach  각각 테스트가 끝난 후 매번 실행! ");
	}
	@Test
	void test2() {
		logger.info("test2 메소드 실행!! ");
	}
	
	@Test
	void addTodo() throws Exception{
		Todo todo =	todoService.addTodo("junit study33!!");
		
		assertNotNull(todo);
		assertEquals(todo.getTodo(), "junit study33!!");
	}
	
	@Test
	void getTodo() throws Exception{
		assertNotNull(todoService.getTodo(5L));
		
		Todo todo = todoService.getTodo(14L);
		
		assertEquals(todo.getTodo(), "string");
	}
	
	@Test
	void updateTodo() {
		Todo findTodo = todoService.getTodo(6L);
		boolean done = findTodo.isDone();
		Todo updateTodo = todoService.updateTodo(6L);
		
//		assertEquals(findTodo, updateTodo);
		
		assertNotEquals(done, updateTodo.isDone());
	}
}
