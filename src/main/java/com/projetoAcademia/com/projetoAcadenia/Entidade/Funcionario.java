
package com.projetoAcademia.com.projetoAcadenia.Entidade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author debora
 */

@Entity
@DiscriminatorValue("F")
@Table(name = "funcionario")
public class Funcionario extends Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "email_Funcionario")
    private  String email;

   
    @JoinColumn(name = "salario_funcionario")
    private float salario;
    
    @OneToMany(mappedBy = "telefone_fk")
    private List<Telefone> contatos;
    
    @OneToOne
    @JoinColumn(name = "endereco_funcionario_fk")
    private Endereco endereco;
    
    @Column(name = "Profissional")
    @Enumerated(EnumType.STRING)
    private Profissao profissao;

    public String getEmail() {return email;}

    public void setEmail(String email) { this.email = email;}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public float getSalario() { return salario;}

    public void setSalario(float salario) {this.salario = salario;}

    public List<Telefone> getContatos() {return contatos;}

    public void addContatos(Telefone contato) {
            if(this.contatos == null)
               this.contatos = new ArrayList<Telefone>();
	
	    this.contatos.add(contato);
        }
    
    public Endereco getEndereco() { return endereco;}

    public void setEndereco(Endereco endereco) {this.endereco = endereco;}

    public Profissao getProfissao() {return profissao; }

    public void setProfissao(Profissao profissao) {this.profissao = profissao; }
    
    
    
}
