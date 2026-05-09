package org.serratec.aula02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@GetMapping
	public String helloWord() {
		return "Hello World!";
	}
	
	@GetMapping("/msg")
	public String msg() {
		return "oi";
	}
	
	@GetMapping("/maiuscula")
	public String maiuscula(@RequestParam String chave) {
		return chave.toUpperCase();
	}
}
