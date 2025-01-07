package app.bola.orderservice;

import org.springframework.boot.SpringApplication;

public class TestEmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(EmailServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
