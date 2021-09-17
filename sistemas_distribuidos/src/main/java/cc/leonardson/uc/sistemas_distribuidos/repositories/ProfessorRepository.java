package cc.leonardson.uc.sistemas_distribuidos.repositories;

import cc.leonardson.uc.sistemas_distribuidos.domain.Professor;
import cc.leonardson.uc.sistemas_distribuidos.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
