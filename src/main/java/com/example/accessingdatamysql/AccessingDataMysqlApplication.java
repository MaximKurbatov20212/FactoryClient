package com.example.accessingdatamysql;

import javafx.application.Application;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataMysqlApplication {
	@Bean
	public FxWeaver fxWeaver(ConfigurableApplicationContext context) {
		return new SpringFxWeaver(context);
	}
	public static void main(String[] args) {
		Application.launch(JavaFxApplication.class, args);
//		SpringApplication.run(AccessingDataMysqlApplication.class, args);
	}
}
