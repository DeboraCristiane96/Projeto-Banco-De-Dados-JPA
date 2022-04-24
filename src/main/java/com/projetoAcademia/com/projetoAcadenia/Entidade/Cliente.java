package com.projetoAcademia.com.projetoAcadenia.Entidade;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("C")
@Table(name = "cliente")
public class Cliente extends Pessoa {
    
    @Column(name = "email_cliente")
    private  String email;

    @OneToMany(mappedBy = "telefones")
    private List<Telefone> contatos;

    @OneToOne
	@JoinColumn(name = "endereco_cliente_fk")
    private Endereco endereco_cliente;

    @ManyToOne
    private Pacote pacote_cliente;

    @ManyToMany
    @JoinTable(name = "cliente_profissional",
    joinColumns = @JoinColumn(name = "cliente_id"),
    inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
    private List<Funcionario> funcionarios;
    
	public String getEmail() {return email;}

	public void setEmail(String email) { this.email = email;}

	public List<Telefone> getContatos() {return contatos;}

	public void addContatos(Telefone contato) {
            if(this.contatos == null)
               this.contatos = new ArrayList<Telefone>();
	
	    this.contatos.add(contato);
        }

	public Endereco getEndereco() {return endereco_cliente;}

	public void setEndereco(Endereco endereco) {this.endereco_cliente = endereco;}

	public Pacote getPacote() {return pacote_cliente;}

	public void setPacote(Pacote pacote) {this.pacote_cliente = pacote;}

}
