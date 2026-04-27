package com.netsdevs.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.netsdevs.loans.controller") })
@EnableJpaRepositories("com.netsdevs.loans.repository")
@EntityScan("com.netsdevs.loans.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "NetsDevs Bank Loans microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Maxim Castornyi",
						email = "nets.devs@gmail.com",
						url = "https://netsdevs-2024.web.app"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://netsdevs-2024.web.app"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "NetsDevs Bank Loans microservice REST API Documentation",
				url = "https://netsdevs-2024.web.app/swagger-ui.html"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}
}