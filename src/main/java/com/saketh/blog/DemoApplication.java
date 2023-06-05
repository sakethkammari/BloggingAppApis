package com.saketh.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(scanBasePackages = {"com.saketh.config","com.saketh.controllers","com.saketh.entities","com.saketh.exceptions","com.saketh.payloads","com.saketh.repositories","com.saketh.services","com.saketh.services.impl","com.saketh.blog.utils" };
@SpringBootApplication
//@ComponentScan({"com.saketh.config","com.saketh.controllers","com.saketh.entities","com.saketh.exceptions","com.saketh.payloads","com.saketh.repositories","com.saketh.services","com.saketh.services.impl","com.saketh.blog.utils"})
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}

}
