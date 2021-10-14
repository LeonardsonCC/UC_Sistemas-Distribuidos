package com.sistemas.distribuidos.uc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.distribuidos.uc.domain.Professor;
import com.sistemas.distribuidos.uc.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository repository;
	
	public List<Professor> listaTodos(){		
		return repository.findAll();
	}
	
	
	public void insereProfessor(Professor p) {
		repository.save(p);
	}

	public Professor buscaPorId(Integer id) {
		return repository.findById(id).get();
	}

	public void exclui(Integer id) {
		Professor p = buscaPorId(id);

		if(p != null) {
			repository.delete(buscaPorId(id));
		}
	}
	
	public Professor altera(Integer id, Professor p) {
		Professor bd = buscaPorId(id);
		bd.setNome(p.getNome());
		bd.setFormacao(p.getFormacao());
		repository.save(bd);

		return bd;
	}

}
