package cc.leonardson.uc.sistemas_distribuidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.leonardson.uc.sistemas_distribuidos.domain.Student;
import cc.leonardson.uc.sistemas_distribuidos.services.StudentService;

@RestController
@RequestMapping("/aluno")
public class StudentResource {

  @Autowired
  StudentService service;

  @GetMapping("/")
  public List<Student> listAll() {
    return service.listAll();
  }

  @PostMapping("/")
  public void addStudent(@RequestBody Student s) {
    service.addStudent(s);
  }

}
