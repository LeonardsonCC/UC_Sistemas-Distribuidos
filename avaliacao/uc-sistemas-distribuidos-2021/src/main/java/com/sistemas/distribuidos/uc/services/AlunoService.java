package com.sistemas.distribuidos.uc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.distribuidos.uc.domain.Aluno;
import com.sistemas.distribuidos.uc.domain.Cidade;
import com.sistemas.distribuidos.uc.repositories.AlunoRepository;
import com.sistemas.distribuidos.uc.repositories.CidadeRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	public List<Aluno> listaTodos(){		
		return repository.findAll();
	}
	
	public List<Aluno> buscaPorNome(String nome){		
		return repository.findByNome(nome);
	}

	public void insereAluno(Aluno a) {
		Cidade c = cidadeRepository.getById(a.getCidade().getId());

		if(c != null) {
			a.setCidade(c);
			repository.save(a);
		}
	}

	public Aluno buscaPorId(Integer id) {
		//return repository.findById(id).get();
		return repository.findById(id).get();
	}

	public void exclui(Integer id) {
		Aluno a = buscaPorId(id);

		if(a != null) {
			repository.delete(buscaPorId(id));
		}
	}
	
	public Aluno altera(Integer id, Aluno a) {
		Aluno bd = buscaPorId(id);
		bd.setNome(a.getNome());
		bd.setN1(a.getN1());
		bd.setN2(a.getN2());
		bd.setN3(a.getN3());
		
		Cidade c = cidadeRepository.getById(a.getCidade().getId());
		
		if(c != null) {
			bd.setCidade(c);
		}

		repository.save(bd);

		return bd;
	}

}
