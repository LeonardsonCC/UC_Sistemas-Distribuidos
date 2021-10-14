package cc.leonardson.uc.sistemas_distribuidos.services;

import java.util.List;
import java.util.Optional;

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

  public Optional<Student> listById(Integer id) {
    return repository.findById(id);
  }

  public List<Optional<Student>> listByName(String name) {
    return repository.findByName(name);
  }

  public void delete(Integer id) throws Exception {
    Optional<Student> s = this.listById(id);
    if (s.isPresent()) {
      repository.delete(s.get());
    } else {
      throw new Exception("Student not found");
    }
  }

  public Student edit(Integer id, Student s) throws Exception {
    Optional<Student> studentOptional = this.listById(id);
    if (!studentOptional.isPresent()) throw new Exception("Student not found");
    Student student = studentOptional.get();
    student.setName(s.getName());
    student.setGrade1(s.getGrade1());
    student.setGrade2(s.getGrade2());
    student.setGrade3(s.getGrade3());
    repository.save(student);
    return student;
  }

  public void addStudent(Student s) {
    repository.save(s);
  }

}
