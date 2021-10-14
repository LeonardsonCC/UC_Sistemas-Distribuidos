package cc.leonardson.uc.sistemas_distribuidos.repositories;

import cc.leonardson.uc.sistemas_distribuidos.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Integer>{
}

