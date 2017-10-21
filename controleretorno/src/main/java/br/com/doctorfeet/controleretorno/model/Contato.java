/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.doctorfeet.controleretorno.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mathe
 */
@Entity
@Table(name = "contato")
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "dh_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dhInclusao;

    @Column(name = "dh_contato")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dhContato;

    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente clienteId;

    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionarioId;

    @JoinColumn(name = "feedback_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Feedback feedbackId;

    @OneToMany(mappedBy = "contatoId", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentoList;

    public Contato(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDhInclusao() {
        return dhInclusao;
    }

    public void setDhInclusao(Date dhInclusao) {
        this.dhInclusao = dhInclusao;
    }

    public Date getDhContato() {
        return dhContato;
    }

    public void setDhContato(Date dhContato) {
        this.dhContato = dhContato;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Funcionario getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Funcionario funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Feedback getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Feedback feedbackId) {
        this.feedbackId = feedbackId;
    }

    @XmlTransient
    public List<Agendamento> getAgendamentoList() {
        return agendamentoList;
    }

    public void setAgendamentoList(List<Agendamento> agendamentoList) {
        this.agendamentoList = agendamentoList;
    }

}
