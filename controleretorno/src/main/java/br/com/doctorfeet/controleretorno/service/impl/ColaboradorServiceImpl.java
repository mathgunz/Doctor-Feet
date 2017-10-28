package br.com.doctorfeet.controleretorno.service.impl;

import org.springframework.stereotype.Service;

import br.com.doctorfeet.controleretorno.model.Funcionario;
import br.com.doctorfeet.controleretorno.repository.ColaboradorRepository;
import br.com.doctorfeet.controleretorno.service.ColaboradorService;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

	private ColaboradorRepository repository;
	
	public Iterable<Funcionario> findAll() {
		return this.repository.findAll();
	}

	public void save(Funcionario colaborador) {
		this.save(colaborador);
	}
}
