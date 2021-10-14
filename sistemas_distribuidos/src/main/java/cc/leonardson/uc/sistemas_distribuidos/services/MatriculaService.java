package cc.leonardson.uc.sistemas_distribuidos.services;

import cc.leonardson.uc.sistemas_distribuidos.domain.*;
import cc.leonardson.uc.sistemas_distribuidos.repositories.DisciplineRepository;
import cc.leonardson.uc.sistemas_distribuidos.repositories.MatriculaRepository;
import cc.leonardson.uc.sistemas_distribuidos.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

  @Autowired
  MatriculaRepository repository;

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  DisciplineRepository disciplineRepository;

  public List<Matricula> listAll() {
    return repository.findAll();
  }

  public Matricula findById(Integer id) {
    return repository.findById(id).get();
  }

  public Optional<Matricula> listById(Integer id) {
    return repository.findById(id);
  }

  public void delete(Integer id) throws Exception {
    Optional<Matricula> d = this.listById(id);
    if (d.isPresent()) {
      repository.delete(d.get());
    } else {
      throw new Exception("Matricula not found");
    }
  }

  public void addMatricula(Matricula m) throws Exception {
    Student s = studentRepository.getById(m.getId().getStudent().getId());
    Discipline d = disciplineRepository.getById(m.getId().getDiscipline().getId());
    MatriculaPK mp = new MatriculaPK();

    if (s != null && d != null) {
      mp.setStudent(s);
      mp.setDiscipline(d);
      m.setId(mp);
      m.setSemester(m.getSemester());

      repository.save(m);
    } else {
      throw new Exception("Items not found!");
    }
  }

  public Matricula update(Integer id, Matricula m) {
    Matricula bd = findById(id);
    Student s = studentRepository.getById(m.getId().getStudent().getId());
    Discipline d = disciplineRepository.getById(m.getId().getDiscipline().getId());
    MatriculaPK mp = new MatriculaPK();

    if(s != null && d != null) {
      mp.setStudent(s);
      mp.setDiscipline(d);

      m.setId(mp);
      m.setSemester(m.getSemester());
      repository.save(m);
    }
    return bd;
  }


}
