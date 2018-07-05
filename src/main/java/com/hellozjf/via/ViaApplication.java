package com.hellozjf.via;

import com.hellozjf.via.dao.QuestionDao;
import com.hellozjf.via.entity.QuestionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class ViaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(QuestionDao questionRepository) {
		return args -> {
		};
	}
}
