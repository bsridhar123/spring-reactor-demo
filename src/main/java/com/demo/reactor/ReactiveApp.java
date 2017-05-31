package com.demo.reactor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.reactor.service.FluxService;


@SpringBootApplication
@RestController
public class ReactiveApp {
	@Autowired
	FluxService fluxService;

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApp.class, args);
	}
	
	@GetMapping("/")
	public List<String> getFluxString(){
		System.out.println("Inside Controller");
		List<String> userList= new ArrayList<String>();
		fluxService.fooBarFluxFromValues().map(data -> userList.add(data)).subscribe();
		System.out.println("Return the result to user in controller");
		return userList; 
	}
	
	@GetMapping("/monotostring")
	public String monoToValue(){
		System.out.println("Inside Controller");
		return fluxService.getMono().block();
	}
}
