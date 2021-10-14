package cc.leonardson.uc.sistemas_distribuidos.resources;

import cc.leonardson.uc.sistemas_distribuidos.domain.Discipline;
import cc.leonardson.uc.sistemas_distribuidos.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
public class DisciplineResource {

  @Autowired
  DisciplineService service;

  @GetMapping("/")
  public List<Discipline> listAll() {
    return service.listAll();
  }

  @GetMapping("/{id}")
  public Optional<Discipline> listById(@PathVariable(name = "id") Integer id) {
    return service.listById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable(name = "id") Integer id) throws Exception {
    service.delete(id);
  }

  @PutMapping("/{id}")
  public Discipline editById(@PathVariable(name = "id") Integer id, @RequestBody Discipline p) throws Exception {
    return service.edit(id, p);
  }

  @PostMapping("/")
  public void add(@RequestBody Discipline d) throws Exception {
    service.addDiscipline(d);
  }

}
