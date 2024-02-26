package br.com.pyetro.memes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("br.com.pyetro.memes.repositories")
public class MemesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemesApplication.class, args);
	}

}
