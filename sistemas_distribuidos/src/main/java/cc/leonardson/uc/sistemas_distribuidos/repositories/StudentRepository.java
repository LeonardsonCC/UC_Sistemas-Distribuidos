package cc.leonardson.uc.sistemas_distribuidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cc.leonardson.uc.sistemas_distribuidos.domain.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Optional<Student>> findByName(String name);
}
