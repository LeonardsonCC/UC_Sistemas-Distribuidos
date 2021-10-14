package cc.leonardson.uc.sistemas_distribuidos.services;

import cc.leonardson.uc.sistemas_distribuidos.domain.Discipline;
import cc.leonardson.uc.sistemas_distribuidos.domain.Professor;
import cc.leonardson.uc.sistemas_distribuidos.repositories.DisciplineRepository;
import cc.leonardson.uc.sistemas_distribuidos.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {

  @Autowired
  DisciplineRepository repository;

  @Autowired
  ProfessorRepository professorRepository;

  public List<Discipline> listAll() {
    return repository.findAll();
  }

  public Optional<Discipline> listById(Integer id) {
    return repository.findById(id);
  }

  public void delete(Integer id) throws Exception {
    Optional<Discipline> d = this.listById(id);
    if (d.isPresent()) {
      repository.delete(d.get());
    } else {
      throw new Exception("Discipline not found");
    }
  }

  public Discipline edit(Integer id, Discipline d) throws Exception {
    Optional<Discipline> disciplineOptional = this.listById(id);
    if (!disciplineOptional.isPresent()) throw new Exception("Discipline not found");
    Discipline discipline = disciplineOptional.get();
    discipline.setNome(d.getNome());
    discipline.setProfessor(d.getProfessor());
    repository.save(discipline);
    return discipline;
  }

  public void addDiscipline(Discipline d) throws Exception {
    Professor p = professorRepository.getById(d.getProfessor().getId());
    if (p != null) {
      d.setProfessor(p);
      repository.save(d);
    } else {
      throw new Exception("Professor not found");
    }
  }

}
