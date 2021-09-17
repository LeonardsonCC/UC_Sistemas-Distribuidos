package cc.leonardson.uc.sistemas_distribuidos.resources;

import cc.leonardson.uc.sistemas_distribuidos.domain.Professor;
import cc.leonardson.uc.sistemas_distribuidos.domain.Student;
import cc.leonardson.uc.sistemas_distribuidos.services.ProfessorService;
import cc.leonardson.uc.sistemas_distribuidos.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

  @Autowired
  ProfessorService service;

  @GetMapping("/")
  public List<Professor> listAll() {
    return service.listAll();
  }

  @GetMapping("/{id}")
  public Optional<Professor> listById(@PathVariable(name = "id") Integer id) {
    return service.listById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable(name = "id") Integer id) throws Exception {
    service.delete(id);
  }

  @PutMapping("/{id}")
  public Professor editById(@PathVariable(name = "id") Integer id, @RequestBody Professor p) throws Exception {
    return service.edit(id, p);
  }

  @PostMapping("/")
  public void add(@RequestBody Professor p) {
    service.addStudent(p);
  }

}
