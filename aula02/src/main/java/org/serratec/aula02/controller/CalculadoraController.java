package org.serratec.aula02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@GetMapping("/somar")
	public double somar(@RequestParam double a, @RequestParam double b) {
		return a + b;
	}
	
	@GetMapping("/subtrair")
	public double subtrair(@RequestParam double a, @RequestParam double b) {
		return a - b;
	}
	
	@GetMapping("/multiplicar")
	public double multiplicar(@RequestParam double a, @RequestParam double b) {
		return a * b;
	}
	
	@GetMapping("/dividir")
	public double dividir(@RequestParam double a, @RequestParam double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Divisão por zero não é permitida.");
		}
		return a / b;
	}
}
