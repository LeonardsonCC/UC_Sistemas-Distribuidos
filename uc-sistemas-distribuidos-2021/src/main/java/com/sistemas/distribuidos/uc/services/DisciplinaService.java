package com.sistemas.distribuidos.uc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.distribuidos.uc.domain.Disciplina;
import com.sistemas.distribuidos.uc.domain.Professor;
import com.sistemas.distribuidos.uc.repositories.DisciplinaRepository;
import com.sistemas.distribuidos.uc.repositories.ProfessorRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository repository;
	
	@Autowired
	ProfessorRepository professorRepository;
	
	public List<Disciplina> listaTodos(){		
		return repository.findAll();
	}


	public void insereDisciplina(Disciplina d) {
		Professor p = professorRepository.getById(d.getProfessor().getId());
		
		if(p != null) {
			d.setProfessor(p);
			repository.save(d);
		}
	}

	public Disciplina buscaPorId(Integer id) {
		return repository.findById(id).get();
	}

	public void exclui(Integer id) {
		Disciplina p = buscaPorId(id);

		if(p != null) {
			repository.delete(buscaPorId(id));
		}
	}

	public Disciplina altera(Integer id, Disciplina d) {
		Disciplina bd = buscaPorId(id);
		bd.setNome(d.getNome());
		
		Professor p = professorRepository.getById(d.getProfessor().getId());
		bd.setProfessor(p);
		repository.save(bd);

		return bd;
	}

}
