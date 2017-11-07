package br.com.doctorfeet.controleretorno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.doctorfeet.controleretorno.model.ContatoResumo;
import br.com.doctorfeet.controleretorno.service.HomeService;

@Controller
public class HomeController {
	
	 @Autowired
	 private HomeService service;

    @RequestMapping("/")
    public ModelAndView index(){
    	
    	List<ContatoResumo> lista = this.listarClientesParaContato();
    	
    	ModelAndView model = new ModelAndView("index");
    	model.addObject("contatos", lista);
    	
        return model;
    }
    
    public List<ContatoResumo> listarClientesParaContato(){
    	
    	List<ContatoResumo> lista = this.service.listClientesParaContato();
    	
    	return lista;
    };
    
//    @RequestMapping("/listaclientes")
//    public String listaConvidados(Model model){
//    	
//    	Iterable<Cliente> clientes = repository.findAll();
//    	
//    	model.addAttribute("clientes", clientes);
//    	
//    	return "listaconvidados";
//    }

}