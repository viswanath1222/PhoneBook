package com.vi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages ={"com.vi.controllers","com.vi.service","com.vi.dao","com.vi.entity"} )
public class PhoneBookApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(PhoneBookApp1Application.class, args);
	}

}
