package org.serratec.projeto_service_dto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.serratec.projeto_service_dto.domain.Perfil;
import org.serratec.projeto_service_dto.domain.Usuario;
import org.serratec.projeto_service_dto.domain.UsuarioPerfil;
import org.serratec.projeto_service_dto.dto.UsuarioDTORequest;
import org.serratec.projeto_service_dto.dto.UsuarioDTOResponse;
import org.serratec.projeto_service_dto.exception.EmailException;
import org.serratec.projeto_service_dto.exception.SenhaException;
import org.serratec.projeto_service_dto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilService perfilService;
	
	public List<UsuarioDTOResponse> findAll() {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		List<UsuarioDTOResponse> usuariosDTO = new ArrayList<UsuarioDTOResponse>();
		
		for(Usuario usuario: usuarios) {
			usuariosDTO.add(new UsuarioDTOResponse(usuario));
		}
		
		return usuariosDTO;
	}
	
	@Transactional
	public UsuarioDTOResponse inserir(UsuarioDTORequest usuarioDTO) {
		
		if(!usuarioDTO.getSenha().equals(usuarioDTO.getConfirmaSenha())) {
			throw new SenhaException("Senha e confirmação de senha não conferem");
		}
		if (usuarioRepository.findByEmail(usuarioDTO.getEmail()) != null) {
			throw new EmailException("Email já cadastrado");
		}
		
		Usuario user = new Usuario();
		user.setNome(usuarioDTO.getNome());
		user.setEmail(usuarioDTO.getEmail());
		user.setSenha(usuarioDTO.getSenha());
		
		Set<UsuarioPerfil> perfis = new HashSet<>();
		
		for(Perfil perfil : usuarioDTO.getPerfis()) {
			perfil = perfilService.buscar(perfil.getId());
			
			UsuarioPerfil usuarioPerfil = new UsuarioPerfil(user, perfil, LocalDate.now());
			perfis.add(usuarioPerfil);
			
		}
		
		user.setUsuarioPerfil(perfis);
		user = usuarioRepository.save(user);
		
		return new UsuarioDTOResponse(user);
		
	}

}
