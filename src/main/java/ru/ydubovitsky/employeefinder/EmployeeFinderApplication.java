package ru.ydubovitsky.employeefinder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.ydubovitsky.employeefinder.entity.Role;
import ru.ydubovitsky.employeefinder.entity.User;
import ru.ydubovitsky.employeefinder.service.RoleService;
import ru.ydubovitsky.employeefinder.service.UserService;

import java.util.Set;

@Slf4j
@SpringBootApplication
public class EmployeeFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeFinderApplication.class, args);
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
