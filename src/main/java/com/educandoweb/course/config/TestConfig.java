package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

// Classe de configuração para instanciar objetos
//Classe de configuração especifica para o perfil de testes
@Configuration
@Profile("test") // esse nome "test"(arquivo: application.properties ;linha: spring.profiles.active=test) tem que ser igual ao nome teste que foi colocado no profile -> spring.profiles.active=test
public class TestConfig implements CommandLineRunner{

	@Autowired // TestConfig depende de UserRepository-> essa anotação associa uma instância de UserRepository dentro de TestConfig
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Salvando usuários no banco de dados
		// chama o objeto userReposity que acessa os dados. A partir dele, chama a operação saveAll que salva uma 
		// lista no banco de dados
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
	
}
