package com.sistemas.distribuidos.uc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.distribuidos.uc.domain.Aluno;
import com.sistemas.distribuidos.uc.domain.Cidade;
import com.sistemas.distribuidos.uc.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository repository;
	
	public List<Cidade> buscaPorNome(String nome){		
		return repository.findByNome(nome);
	}
	
	public List<Cidade> buscaPorUf(String uf){		
		return repository.findByUf(uf);
	}

	public List<Cidade> listaTodos(){		
		return repository.findAll();
	}

	public void insereCidade(Cidade a) {
		repository.save(a);
	}

	public Cidade buscaPorId(Integer id) {
		//return repository.findById(id).get();
		return repository.findById(id).get();
	}

	public void exclui(Integer id) {
		Cidade c = buscaPorId(id);

		if(c != null) {
			repository.delete(c);
		}
	}
	
	public Cidade altera(Integer id, Cidade c) {
		Cidade bd = buscaPorId(id);
		bd.setNome(c.getNome());
		bd.setUf(c.getUf());

		repository.save(bd);

		return bd;
	}

}
