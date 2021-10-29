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
import com.sistemas.distribuidos.uc.domain.Cidade;
import com.sistemas.distribuidos.uc.services.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	@Autowired
	CidadeService service;

	@GetMapping("/lista")
	public List<Cidade> listaTodos(){
		return service.listaTodos();
	}
	
	@GetMapping("/procurar/{id}")
	public Cidade getById(@PathVariable(name="id") Integer id){
		Cidade resultado = service.buscaPorId(id);
		
		if(resultado == null) {
			System.out.println("ID NAO ENCONTRADO!");
		}

		return resultado;
	}

	@GetMapping("/procurar/nome")
	public List<Cidade>  getByNome(@RequestParam(name="nome") String nome){
		List<Cidade> resultado = service.buscaPorNome(nome);

		return resultado;
	}
	
	@GetMapping("/procurar/uf")
	public List<Cidade>  getByUf(@RequestParam(name="uf") String uf){
		List<Cidade> resultado = service.buscaPorUf(uf);

		return resultado;
	}

	@DeleteMapping("/remover/{id}")
	public String deleteById(@PathVariable(name="id") Integer id){
		service.exclui(id);

		return "Cidade removido com sucesso!";
	}

	@PostMapping("/adicionar")
	public String addCidade(@RequestBody Cidade c) {
		service.insereCidade(c);

		return "Cidade adicionado com sucesso!";
	}
	
	@PutMapping("/atualizar/{id}")
	public Cidade updateCidade(@PathVariable(name="id") Integer id, @RequestBody Cidade c) {
		return service.altera(id, c);
	}
}
