package com.sistemas.distribuidos.uc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistemas.distribuidos.uc.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Integer>{

	List<Aluno> findByNome(String nome);
	
	List<Aluno> findByNomeContaining(String nome);

	//@Query("SELECT * FROM Aluno a WHERE a.nome LIKE CONCAT('%',:nome,'%')")
	//List<Aluno> findAlunoWithPartOfName(@Param("nome") String nome); 
}
