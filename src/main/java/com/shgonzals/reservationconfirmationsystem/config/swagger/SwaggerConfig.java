package com.shgonzals.reservationconfirmationsystem.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
							  .title("Reservation API")
							  .version("1.0.0"));
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				 .group("public-apis")
				 .pathsToMatch("/**")
				 .pathsToExclude("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/webjars/**")
				 .build();
	}


}
