package dev.venkat.MoviesReality;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MoviesRealityApplication {

	public static void main(String[] args) {
		// Loading env files
		Dotenv dotenv = Dotenv.load();

		//Accessing env variables
		String mongodb = dotenv.get("MONGO_DATABASE");
		String mongoUser = dotenv.get("MONGO_USER");
		String mongoPass = dotenv.get("MONGO_PASSWORD");
		String mongoCluster = dotenv.get("MONGO_CLUSTER");

		// Setting env variables
		System.setProperty("env.MONGO_DATABASE", mongodb);
		System.setProperty("env.MONGO_USER", mongoUser);
		System.setProperty("env.MONGO_PASSWORD", mongoPass);
		System.setProperty("env.MONGO_CLUSTER", mongoCluster);

		SpringApplication.run(MoviesRealityApplication.class, args);
	}

	@GetMapping("/root")
	public String apiRoot() {
		return "Hello World!";
	}

}
