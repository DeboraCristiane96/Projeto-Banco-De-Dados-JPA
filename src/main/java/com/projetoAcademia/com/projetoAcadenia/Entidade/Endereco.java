package com.projetoAcademia.com.projetoAcadenia.Entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity

public class Endereco {
	@Id
	@Column(name = "numero")
	private int numero;

	@Column(name = "nome_rua")
	private String rua;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
