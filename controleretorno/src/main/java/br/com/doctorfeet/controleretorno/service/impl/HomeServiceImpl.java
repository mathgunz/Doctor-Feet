package br.com.doctorfeet.controleretorno.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctorfeet.controleretorno.entity.Agendamento;
import br.com.doctorfeet.controleretorno.entity.Cliente;
import br.com.doctorfeet.controleretorno.entity.Contato;
import br.com.doctorfeet.controleretorno.entity.Feedback;
import br.com.doctorfeet.controleretorno.entity.Funcionario;
import br.com.doctorfeet.controleretorno.entity.Status;
import br.com.doctorfeet.controleretorno.entity.TipoServico;
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

		if (contatoResumo.getFeedback().equals("1")) {

			if (contatoResumo.getContatoId() == null) {

				this.criarContato(contatoResumo);

				if (contatoResumo.getContatoId() != null) {
					this.criarAgendamento(contatoResumo);
				}
			} else {

				Contato contato = this.contatoRepository.findOne(contatoResumo.getContatoId());
				contato.setClienteId(new Cliente(contatoResumo.getClienteId()));
				contato.setFuncionarioId(new Funcionario(1));
				contato.setFeedbackId(new Feedback(Long.valueOf(contatoResumo.getFeedback())));
				contato.setDhContato(new Date());
				contato.setDhInclusao(new Date());
				contato.setObservacao(contatoResumo.getObservacao());

				this.contatoRepository.save(contato);

				if (contatoResumo.getAgendamentoId() != null) {
					Agendamento agendamento = this.agendamentoRepository.findOne(contatoResumo.getAgendamentoId());

					agendamento.setDhAgendamento(new Date());
					agendamento.setDhInclusao(new Date());
					agendamento.setStatusId(new Status(1));
					agendamento.setTipoServicoId(1l);

				} else {
					this.criarAgendamento(contatoResumo);
				}

			}

		} else if (contatoResumo.getFeedback().equals("3") || contatoResumo.getFeedback().equals("4")
				|| contatoResumo.getFeedback().equals("5")) {

			Contato contato = this.contatoRepository.findOne(contatoResumo.getContatoId());
			contato.setFeedbackId(new Feedback(Long.valueOf(contatoResumo.getFeedback())));
			contato.setObservacao(contatoResumo.getObservacao());

			this.contatoRepository.save(contato);

		} else if(contatoResumo.getFeedback().equals("2")) {
			
			Contato contato = this.contatoRepository.findOne(contatoResumo.getContatoId());
			contato.setClienteId(new Cliente(contatoResumo.getClienteId()));
			contato.setFuncionarioId(new Funcionario(1));
			contato.setFeedbackId(new Feedback(Long.valueOf(contatoResumo.getFeedback())));
			contato.setDhContato(new Date());
			contato.setDhInclusao(new Date());
			contato.setObservacao(contatoResumo.getObservacao());

			this.contatoRepository.save(contato);
		}

	}

	private void criarAgendamento(ContatoResumo contatoResumo) {

		Agendamento agendamento = new Agendamento();
		agendamento.setClienteId(new Cliente(contatoResumo.getClienteId()));
		agendamento.setContatoId(new Contato(contatoResumo.getContatoId()));
		agendamento.setDhInclusao(new Date());
		agendamento.setDhAgendamento(new Date());
		agendamento.setFuncionarioId(new Funcionario(1));
		agendamento.setStatusId(new Status(1));
		agendamento.setTipoServicoId(1l);

		this.agendamentoRepository.save(agendamento);

	}

	private void criarContato(ContatoResumo contatoResumo) {

		Cliente cliente = new Cliente();
		cliente.setId(contatoResumo.getClienteId());

		Feedback feedback = new Feedback();
		feedback.setId(Long.valueOf(contatoResumo.getFeedback()));

		Funcionario funcionario = new Funcionario();
		funcionario.setId(1);

		Contato contato = new Contato();
		contato.setClienteId(cliente);
		contato.setFeedbackId(feedback);
		contato.setDhContato(new Date());
		contato.setDhInclusao(new Date());
		contato.setObservacao(contatoResumo.getObservacao());
		contato.setFuncionarioId(funcionario);

		Contato contatoNovo = this.contatoRepository.save(contato);

		contatoResumo.setContatoId(contatoNovo.getId());
	}

}
