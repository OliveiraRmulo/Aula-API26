package org.serratec.aula02.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.serratec.aula02.domain.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	
	private static List<Veiculo> veiculos = new ArrayList<>();
	
	static {
		veiculos.add(new Veiculo(1L, "Toyota", "Corolla"));
		veiculos.add(new Veiculo(2L, "Honda", "Civic"));
		veiculos.add(new Veiculo(3L, "Ford", "Focus"));
	}
	
	@GetMapping
	public List<Veiculo> listar() {
		return veiculos;
	}
	
	@GetMapping("/{id}")
	public Veiculo buscarPorId(@PathVariable Long id) {
		return veiculos.stream()
				.filter(v -> v.getId().equals(id))
				.findFirst()
				.orElse(null);
	}
	
	@GetMapping("/marca/{marca}")
	public List<Veiculo> buscarPorMarcar(@RequestParam String marca) {
		return veiculos.stream()
			   .filter(v -> v.getMarca().equalsIgnoreCase(marca))
			   .collect(Collectors.toList());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo criar(@RequestBody Veiculo veiculo) {
		veiculos.add(veiculo);
		return veiculo;
	}
	
	@PutMapping("/{id}")
	public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
		for (int i = 0; i < veiculos.size(); i++) {
			if (veiculos.get(i).getId().equals(id)) {
				veiculos.set(i, veiculo);
				return veiculo;
			}
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		veiculos.removeIf(v -> v.getId().equals(id));
	}
	
}
