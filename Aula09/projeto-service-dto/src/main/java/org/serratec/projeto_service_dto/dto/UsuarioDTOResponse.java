package org.serratec.projeto_service_dto.dto;

import java.util.HashSet;
import java.util.Set;

import org.serratec.projeto_service_dto.domain.Perfil;
import org.serratec.projeto_service_dto.domain.Usuario;
import org.serratec.projeto_service_dto.domain.UsuarioPerfil;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "nome",
    "email"
})
public class UsuarioDTOResponse {

	private Long id;
	private String nome;
	private String email;
	private Set<Perfil> perfis;
	
	public UsuarioDTOResponse() {
		super();
	}

	public UsuarioDTOResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.perfis = new HashSet<>();
		
		for (UsuarioPerfil usuarioPerfil : usuario.getUsuarioPerfil()) {
			this.perfis.add(usuarioPerfil.getId().getPerfil());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}
	
}
