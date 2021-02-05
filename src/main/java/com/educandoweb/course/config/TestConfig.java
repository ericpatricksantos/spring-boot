package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

// Classe de configuração para instanciar objetos
//Classe de configuração especifica para o perfil de testes
@Configuration
@Profile("test") // esse nome "test"(arquivo: application.properties ;linha:
					// spring.profiles.active=test) tem que ser igual ao nome teste que foi colocado
					// no profile -> spring.profiles.active=test
public class TestConfig implements CommandLineRunner {

	@Autowired // TestConfig depende de UserRepository-> essa anotação associa uma instância de
				// UserRepository dentro de TestConfig
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        
     
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "5555", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); // Associação entre objetos. Passando o usuário através do construtor
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		// Salvando usuários no banco de dados
		// chama o objeto userReposity que acessa os dados. A partir dele, chama a
		// operação saveAll que salva uma
		// lista no banco de dados

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}

}
