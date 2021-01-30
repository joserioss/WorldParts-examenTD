package cl.jrios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cl.jrios.utility.AplicacionChequeoMargen;

@SpringBootApplication
public class JoseRiosWorldPartsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoseRiosWorldPartsApplication.class, args);
		
		AplicacionChequeoMargen.aplicacionCheck();
	}

}
