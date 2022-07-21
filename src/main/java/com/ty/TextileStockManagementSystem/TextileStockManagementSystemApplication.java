package com.ty.TextileStockManagementSystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TextileStockManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextileStockManagementSystemApplication.class, args);
	}
	
	@SuppressWarnings("rawtypes")
	List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
	Contact contact = new springfox.documentation.service.Contact("soumya", "https://testyentra.com", "soumyabedakihal@mail.com");
	
	ApiInfo apiInfo = new ApiInfo("Test Yentra Textile Stock Management System App",
				"API's to person all actions related to a supplier,warehose,shop",
				"Snapshot-0.0.1", "https://testyantraglobal.com/", 
				contact, 
				"www.ty.com", 
				"terms and conditions",
				vendorExtensions);
	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ty"))
				.build()
				.apiInfo(apiInfo);
	}

}
