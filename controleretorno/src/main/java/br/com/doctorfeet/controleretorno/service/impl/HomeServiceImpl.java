package br.com.doctorfeet.controleretorno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctorfeet.controleretorno.entity.Agendamento;
import br.com.doctorfeet.controleretorno.entity.Cliente;
import br.com.doctorfeet.controleretorno.entity.Contato;
import br.com.doctorfeet.controleretorno.model.ContatoResumo;
import br.com.doctorfeet.controleretorno.repository.AgendamentoRepository;
import br.com.doctorfeet.controleretorno.repository.ClienteRepository;
import br.com.doctorfeet.controleretorno.repository.ContatoRepository;
import br.com.doctorfeet.controleretorno.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public List<ContatoResumo> listClientesParaContato() {

		List<Contato> contatos = this.contatoRepository.findContatos();

		List<Cliente> clientes = this.clienteRepository.findClientesAvailable();

		List<Agendamento> agendamentos = this.agendamentoRepository.findAgendamentosAvailable();

		List<ContatoResumo> contatosResumo = new ArrayList<ContatoResumo>();

		for (Contato contato : contatos) {

			ContatoResumo contatoResumo = contato.convertToContatoResumo();

			contatosResumo.add(contatoResumo);
		}

		for (Cliente cliente : clientes) {

			ContatoResumo contatoResumo = cliente.convertToContatoResumo();

			contatosResumo.add(contatoResumo);
		}

		for (Agendamento agendamento : agendamentos) {

			ContatoResumo contatoResumo = agendamento.convertToContatoResumo();

			contatosResumo.add(contatoResumo);
		}

		return contatosResumo;
	}

	public void atualizarContato(ContatoResumo contatoResumo) {

		if (contatoResumo.getFeedback().equals("3") || contatoResumo.getFeedback().equals("4")
				|| contatoResumo.getFeedback().equals("5")|| contatoResumo.getFeedback().equals("2")) {

			// ele vai continuar aparecendo mas vamos precisar atualizar os dados
			
		}else if(contatoResumo.getFeedback().equals("1")){
			
			// Então ele agendou, vamos remover o contato e inserir um novo e atualizado e adicionar nova log
			
		}

	}

}
