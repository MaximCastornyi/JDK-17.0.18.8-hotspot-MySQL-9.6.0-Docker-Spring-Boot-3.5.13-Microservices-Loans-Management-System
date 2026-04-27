package com.netsdevs.accounts;

import com.netsdevs.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
/*@ComponentScans({ @ComponentScan("com.netsdevs.accounts.controller") })
@EnableJpaRepositories("com.netsdevs.accounts.repository")
@EntityScan("com.netsdevs.accounts.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "NetsDevs Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Maxim Castornyi",
						email = "nets.devs@gmail.com",
						url = "https://netsdevs.web.app/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://netsdevs.web.app/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "NetsDevs Accounts microservice REST API Documentation",
				url = "https://netsdevs.web.app/swagger-ui.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
