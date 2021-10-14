package com.sistemas.distribuidos.uc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.distribuidos.uc.domain.Matricula;
import com.sistemas.distribuidos.uc.domain.MatriculaPK;
import com.sistemas.distribuidos.uc.domain.Aluno;
import com.sistemas.distribuidos.uc.domain.Disciplina;
import com.sistemas.distribuidos.uc.repositories.MatriculaRepository;
import com.sistemas.distribuidos.uc.repositories.AlunoRepository;
import com.sistemas.distribuidos.uc.repositories.DisciplinaRepository;

@Service
public class MatriculaService {

	@Autowired
	MatriculaRepository repository;
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	public List<Matricula> listaTodos(){		
		return repository.findAll();
	}
	

	public void insereMatricula(Matricula m) {
		Aluno a = alunoRepository.getById(m.getId().getAluno().getId());
		Disciplina d = disciplinaRepository.getById(m.getId().getDisciplina().getId());
        MatriculaPK mp = new MatriculaPK();

		if(a != null && d != null) {
			mp.setAluno(a);
			mp.setDisciplina(d);
			
			m.setId(mp);
            m.setSemestre(m.getSemestre());
			repository.save(m);
		}
	}

	public Matricula buscaPorId(Integer id) {
		return repository.findById(id).get();
	}

	public void exclui(Integer id) {
		Matricula m = buscaPorId(id);

		if(m != null) {
			repository.delete(buscaPorId(id));
		}
	}
	
	public Matricula altera(Integer id, Matricula m) {
		Matricula bd = buscaPorId(id);
		Aluno a = alunoRepository.getById(m.getId().getAluno().getId());
		Disciplina d = disciplinaRepository.getById(m.getId().getDisciplina().getId());
		MatriculaPK mp = new MatriculaPK();
		
		if(a != null && d != null) {
			mp.setAluno(a);
			mp.setDisciplina(d);
			
			m.setId(mp);
            m.setSemestre(m.getSemestre());
			repository.save(m);
		}
		return bd;
	}

}
