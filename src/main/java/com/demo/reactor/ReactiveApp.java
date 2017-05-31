package com.demo.reactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.reactor.service.FluxService;

import reactor.core.publisher.Flux;


@SpringBootApplication
@RestController
public class ReactiveApp {
	@Autowired
	FluxService fluxService;

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApp.class, args);
	}
	
	@GetMapping("/")
	public Flux<String> getFluxString(){
		System.out.println("Inside Controller");
		return fluxService.fooBarFluxFromValues();
	}
}
