package com.jp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application {

	@Value("${server.port}")
	private int serverPort;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct()
	public void onStart() throws Exception {

		System.out.println("*** Application started at PORT : " + serverPort);
		log.info("*** Application started at PORT : ", serverPort);
	}

	@PreDestroy
	public void onExit() {
		System.out.println("*** Application stopped.");
		log.info("*** Application stopped.");
	}

}
