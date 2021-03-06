package br.com.doctorfeet.controleretorno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.doctorfeet.controleretorno.entity.Funcionario;
import br.com.doctorfeet.controleretorno.service.ColaboradorService;

@Controller
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@RequestMapping("/colaborador")
	public String index(){
		
		return "cadastro-colaborador";
	}
	
	public Iterable<Funcionario> list(){
		
		Iterable<Funcionario> clientes = this.colaboradorService.findAll();
		
		return clientes;
	}
	
	@RequestMapping(value ="/colaborador/create", method = RequestMethod.POST)
	public void create(Funcionario colaborador){
		
		this.colaboradorService.save(colaborador);
	}
	
	@RequestMapping(value = "/colaborador/update", method = RequestMethod.PUT)
	public ModelAndView update(Funcionario colaborador){
		
		ModelAndView modelAndView = new ModelAndView();
		this.colaboradorService.save(colaborador);
		modelAndView.addObject("colaborador", colaborador);
		
		return modelAndView;
	}
	

}
