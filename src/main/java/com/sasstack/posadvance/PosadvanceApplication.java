package com.sasstack.posadvance;

import com.sasstack.posadvance.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class PosadvanceApplication implements CommandLineRunner {

	@Autowired
	private UserRoleService userRoleService;

	public static void main(String[] args) {
		SpringApplication.run(PosadvanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRoleService.initializeRoles();
	}
}
