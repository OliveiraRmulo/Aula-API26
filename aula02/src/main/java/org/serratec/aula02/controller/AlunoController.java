package org.serratec.aula02.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.aula02.domain.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	private static List<Aluno> listaAlunos = new ArrayList<>();
	
	static {
		listaAlunos.add(new Aluno(2354L, "Carla", "2224-0439"));
		listaAlunos.add(new Aluno(2343L, "Carlos", "2334-0239"));
		listaAlunos.add(new Aluno(1409L,"Maria", "2343-2345"));
	}
	
	@GetMapping
	public List<Aluno> listarAlunos() {
		return listaAlunos;
	}
	
	@GetMapping("/{matricula}")
	public Aluno buscarAlunoPorMatricula(@PathVariable Long matricula) {
		for (int i = 0; i<listaAlunos.size(); i++) {
			if (listaAlunos.get(i).getMatricula().equals(matricula)) {
				return listaAlunos.get(i);
			}
			
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
		listaAlunos.add(aluno);
		return aluno;
	}
	
	@DeleteMapping("/{matricula}")
	public void deletarAluno(@PathVariable Long matricula) {
		for (int i = 0; i<listaAlunos.size(); i++) {
			if (listaAlunos.get(i).getMatricula().equals(matricula)) {
				listaAlunos.remove(i);
			}
			break;
			
		}
		
	}
	
	@PutMapping("/{matricula}")
	public Aluno atualizarAluno (@RequestBody Aluno aluno, @PathVariable Long matricula) {
		for (int i = 0; i<listaAlunos.size(); i++) {
			if (listaAlunos.get(i).getMatricula().equals(matricula)) {
				listaAlunos.set(i, aluno);
				return aluno;
			}
			
		}
		return null;
	}
}
