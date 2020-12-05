package br.com.afrodev.apiBlackLivesMatter.config;

import java.util.ArrayList; 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration   //Informar que é uma classe de configuração
@EnableSwagger2 //Ativar o Swagger 2
public class SwaggerConfig {
	
	@Bean //Informa que uma classe externa foi importada para dentro da aplicação
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.afrodev.apiBlackLivesMatter")) 
				.paths(PathSelectors.regex("/api/BLM.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		
		ApiInfo apiInfo = new ApiInfo(
				"Spring Boot Swagger",
				"Black Lives Matter - Why Do We Fight",
				"1.0",
				"Term of Service",
				new Contact("Zaira Oliveira", "https://github.com/zaira-oliveira/apiBlackLivesMatter",
						"zfeitosa9@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>()
				);
			return apiInfo;
	}
}