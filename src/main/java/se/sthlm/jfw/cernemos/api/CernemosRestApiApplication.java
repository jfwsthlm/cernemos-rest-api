package se.sthlm.jfw.cernemos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CernemosRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CernemosRestApiApplication.class, args);
	}

}
