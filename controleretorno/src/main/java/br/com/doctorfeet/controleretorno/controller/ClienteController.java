package br.com.doctorfeet.controleretorno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.doctorfeet.controleretorno.model.Cliente;
import br.com.doctorfeet.controleretorno.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@RequestMapping("/cliente")
	public String index(Model model) {

		Iterable<Cliente> clientes = repository.findAll();
		model.addAttribute("clientes", clientes);

		return "cadastro-cliente";
	}
	
	@RequestMapping(value="/cliente/edit/{id}", method = RequestMethod.GET)
	public String editCliente(@PathVariable("id") Long id, Model model){
		
		Cliente cliente = this.repository.findOne(id);
		
		model.addAttribute("editarCliente", cliente);
		
		return "editar-cliente";
	}

}