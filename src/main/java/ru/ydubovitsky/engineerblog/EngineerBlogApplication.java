package ru.ydubovitsky.engineerblog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.ydubovitsky.engineerblog.entity.Role;
import ru.ydubovitsky.engineerblog.entity.User;
import ru.ydubovitsky.engineerblog.service.RoleService;
import ru.ydubovitsky.engineerblog.service.UserService;

import java.util.Set;

@Slf4j
@SpringBootApplication
public class EngineerBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(EngineerBlogApplication.class, args);
	}

	//FIXME Убрать это? заменить скриптом?
	@Bean
	CommandLineRunner run(RoleService roleService, UserService userService) {
		return args -> {
			User admin = userService.getUserByUsername("u");
			if(admin == null) {
				if(roleService.getByName("ROLE_USER") == null) {
					Role role = new Role(null, "ROLE_USER");
					roleService.saveRole(role);
				}

				User superAdmin = new User();
				superAdmin.setUsername("u");
				superAdmin.setPassword("u");
				superAdmin.setRoles(Set.of(roleService.getByName("ROLE_USER")));

				userService.add(superAdmin);
				log.info("u created!");
			}
		};
	}
}
