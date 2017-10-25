package br.com.doctorfeet.controleretorno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
//	 @Autowired
//	 private ClienteRepository repository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
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