package br.com.doctorfeet.controleretorno.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.doctorfeet.controleretorno.entity.Contato;
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
    	
    	model.addObject(new ContatoResumo());
    	
    	model.addObject("contatos", lista);
    	
    	
        return model;
    }
    
    public List<ContatoResumo> listarClientesParaContato(){
    	
    	List<ContatoResumo> lista = this.service.listClientesParaContato();
    	
    	return lista;
    };
    
	@RequestMapping("/editaContato/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		
		List<ContatoResumo> lista = this.listarClientesParaContato();
		
		ContatoResumo contatoResumo = new ContatoResumo();
		
		for(ContatoResumo contato : lista){
			if (contato.getClienteId() == id) {
				contatoResumo = contato;
			}
			
		}
		
		ModelAndView mv = new ModelAndView("edita-contato");
		
		mv.addObject(contatoResumo);
		
		return mv;
	}
 
    
    
}