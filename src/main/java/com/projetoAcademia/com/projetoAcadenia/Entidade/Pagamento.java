package com.projetoAcademia.com.projetoAcadenia.Entidade;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pagamento")
    private float pagamento;

    @OneToOne
    @JoinColumn(name = "pacote_id")
    private Pacote pagamento_pacote;

    @OneToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;

	public float getPagamento() {return pagamento;}

	public void setPagamento(float pagamento) {this.pagamento = pagamento;}

}
