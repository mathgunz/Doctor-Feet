/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.doctorfeet.controleretorno.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.doctorfeet.controleretorno.model.ContatoResumo;

@Entity
@Table(name = "agendamento")
public class Agendamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo_servico_id")
    private Integer tipoServicoId;

    @Column(name = "dh_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dhInclusao;

    @Column(name = "dh_agendamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dhAgendamento;

    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente clienteId;

    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Status statusId;

    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionarioId;

    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contato contatoId;
    
    public Agendamento(){}

    public Agendamento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoServicoId() {
        return tipoServicoId;
    }

    public void setTipoServicoId(Integer tipoServicoId) {
        this.tipoServicoId = tipoServicoId;
    }

    public Date getDhInclusao() {
        return dhInclusao;
    }

    public void setDhInclusao(Date dhInclusao) {
        this.dhInclusao = dhInclusao;
    }

    public Date getDhAgendamento() {
        return dhAgendamento;
    }

    public void setDhAgendamento(Date dhAgendamento) {
        this.dhAgendamento = dhAgendamento;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public Funcionario getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Funcionario funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Contato getContatoId() {
        return contatoId;
    }

    public void setContatoId(Contato contatoId) {
        this.contatoId = contatoId;
    }

	public ContatoResumo convertToContatoResumo() {
		
		ContatoResumo contatoResumo = new ContatoResumo();
		
		contatoResumo.setClienteId(this.clienteId.getId());
		contatoResumo.setMatricula(this.clienteId.getMatricula());
		contatoResumo.setNome(this.clienteId.getNome());
		contatoResumo.setTelefone(this.clienteId.getTelefone());
		contatoResumo.setFeedback(this.contatoId.getFeedbackId().getNome());
		contatoResumo.setObservacao(this.contatoId.getObservacao());
		contatoResumo.setUltimoContato(this.contatoId.getDhContato() != null ? this.contatoId.getDhContato().toString(): null);
		contatoResumo.setUltimoAgendamento(this.dhAgendamento != null ? this.dhAgendamento.toString() : null);
		
		return contatoResumo;
	}

}
