package org.serratec.aula05.controller;

import java.util.List;

import org.serratec.aula05.domain.Veiculo;
import org.serratec.aula05.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@PostMapping
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> listar() {
		List<Veiculo> veiculos = veiculoRepository.findAll();
		return ResponseEntity.ok(veiculos);
	}
}
