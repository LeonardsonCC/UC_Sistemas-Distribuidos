package com.sistemas.distribuidos.uc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistemas.distribuidos.uc.domain.Aluno;
import com.sistemas.distribuidos.uc.domain.Disciplina;
import com.sistemas.distribuidos.uc.domain.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Integer>{
}
