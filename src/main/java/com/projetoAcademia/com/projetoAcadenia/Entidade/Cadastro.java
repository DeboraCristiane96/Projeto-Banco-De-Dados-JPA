package com.projetoAcademia.com.projetoAcadenia.Entidade;


import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo_cadastro")
public abstract class Cadastro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="cadastro_id")
    private Integer cadastro_id;

    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date data_cadastro;

    @OneToMany(mappedBy = "cadastro_cliente")
    private List<Cliente> cadastro_cliente;
    
    @OneToMany(mappedBy = "cadastro_funcionario")
    private List<Funcionario> cadastro_funcionario;

   
    public Integer getCadastro_Id() {
        return cadastro_id;
    }

    public void setCadastro_Id(Integer id) { this.cadastro_id = id; }

    public Date getData_cadastro() { return data_cadastro; }

    public void setData_cadastro(Date data_cadastro) {this.data_cadastro = data_cadastro; }

    public List<Cliente> getCliente_cadastro() { return cadastro_cliente;}

    public void addCliente_cadastro(Cliente cliente) {
            if(this.cadastro_cliente == null)
               this.cadastro_cliente = new ArrayList<Cliente>();
	    this.cadastro_cliente.add(cliente);
	}
    public List<Funcionario> getcadastro_funcionario() { return cadastro_funcionario;}

    public void addFuncionari_cadastro(Funcionario funcionario) {
            if(this.cadastro_funcionario == null)
               this.cadastro_funcionario = new ArrayList<Funcionario>();
	    this.cadastro_funcionario.add(funcionario);
	}
}
