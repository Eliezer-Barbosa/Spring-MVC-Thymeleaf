package com.algaworks.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TituloController {

	@RequestMapping("/titulos/novo")
	public String novo() {
		// the return MUST BE the NAME of the HTML file.
		return "CadastroTitulo";
	}
	
}