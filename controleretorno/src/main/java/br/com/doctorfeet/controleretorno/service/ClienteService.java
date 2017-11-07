package br.com.doctorfeet.controleretorno.service;

import br.com.doctorfeet.controleretorno.entity.Cliente;

public interface ClienteService {

	Iterable<Cliente> findAll();

	Cliente findOne(Long id);

	Cliente save(Cliente editarCliente);

}
