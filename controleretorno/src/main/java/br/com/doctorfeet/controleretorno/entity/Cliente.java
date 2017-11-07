package br.com.doctorfeet.controleretorno.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import br.com.doctorfeet.controleretorno.model.ContatoResumo;

@Entity(name="cliente")
public class Cliente {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "matricula")
    private Long matricula;

    @Column(name = "dh_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dhInclusao;

    @OneToMany(mappedBy = "clienteId", fetch = FetchType.LAZY)
    private List<Contato> contatoList;

    @OneToMany(mappedBy = "clienteId", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentoList;

    public Cliente(){}
    
    public Cliente(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Date getDhInclusao() {
        return dhInclusao;
    }

    public void setDhInclusao(Date dhInclusao) {
        this.dhInclusao = dhInclusao;
    }

    @XmlTransient
    public List<Contato> getContatoList() {
        return contatoList;
    }

    public void setContatoList(List<Contato> contatoList) {
        this.contatoList = contatoList;
    }

    @XmlTransient
    public List<Agendamento> getAgendamentoList() {
        return agendamentoList;
    }

    public void setAgendamentoList(List<Agendamento> agendamentoList) {
        this.agendamentoList = agendamentoList;
    }

	public ContatoResumo convertToContatoResumo() {
		
		ContatoResumo contatoResumo = new ContatoResumo();
		
		contatoResumo.setClienteId(this.id);
		contatoResumo.setMatricula(this.matricula);
		contatoResumo.setTelefone(this.telefone);
		contatoResumo.setNome(this.nome);
		
		return contatoResumo;
	}
}
