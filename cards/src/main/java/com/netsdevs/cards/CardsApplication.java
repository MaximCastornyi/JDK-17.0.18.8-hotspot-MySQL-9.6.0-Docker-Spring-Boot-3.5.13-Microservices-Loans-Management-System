package com.netsdevs.cards;

import com.netsdevs.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.netsdevs.cards.controller") })
@EnableJpaRepositories("com.netsdevs.cards.repository")
@EntityScan("com.netsdevs.cards.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {CardsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "NetsDevs Cards microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Maxim Castornyi",
						email = "netsdevs@gmail.com",
						url = "https://netsdevs-2024.web.app"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://netsdevs-2024.web.app"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "NetsDevs Cards microservice REST API Documentation",
				url = "https://netsdevs-2024.web.app/swagger-ui.html"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
}

