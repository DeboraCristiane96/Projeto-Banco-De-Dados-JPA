package com.projetoAcademia.com.projetoAcadenia.Entidade;

import javax.persistence.*;
import java.util.List;
        
@Entity
@Table(name ="pacote")
public class Pacote extends Pagamento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome_pacote")
    private String name;

    @Column(name = "descricao_pacote")
    @Transient
    private String descricao;
  
    
    @OneToMany(mappedBy = "pacote_cliente")
    private List<Cliente> clientes;
    
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}
	public List<Cliente> getClientes() {return clientes;}
	public void setClientes(List<Cliente> clientes) {this.clientes = clientes;}
}