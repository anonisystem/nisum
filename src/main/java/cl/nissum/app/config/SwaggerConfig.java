package cl.nissum.app.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.nissum.app.NissumApp;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(NissumApp.class.getPackage().getName()))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"MicroService Usuarios Nisum",
				"Micro servicio para consultar datos de la tabla Usuario",
				"0.0.1",
				"http://www.nissum.cl",
				new Contact("Nisum", null, null),
				null, null, Collections.emptyList());
	}

}
