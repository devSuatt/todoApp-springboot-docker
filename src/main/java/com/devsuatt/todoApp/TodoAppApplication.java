package com.devsuatt.todoApp;

import com.devsuatt.todoApp.model.User;
import com.devsuatt.todoApp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class TodoAppApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	public TodoAppApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = userRepository.save(new User("", "suat", "test123", new HashSet<>()));
		System.out.println(user);
	}

}
