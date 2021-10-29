package com.sistemas.distribuidos.uc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.distribuidos.uc.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer>{

}
