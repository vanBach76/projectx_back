package com.projectx;

import com.projectx.graphql.StaticRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Graphql-java docs: https://www.graphql-java.com/documentation/v15/
@SpringBootApplication
public class ProjectXApplication {

	public static void main(String[] args) {
		StaticRepository.init();
		SpringApplication.run(ProjectXApplication.class, args); // test -> http://localhost:8080/graphiql
	}

//	@Bean
//	public FilterRegistrationBean corsFilter() { //TODO:Read what filter is and why it's needed for CORS
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.addAllowedOrigin("*");
//		config.addAllowedHeader("*");
//		config.addAllowedMethod("*");
//		source.registerCorsConfiguration("/**", config);
//		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//		bean.setOrder(0);
//		return bean;
//	}

}
