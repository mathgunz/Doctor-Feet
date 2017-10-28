package br.com.doctorfeet.controleretorno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctorfeet.controleretorno.model.Cliente;
import br.com.doctorfeet.controleretorno.repository.ClienteRepository;
import br.com.doctorfeet.controleretorno.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;

	public Iterable<Cliente> findAll() {
		return this.repository.findAll();
	}

	public Cliente findOne(Long id) {
		return this.repository.findOne(id);
	}

	public Cliente save(Cliente editarCliente) {
		return this.repository.save(editarCliente);
	}

}
