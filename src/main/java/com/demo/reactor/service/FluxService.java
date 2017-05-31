package com.demo.reactor.service;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class FluxService {

	public Flux<String> fooBarFluxFromValues() {
		System.out.println("Inside FluxService...");
		return Flux.just("foo", "bar"); 
	}



}
