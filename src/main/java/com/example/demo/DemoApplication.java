package com.example.demo;

import com.example.demo.infraestructure.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	private MessageRepository repository;
	public DemoApplication(MessageRepository repository){
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		repository.findAll().forEach(meesage ->
			System.out.println(meesage.toString())
		);
	}
}
