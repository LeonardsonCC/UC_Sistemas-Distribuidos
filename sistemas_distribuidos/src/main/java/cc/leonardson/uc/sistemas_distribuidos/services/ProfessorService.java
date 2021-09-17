package cc.leonardson.uc.sistemas_distribuidos.services;

import cc.leonardson.uc.sistemas_distribuidos.domain.Professor;
import cc.leonardson.uc.sistemas_distribuidos.domain.Student;
import cc.leonardson.uc.sistemas_distribuidos.repositories.ProfessorRepository;
import cc.leonardson.uc.sistemas_distribuidos.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

  @Autowired
  ProfessorRepository repository;

  public List<Professor> listAll() {
    return repository.findAll();
  }

  public Optional<Professor> listById(Integer id) {
    return repository.findById(id);
  }

  public void delete(Integer id) throws Exception {
    Optional<Professor> p = this.listById(id);
    if (p.isPresent()) {
      repository.delete(p.get());
    } else {
      throw new Exception("Professor not found");
    }
  }

  public Professor edit(Integer id, Professor p) throws Exception {
    Optional<Professor> professorOptional = this.listById(id);
    if (!professorOptional.isPresent()) throw new Exception("Professor not found");
    Professor professor = professorOptional.get();
    professor.setName(p.getName());
    professor.setFormacao(p.getFormacao());
    repository.save(professor);
    return professor;
  }

  public void addStudent(Professor p) {
    repository.save(p);
  }

}
