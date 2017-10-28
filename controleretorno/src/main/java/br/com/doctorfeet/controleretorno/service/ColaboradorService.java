package br.com.doctorfeet.controleretorno.service;

import br.com.doctorfeet.controleretorno.model.Funcionario;

public interface ColaboradorService {

	Iterable<Funcionario> findAll();

	void save(Funcionario colaborador);

}
