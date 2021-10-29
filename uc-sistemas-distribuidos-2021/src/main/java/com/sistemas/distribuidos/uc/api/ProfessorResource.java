package com.sistemas.distribuidos.uc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.distribuidos.uc.domain.Professor;
import com.sistemas.distribuidos.uc.services.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

	@Autowired
	ProfessorService service;

	@GetMapping("/lista")
	public List<Professor> listaTodos(){
		return service.listaTodos();
	}
	
	@GetMapping("/procurar/{id}")
	public Professor getById(@PathVariable(name="id") Integer id){
		Professor resultado = service.buscaPorId(id);
		
		if(resultado == null) {
			System.out.println("ID NAO ENCONTRADO!");
		}

		return resultado;
	}

	@DeleteMapping("/remover/{id}")
	public String deleteById(@PathVariable(name="id") Integer id){
		service.exclui(id);

		return "Professor removido com sucesso!";
	}

	@PostMapping("/adicionar")
	public String addProfessor(@RequestBody Professor p) {
		service.insereProfessor(p);

		return "Professor adicionado com sucesso!";
	}
	
	@PutMapping("/atualizar/{id}")
	public Professor updateProfessor(@PathVariable(name="id") Integer id, @RequestBody Professor p) {
		return service.altera(id, p);
	}
}
