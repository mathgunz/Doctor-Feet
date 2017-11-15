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

			if (contatoResumo.getAgendamentoId() != null) {

				this.agendamentoRepository.delete(contatoResumo.getAgendamentoId());

				this.contatoRepository.delete(contatoResumo.getContatoId());

				Cliente cliente = new Cliente();
				cliente.setId(contatoResumo.getClienteId());

				Funcionario funcionario = new Funcionario();
				funcionario.setId(1);

				Feedback feedback = new Feedback();
				feedback.setId(Long.valueOf(contatoResumo.getFeedback()));

				Contato contato = new Contato();
				contato.setObservacao(contatoResumo.getObservacao());
				contato.setClienteId(cliente);
				contato.setFuncionarioId(funcionario);
				contato.setFeedbackId(feedback);
				contato.setFuncionarioId(funcionario);
				contato.setDhContato(new Date());
				contato.setDhInclusao(new Date());

				Contato contatoEntity = this.contatoRepository.save(contato);

				if (contatoEntity.getId() != null) {
					Agendamento agendamento = new Agendamento();
					agendamento.setClienteId(cliente);
					agendamento.setContatoId(contato);
					agendamento.setDhInclusao(new Date());
					agendamento.setDhAgendamento(new Date());
					agendamento.setFuncionarioId(funcionario);
					agendamento.setStatusId(null);
					agendamento.setTipoServicoId(null);

					this.agendamentoRepository.save(agendamento);
				}

			} else {

				Funcionario funcionario = new Funcionario();
				funcionario.setId(1);

				Feedback feedback = new Feedback();
				feedback.setId(Long.valueOf(contatoResumo.getFeedback()));

				Contato contatoEntity = this.contatoRepository.findOne(contatoResumo.getContatoId());
				contatoEntity.setObservacao(contatoResumo.getObservacao());
				contatoEntity.setFeedbackId(feedback);
				contatoEntity.setFuncionarioId(funcionario);
				contatoEntity.setDhInclusao(new Date());
				contatoEntity.setDhContato(new Date());

				Contato contatoRetorno = this.contatoRepository.save(contatoEntity);

				if (contatoRetorno.getId() != null) {
					Agendamento agendamento = new Agendamento();
					agendamento.setClienteId(contatoEntity.getClienteId());
					agendamento.setContatoId(contatoEntity);
					agendamento.setDhInclusao(new Date());
					agendamento.setDhAgendamento(new Date());
					agendamento.setFuncionarioId(funcionario);
					agendamento.setStatusId(null);
					agendamento.setTipoServicoId(null);

					this.agendamentoRepository.save(agendamento);
				}

			}

			System.out.println("");

		} else {
			// Então ele agendou, vamos remover o contato e inserir um novo e
			// atualizado e adicionar nova log

			if (contatoResumo.getContatoId() == null) {

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

				Funcionario funcionario = new Funcionario();
				funcionario.setId(1);

				Feedback feedback = new Feedback();
				feedback.setId(Long.valueOf(contatoResumo.getFeedback()));

				Contato contatoEntity = this.contatoRepository.findOne(contatoResumo.getContatoId());
				contatoEntity.setObservacao(contatoResumo.getObservacao());
				contatoEntity.setFeedbackId(feedback);
				contatoEntity.setFuncionarioId(funcionario);

				Contato contatoRetorno = this.contatoRepository.save(contatoEntity);
		}

	}

}
