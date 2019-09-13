package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SampleApplication {

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@RequestMapping
	public String ping(){

		try {
			String body = restTemplate.getForEntity("https://www.google.com/", String.class).getBody();
			System.out.println(body);

			Thread.sleep(2000);

			String serviceBody = restTemplate.getForEntity("http://localhost:8090/customers", String.class).getBody();

			System.out.println(serviceBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pong";
	}

}
