package br.com.doctorfeet.controleretorno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.doctorfeet.controleretorno.model.Cliente;
import br.com.doctorfeet.controleretorno.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService service;

	@RequestMapping("/cliente")
	public String index(Model model) {

		Iterable<Cliente> clientes = service.findAll();
		model.addAttribute("clientes", clientes);

		return "cadastro-cliente";
	}

	@RequestMapping(value = "/cliente/edit/{id}")
	public ModelAndView editCliente(@PathVariable("id") Long id) {
		
		Cliente cliente = this.service.findOne(id);

		ModelAndView model = new ModelAndView("redirect:/cliente");

		model.addObject("editarCliente", cliente);

		return model;
	}

	@RequestMapping(value = "/cliente/update", method = RequestMethod.GET)
	public String update(@ModelAttribute("editarCliente") Cliente editarCliente,
			final RedirectAttributes redirectAttributes) {

		Cliente cliente = this.service.save(editarCliente);

		if (cliente != null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}

		return "redirect:/cliente";
	}
	
	
	@RequestMapping(value = "/cliente/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("criarCliente") Cliente criarCliente,
			final RedirectAttributes redirectAttributes) {

		Cliente cliente = this.service.save(criarCliente);

		if (cliente != null) {
			redirectAttributes.addFlashAttribute("create", "success");
		} else {
			redirectAttributes.addFlashAttribute("create", "unsuccess");
		}

		return "redirect:/cliente";
	}

}