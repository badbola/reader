package com.natwest.reader.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import lombok.RequiredArgsConstructor;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Divyanshu Singh on 26-03-2022
 */

@Configuration
@RequiredArgsConstructor
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any()/* withMethodAnnotation(ApiOperation.class) */)
				.paths(PathSelectors.any()).build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {

		return new ApiInfo("NatWest Api Documentation", "REST API for NatWest read application", "1.0",
				"Terms of service", ApiInfo.DEFAULT_CONTACT, "NatWest", null, new ArrayList<>());
	}


}
