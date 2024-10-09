package com.bncmy.clientes.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.select().apis(RequestHandlerSelectors.basePackage("com.efectivale.jwtServer.controller"))
				.paths(PathSelectors.any()).build().apiInfo(metaData())
				.securitySchemes(Arrays.asList(basicAuthScheme()))
				.useDefaultResponseMessages(false);
		return docket;
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("f").description("")
				.version("").license("")
				.licenseUrl("").build();
	}
	private SecurityScheme basicAuthScheme() {
		return new BasicAuth("basicAuth");
	}     
	
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addResourceHandlers(ResourceHandlerRegistry registry) {
	            registry.addResourceHandler("swagger-ui.html")
	                    .addResourceLocations("classpath:/META-INF/resources/");
	            registry.addResourceHandler("/webjars/**")
	                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
	        }
	    };
	}
}
