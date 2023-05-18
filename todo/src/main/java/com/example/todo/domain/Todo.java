package com.example.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="todos")
@Getter
@Setter
@ToString
public class Todo {
	@Id
	@GeneratedValue
	private Long id;
	private String todo;
	private boolean done;
}
