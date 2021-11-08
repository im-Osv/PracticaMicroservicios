package com.SPS.Practica.Microservicios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.SPS.Practica.Microservicios.HelloWorldBean;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/api/sps/helloworld/v1/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello SPS, this is the message: %s", name));
	}
}
