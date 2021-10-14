package cc.leonardson.uc.sistemas_distribuidos.resources;

import cc.leonardson.uc.sistemas_distribuidos.domain.Discipline;
import cc.leonardson.uc.sistemas_distribuidos.domain.Matricula;
import cc.leonardson.uc.sistemas_distribuidos.services.DisciplineService;
import cc.leonardson.uc.sistemas_distribuidos.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/matricula")
public class MatriculaResource {

  @Autowired
  MatriculaService service;

  @GetMapping("/")
  public List<Matricula> listaTodos(){
    return service.listAll();
  }

  @GetMapping("/{id}")
  public Matricula getById(@PathVariable(name="id") Integer id){
    Matricula resultado = service.findById(id);

    if(resultado == null) {
      System.out.println("ID NAO ENCONTRADO!");
    }

    return resultado;
  }

  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable(name="id") Integer id){
    try {
      service.delete(id);
      return "Matricula removido com sucesso!";
    } catch (Exception e) {
      return "erro";
    }
  }

  @PostMapping("/")
  public String addMatricula(@RequestBody Matricula p) {
    try {
      service.addMatricula(p);
      return "Matricula adicionado com sucesso!";
    } catch (Exception e) {
      return "erro";
    }
  }
}
