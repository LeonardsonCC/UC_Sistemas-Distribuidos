package cc.leonardson.uc.sistemas_distribuidos.resources;

import cc.leonardson.uc.sistemas_distribuidos.domain.Matricula;
import cc.leonardson.uc.sistemas_distribuidos.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/matricula")
public class MatriculaResource {

  @Autowired
  MatriculaService service;

  @GetMapping("/")
  public List<Matricula> list(){
    return service.listAll();
  }

  @GetMapping("/{id}")
  public Matricula listById(@PathVariable(name="id") Integer id){
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

  @PutMapping("/{id}")
  public Matricula updateMatricula(@PathVariable(name="id") Integer id, @RequestBody Matricula p) {
    return service.update(id, p);
  }
}
