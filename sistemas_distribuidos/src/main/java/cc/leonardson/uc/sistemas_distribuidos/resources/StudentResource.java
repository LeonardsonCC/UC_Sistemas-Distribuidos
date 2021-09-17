package cc.leonardson.uc.sistemas_distribuidos.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/{id}")
  public Optional<Student> listById(@PathVariable(name = "id") Integer id) {
    return service.listById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable(name = "id") Integer id) throws Exception {
    service.delete(id);
  }

  @PutMapping("/{id}")
  public Student editById(@PathVariable(name = "id") Integer id, @RequestBody Student s) throws Exception {
    return service.edit(id, s);
  }

  @PostMapping("/")
  public void addStudent(@RequestBody Student s) {
    service.addStudent(s);
  }

}
