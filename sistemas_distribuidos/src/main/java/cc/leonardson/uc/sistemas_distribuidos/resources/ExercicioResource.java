package cc.leonardson.uc.sistemas_distribuidos.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicio")
public class ExercicioResource {

  @GetMapping("/{operation}")
  public String calculate(@PathVariable(name = "operation") String operation, @RequestParam(name = "n1") Integer n1,
      @RequestParam(name = "n2") Integer n2) {
    String value = "";
    if (operation.equals("adicao")) {
      value = n1 + " + " + n2 + " = " + (n1 + n2);
    } else if (operation.equals("subtracao")) {
      value = n1 + " - " + n2 + " = " + (n1 - n2);
    } else if (operation.equals("multiplicacao")) {
      value = n1 + " x " + n2 + " = " + (n1 * n2);
    } else if (operation.equals("divisao")) {
      value = n1 + " / " + n2 + " = " + (n1 / n2);
    } else {
      value = "Operacao invalida";
    }

    return value;
  }
}
