package com.algaworks.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		return mv;
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
	
	/* this annotation define an atribute to be shared with the view.
	 * the name of the property that the view will access will be
	 * the name of the return type <'StatusTitulo'> concatenated with the word List.
	 * StatusTituloList - this is the Spring default.
	 * if we want to give a name to the property, we can specify it, like we did in here.
	 * ("todosStatusTitulo"). So the property name in the view will be todosStatusTitulo.
	 * Now we dont need to call 
	 * mv.addObject("todosStatusTitulo", StatusTitulo.values());
	   throughout the code. with this anottation, the property will be availabe always.
	 */
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
	
}