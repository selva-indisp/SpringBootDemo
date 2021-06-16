package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfigurationDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.demo"))
				.build()
				.apiInfo(getSwaggerApiInfo());
	}

	private ApiInfo getSwaggerApiInfo() {
		return new ApiInfo("Demo Service", "Service to demonstrate spring boot framework", "1.0", "",
				new Contact("Selvakumar Mohan", null, "selvakumar.mohan@tide.co"),
				null, null, Collections.emptyList());
	}
}
