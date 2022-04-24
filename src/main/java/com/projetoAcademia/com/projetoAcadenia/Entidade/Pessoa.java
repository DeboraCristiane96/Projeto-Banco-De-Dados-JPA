package com.projetoAcademia.com.projetoAcadenia.Entidade;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo_cadastro")
public abstract class Pessoa extends Cadastro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome_completo")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date data_nasc;

    //GETTES E SETTES
	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public String getCpf() {return cpf;}

	public void setCpf(String cpf) {this.cpf = cpf;}

	public Date getData_nasc() {return data_nasc;}

	public void setData_nasc(Date data_nasc) {this.data_nasc = data_nasc;}

	public Integer getId() {return id;}

}