package com.example.apirest;

import com.example.apirest.entities.Persona;
import com.example.apirest.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ApirestApplication {

	private static final Logger logger = LoggerFactory.getLogger(ApirestApplication.class);
	@Autowired
	private PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository) {
		return args -> {
			Persona p1 = Persona.builder()
					.dni(44625892)
					.nombre("Manuel")
					.apellido("Vazquez")
					.build();
			personaRepository.save(p1);
			logger.info("Persona guardada: {}", p1);

			Persona p2 = Persona.builder()
					.dni(22059809)
					.nombre("Laura")
					.apellido("Rios")
					.build();
			personaRepository.save(p2);
			logger.info("Persona guardada: {}", p2);
		};
	}
}