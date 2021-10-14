package com.sistemas.distribuidos.uc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.distribuidos.uc.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer>{
	public List<Cidade> findByNome(String nome);
	public List<Cidade> findByUf(String uf);
}
