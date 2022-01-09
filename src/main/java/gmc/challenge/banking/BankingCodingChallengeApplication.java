package gmc.challenge.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BankingCodingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingCodingChallengeApplication.class, args);
	}
	
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
