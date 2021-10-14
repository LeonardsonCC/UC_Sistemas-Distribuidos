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

import com.sistemas.distribuidos.uc.domain.Matricula;
import com.sistemas.distribuidos.uc.services.MatriculaService;

@RestController
@RequestMapping("/matricula")
public class MatriculaResource {

	@Autowired
	MatriculaService service;

	@GetMapping("/lista")
	public List<Matricula> listaTodos(){
		return service.listaTodos();
	}
	
	@GetMapping("/procurar/{id}")
	public Matricula getById(@PathVariable(name="id") Integer id){
		Matricula resultado = service.buscaPorId(id);
		
		if(resultado == null) {
			System.out.println("ID NAO ENCONTRADO!");
		}

		return resultado;
	}

	@DeleteMapping("/remover/{id}")
	public String deleteById(@PathVariable(name="id") Integer id){
		service.exclui(id);

		return "Matricula removido com sucesso!";
	}

	@PostMapping("/adicionar")
	public String addMatricula(@RequestBody Matricula p) {
		service.insereMatricula(p);

		return "Matricula adicionado com sucesso!";
	}
	
	@PutMapping("/atualizar/{id}")
	public Matricula updateMatricula(@PathVariable(name="id") Integer id, @RequestBody Matricula p) {
		return service.altera(id, p);
	}
}
