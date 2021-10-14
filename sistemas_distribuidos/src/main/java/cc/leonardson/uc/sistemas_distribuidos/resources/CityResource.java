package cc.leonardson.uc.sistemas_distribuidos.resources;

import cc.leonardson.uc.sistemas_distribuidos.domain.City;
import cc.leonardson.uc.sistemas_distribuidos.domain.Discipline;
import cc.leonardson.uc.sistemas_distribuidos.services.CityService;
import cc.leonardson.uc.sistemas_distribuidos.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidade")
public class CityResource {

  @Autowired
  CityService service;

  @GetMapping("/")
  public List<City> listAll() {
    return service.listAll();
  }

  @GetMapping("/{id}")
  public Optional<City> listById(@PathVariable(name = "id") Integer id) {
    return service.listById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable(name = "id") Integer id) throws Exception {
    service.delete(id);
  }

  @PutMapping("/{id}")
  public City editById(@PathVariable(name = "id") Integer id, @RequestBody City p) throws Exception {
    return service.edit(id, p);
  }

  @PostMapping("/")
  public void add(@RequestBody City d) throws Exception {
    service.addCity(d);
  }

}
