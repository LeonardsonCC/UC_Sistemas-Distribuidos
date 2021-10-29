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

import com.sistemas.distribuidos.uc.domain.Disciplina;
import com.sistemas.distribuidos.uc.services.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

	@Autowired
	DisciplinaService service;

	@GetMapping("/lista")
	public List<Disciplina> listaTodos(){
		return service.listaTodos();
	}
	
	@GetMapping("/procurar/{id}")
	public Disciplina getById(@PathVariable(name="id") Integer id){
		Disciplina resultado = service.buscaPorId(id);
		
		if(resultado == null) {
			System.out.println("ID NAO ENCONTRADO!");
		}

		return resultado;
	}

	@DeleteMapping("/remover/{id}")
	public String deleteById(@PathVariable(name="id") Integer id){
		service.exclui(id);

		return "Disciplina removido com sucesso!";
	}

	@PostMapping("/adicionar")
	public String addDisciplina(@RequestBody Disciplina d) {
		service.insereDisciplina(d);

		return "Disciplina adicionado com sucesso!";
	}
	
	@PutMapping("/atualizar/{id}")
	public Disciplina updateDisciplina(@PathVariable(name="id") Integer id, @RequestBody Disciplina d) {
		return service.altera(id, d);
	}
}
