package tech.devinhouse.pets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tech.devinhouse.pets.security.JwtTokenProvider;

@SpringBootApplication
public class PetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsApplication.class, args);
		System.out.println("Tutor: " + new JwtTokenProvider().generateToken("paulakaminski"));
		System.out.println("Adotante: " + new JwtTokenProvider().generateToken("marcelsantin"));
	}

}
