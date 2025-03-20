package app.trekz;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrekzApplication {

	public static void main(String[] args) {
		// Load env variables
		Dotenv dotenv = Dotenv.load();

		// Set system properties

		// DB
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("DB_URL", dotenv.get("DB_URL"));

		// JWT Settings
		System.setProperty("security.jwt.secret-key", dotenv.get("JWT_SECRET"));
		System.setProperty("security.jwt.expiration-time", dotenv.get("JWT_EXPIRATION"));

		SpringApplication.run(TrekzApplication.class, args);
	}

}
