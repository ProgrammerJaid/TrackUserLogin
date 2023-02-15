package in.finlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserActivityTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserActivityTrackerApplication.class, args);
	}
	
	@Bean
	PasswordEncoder password() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	RestTemplate getRestTmpl() {
		return new RestTemplate();
	}

}
