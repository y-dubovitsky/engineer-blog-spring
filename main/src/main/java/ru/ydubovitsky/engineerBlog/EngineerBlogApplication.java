package ru.ydubovitsky.engineerBlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EngineerBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(EngineerBlogApplication.class, args);
	}

}
