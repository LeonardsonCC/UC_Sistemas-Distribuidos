package cc.leonardson.teste.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Teste {
  
  @GetMapping
  public String indexRoute() {
    return "Hello, world!";
  }

  @GetMapping("/bye")
  public String aaaRoute() {
    return "Adios amigo";
  }

  @PostMapping("/post")
  public String postRoute() {
    return "Adios amigo";
  }
}
