package com.sistemas.distribuidos.uc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/exemplo")
public class Exemplo {
	@GetMapping
	public String boasVindas() {
		return "EAE MEU PATRÃO! BOM DIA...";
	}

	@GetMapping("/ola")
	public String boasVindas2(@RequestParam(name="nome") String nome, Integer idade) {
		String retorno = "OLA OLA OlÁ "+nome+".";
		if(idade != null) {
			retorno+=" Você tem: "+idade+" anos";
		}
		
		return retorno;
	}

	@GetMapping("/frase/{nome}")
	public String makeFrase(@PathVariable(name="nome") String nome, Integer idade) {
		String retorno = "Bom dia "+nome+".";
		if(idade != null) {
			retorno+=" Você tem: "+idade+" anos";
		}
		
		return retorno;
	}
}
