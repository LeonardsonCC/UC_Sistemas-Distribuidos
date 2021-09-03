package cc.leonardson.uc.sistemas_distribuidos.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplo")
public class Exemplo {

  @GetMapping("/home")
  public String welcome() {
    return "Welcome";
  }

  @GetMapping("/home/2")
  public String welcome2(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
    String msg = "Welcome, " + name + ". ";
    if (age >= 21) {
      msg += "You have age to drink some beers man";
    } else {
      msg += "Sorry kid, go home";
    }
    return msg;
  }

  @GetMapping("/home/3/{name}")
  public String welcome3(@PathVariable(name = "name") String name) {
    String msg = "Welcome, " + name + ". ";
    return msg;
  }
}
