package cc.leonardson.avaliacao.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImcResource {

    /**
     * Legenda IMC:
     * menor que 18,5 : baixo peso
     * entre 18,5 e 24,9 : intervalo normal
     * entre 25 e 29,9 : sobrepeso
     * entre 30 e 34,9 : obesidade classe I
     * entre 35 e 39,9 : obesidade classe II
     * maior que 40 : obesidade classe III
     */

    @GetMapping("imc")
    public String imc(@RequestParam(name = "peso") Double weight, @RequestParam(name = "altura") Double height) {
        String finalMessage = "";
        Double imc = weight / (height*height);
        if (imc < 18.5) {
            finalMessage = "Baixo peso";
        } else if (imc >= 18.5 && imc < 25) {
            finalMessage = "Intervalo normal";
        } else if (imc >= 25 && imc < 30) {
            finalMessage = "Sobrepeso";
        } else if (imc >= 30 && imc < 35) {
            finalMessage = "Obsidade classe I";
        } else if (imc >= 35 && imc < 40) {
            finalMessage = "Obesidade classe II";
        } else {
            finalMessage = " Obsidade classe III";
        }

        return finalMessage;
    }
}
