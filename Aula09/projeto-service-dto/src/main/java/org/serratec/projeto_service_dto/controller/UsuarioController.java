package org.serratec.projeto_service_dto.controller;

import java.net.URI;
import java.util.List;

import org.serratec.projeto_service_dto.dto.UsuarioDTORequest;
import org.serratec.projeto_service_dto.dto.UsuarioDTOResponse;
import org.serratec.projeto_service_dto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTOResponse>> listar() {
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTOResponse> inserir(@RequestBody UsuarioDTORequest usuario) {
		
		UsuarioDTOResponse usuarioDTO = usuarioService.inserir(usuario);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(usuarioDTO.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(usuarioDTO);
	}
}
