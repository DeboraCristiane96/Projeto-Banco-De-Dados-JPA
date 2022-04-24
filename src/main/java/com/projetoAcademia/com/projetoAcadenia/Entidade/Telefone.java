package com.projetoAcademia.com.projetoAcadenia.Entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contato")
public class Telefone implements Serializable {
	@Id
	@Column(name = "numero_contato")
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name = "telefone_id")
	private Integer pessoa_id;

	public String getTelefone() {return telefone;}

	public void setTelefone(String telefone) {this.telefone = telefone;}

	public Integer getTelefone_id() {return pessoa_id;}

	public void setTelefone_id(Integer pessoa_id) {this.pessoa_id = pessoa_id;}

}
