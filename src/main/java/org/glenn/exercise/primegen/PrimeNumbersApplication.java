package org.glenn.exercise.primegen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EnableCaching
public class PrimeNumbersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeNumbersApplication.class, args);
	}

}
