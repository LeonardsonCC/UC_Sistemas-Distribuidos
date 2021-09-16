package cc.leonardson.uc.sistemas_distribuidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.leonardson.uc.sistemas_distribuidos.domain.Student;
import cc.leonardson.uc.sistemas_distribuidos.repositories.StudentRepository;

@Service
public class StudentService {

  @Autowired
  StudentRepository repository;

  public List<Student> listAll() {
    return repository.findAll();
  }

  public void addStudent(Student s) {
    repository.save(s);
  }

}
