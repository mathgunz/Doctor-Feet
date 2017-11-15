package br.com.doctorfeet.controleretorno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.doctorfeet.controleretorno.entity.Feedback;
import br.com.doctorfeet.controleretorno.model.ContatoResumo;
import br.com.doctorfeet.controleretorno.service.FeedbackService;
import br.com.doctorfeet.controleretorno.service.HomeService;

@Controller
public class HomeController {
	
	 @Autowired
	 private HomeService service;

	 @Autowired
	 private FeedbackService feedbackService;
	 
    @RequestMapping("/")
    public ModelAndView index(){
    	
    	List<ContatoResumo> lista = this.listarClientesParaContato();
    	
    	ModelAndView model = new ModelAndView("index");
    	
    	model.addObject("contatos", lista);

    	model.addObject(new ContatoResumo());
    	model.addObject(new Feedback());    	
    	
        return model;
    }
    
    public List<ContatoResumo> listarClientesParaContato(){
    	
    	List<ContatoResumo> lista = this.service.listClientesParaContato();
    	
    	return lista;
    };
    
	@RequestMapping("/editaContato/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		
		List<ContatoResumo> lista = this.listarClientesParaContato();
		List<Feedback> feedbacks = this.feedbackService.getFeedbacks();
		
		ContatoResumo contatoResumo = new ContatoResumo();
		
		for(ContatoResumo contato : lista){
			if (contato.getClienteId() == id) {
				contatoResumo = contato;
			}
			
		}
		
		ModelAndView mv = new ModelAndView("edita-contato");
		
		contatoResumo.setFeedbacksForm(feedbacks);
		
		mv.addObject(contatoResumo);
		
		return mv;
	}
	
	@RequestMapping("/alterarContato")
	public String atualizarContato(@Validated ContatoResumo contatoResumo){
		
		
		this.service.atualizarContato(contatoResumo);
		
		
		return "redirect:/";
	}
    
}