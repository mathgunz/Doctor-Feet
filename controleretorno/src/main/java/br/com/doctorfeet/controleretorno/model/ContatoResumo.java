package br.com.doctorfeet.controleretorno.model;

import java.util.List;

import br.com.doctorfeet.controleretorno.entity.Feedback;

public class ContatoResumo {

	private Long clienteId;

	private Long matricula;

	private String nome;

	private String telefone;

	private String ultimoAgendamento;

	private String ultimoContato;

	private String feedback;
	
	private List<Feedback> feedbacksForm;

	public List<Feedback> getFeedbacksForm() {
		return feedbacksForm;
	}

	public void setFeedbacksForm(List<Feedback> feedbacksForm) {
		this.feedbacksForm = feedbacksForm;
	}

	private String observacao;

	public ContatoResumo() {
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUltimoAgendamento() {
		return ultimoAgendamento;
	}

	public void setUltimoAgendamento(String ultimoAgendamento) {
		this.ultimoAgendamento = ultimoAgendamento;
	}

	public String getUltimoContato() {
		return ultimoContato;
	}

	public void setUltimoContato(String ultimoContato) {
		this.ultimoContato = ultimoContato;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
