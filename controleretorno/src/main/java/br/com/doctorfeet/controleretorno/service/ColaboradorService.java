package br.com.doctorfeet.controleretorno.service;

import br.com.doctorfeet.controleretorno.entity.Funcionario;

public interface ColaboradorService {

	Iterable<Funcionario> findAll();

	void save(Funcionario colaborador);

}
