package com.getir.readingisgood;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

	private String name;

	private String description;

	private String termOfServiceUrl;

	private String version;

	private String license;

	private String licenseUrl;

	private String contactName;

	private String contactURL;

	private String contactEmail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTermOfServiceUrl() {
		return termOfServiceUrl;
	}

	public void setTermOfServiceUrl(String termOfServiceUrl) {
		this.termOfServiceUrl = termOfServiceUrl;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicenseUrl() {
		return licenseUrl;
	}

	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactURL() {
		return contactURL;
	}

	public void setContactURL(String contactURL) {
		this.contactURL = contactURL;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("name")
				.directModelSubstitute(LocalDateTime.class, String.class)
				.directModelSubstitute(LocalDate.class, String.class)
				.directModelSubstitute(LocalTime.class, String.class)
				.directModelSubstitute(ZonedDateTime.class, String.class)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.getir.readingisgood.controller"))
				.paths(any())
				.build()
				.apiInfo(apiInfo());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder
				.builder()
				.deepLinking(true)
				.docExpansion(DocExpansion.NONE)
				.showExtensions(true)
				.defaultModelExpandDepth(1)
				.defaultModelsExpandDepth(1)
				.operationsSorter(OperationsSorter.ALPHA)
				.build();
	}

	private ApiInfo apiInfo() {
		final Contact contact = new Contact(contactName, contactURL, contactEmail);
		return new ApiInfo(name, description, version, termOfServiceUrl, contact, license, licenseUrl, Collections.emptyList());
	}
}