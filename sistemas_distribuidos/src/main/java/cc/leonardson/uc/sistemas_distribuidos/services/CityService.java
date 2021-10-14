package cc.leonardson.uc.sistemas_distribuidos.services;

import cc.leonardson.uc.sistemas_distribuidos.domain.City;
import cc.leonardson.uc.sistemas_distribuidos.domain.Discipline;
import cc.leonardson.uc.sistemas_distribuidos.domain.Professor;
import cc.leonardson.uc.sistemas_distribuidos.domain.Student;
import cc.leonardson.uc.sistemas_distribuidos.repositories.CityRepository;
import cc.leonardson.uc.sistemas_distribuidos.repositories.DisciplineRepository;
import cc.leonardson.uc.sistemas_distribuidos.repositories.ProfessorRepository;
import cc.leonardson.uc.sistemas_distribuidos.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

  @Autowired
  CityRepository repository;

  @Autowired
  StudentRepository studentRepository;

  public List<City> listAll() {
    return repository.findAll();
  }

  public Optional<City> listById(Integer id) {
    return repository.findById(id);
  }

  public void delete(Integer id) throws Exception {
    Optional<City> d = this.listById(id);
    if (d.isPresent()) {
      repository.delete(d.get());
    } else {
      throw new Exception("Discipline not found");
    }
  }

  public City edit(Integer id, City d) throws Exception {
    Optional<City> cityOptional = this.listById(id);
    if (!cityOptional.isPresent()) throw new Exception("City not found");
    City city = cityOptional.get();
    city.setNome(d.getNome());
    city.setUf(d.getUf());
    city.setStudents(d.getStudents());
    repository.save(city);
    return city;
  }

  public void addCity(City d) throws Exception {
    List<Student> students = d.getStudents();
    for (Student s : students) {
      s = studentRepository.getById(s.getId());
    }
    repository.save(d);
  }

}
