package com.algaworks.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;

	@RequestMapping("/novo")
	public String novo() {
		// the return MUST BE the NAME of the HTML file.
		return "CadastroTitulo";
	}
	
	// Os nomes dos campos no FORMULARIO devem ser os mesmos dos atributos da ENTIDADE TITULO.
	// No HTML, a property NAME deve ter o mesmo nome do ATRIBUTO.
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		
		titulos.save(titulo);
		
		// param: The name of the View that will be rendered
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		
		// sending data to the view.
		// here we are sending an attribute called mensagem with a message.
		// key-value. key: mensagem, value:"Titulo salvo com sucesso!"
		// the view can access it.
		mv.addObject("mensagem", "Titulo salvo com sucesso!");
		
		
		return mv;
	}
	
}