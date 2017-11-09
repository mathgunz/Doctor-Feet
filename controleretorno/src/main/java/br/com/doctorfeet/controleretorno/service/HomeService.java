package br.com.doctorfeet.controleretorno.service;

import java.util.List;

import br.com.doctorfeet.controleretorno.model.ContatoResumo;

public interface HomeService {

	List<ContatoResumo> listClientesParaContato();

	void atualizarContato(ContatoResumo contatoResumo);

}
