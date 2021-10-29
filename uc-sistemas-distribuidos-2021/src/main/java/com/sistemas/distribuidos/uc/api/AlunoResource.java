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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.distribuidos.uc.domain.Aluno;
import com.sistemas.distribuidos.uc.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {

	@Autowired
	AlunoService service;

	@GetMapping("/{operacao}")
	public String operacao(@PathVariable(name="operacao") String operacao,
			@RequestParam(name="n1") Double n1, @RequestParam(name="n2") Double n2) {
		String retorno = "O resultado é: ";
		
		switch(operacao) {
			case "adicao":
				retorno+=(n1+n2);
				break;
			case "subtracao":
				retorno+=(n1-n2);
				break;
			case "multiplicacao":
				retorno+=(n1*n2);
				break;
			case "divisao":
				if(n2 == 0) {
					retorno+=" Impossível dividir por zero!";
				}
				else {
					retorno+=(n1/n2);
				}
				break;
		}
		return retorno;
	}

	@GetMapping("/lista")
	public List<Aluno> listaTodos(){
		return service.listaTodos();
	}
	
	@GetMapping("/procurar/{id}")
	public Aluno getById(@PathVariable(name="id") Integer id){
		Aluno resultado = service.buscaPorId(id);
		
		if(resultado == null) {
			System.out.println("ID NAO ENCONTRADO!");
		}

		return resultado;
	}

	@GetMapping("/procurar/nome")
	public List<Aluno>  getByNome(@RequestParam(name="nome") String nome){
		List<Aluno> resultado = service.buscaPorNome(nome);

		return resultado;
	}

	@DeleteMapping("/remover/{id}")
	public String deleteById(@PathVariable(name="id") Integer id){
		service.exclui(id);

		return "Aluno removido com sucesso!";
	}

	@PostMapping("/adicionar")
	public String addAluno(@RequestBody Aluno a) {
		service.insereAluno(a);

		return "Aluno adicionado com sucesso!";
	}
	
	@PutMapping("/atualizar/{id}")
	public Aluno updateAluno(@PathVariable(name="id") Integer id, @RequestBody Aluno a) {
		return service.altera(id, a);
	}
}
