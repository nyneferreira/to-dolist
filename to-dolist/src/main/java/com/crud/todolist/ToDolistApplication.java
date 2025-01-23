package com.crud.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ToDolistApplication {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder toDolistApplication) {
        return toDolistApplication.sources(ToDolistApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(ToDolistApplication.class, args);
	}

}
