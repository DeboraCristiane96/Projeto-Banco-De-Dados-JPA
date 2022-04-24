
package com.projetoAcademia.Dac;

import com.projetoAcademia.DAO.ClienteDAO;
import com.projetoAcademia.DAO.EnderecoDAO;
import com.projetoAcademia.DAO.FuncionarioDAO;
import com.projetoAcademia.DAO.PagamentoDAO;
import com.projetoAcademia.DAO.TelefoneDAO;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Endereco;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Funcionario;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Telefone;
import java.util.Date;

/**
 *
 * @author debora
 */
public class MainSaveFuncionario {
     public static void main(String[] args) throws DacException {
        FuncionarioDAO funcionariodao = new FuncionarioDAO();
        EnderecoDAO endDao = new EnderecoDAO();
        TelefoneDAO fonedao = new TelefoneDAO();
        PagamentoDAO pag = new PagamentoDAO ();
        try {
            
            Endereco end = new Endereco();
            end.setRua("Rua Presidente Vargas");
            end.setNumero(404);
          
            Telefone fone = new Telefone();
            fone.setTelefone("99290-9867");

            Funcionario funcionario = new Funcionario();
            funcionario.setNome("Maria Júlia");
            funcionario.setCpf("234.006.876-11");
            funcionario.setData_nasc(new Date("05/09/1996"));
            funcionario.setEmail("MaryJu@gmail.com");
            funcionario.setSalario(1300.00f);
            
            funcionario.setEndereco(end);
            funcionario.addContatos(fone);
            fone.setTelefone_id(funcionario.getId());
            funcionario.setData_cadastro(new Date());
            funcionario.setCadastro_Id(funcionario.getId());
            // String prof = "Preparador Físico";
            //  Profissao prof  = Profissao.pegarProfissao(prof);
             // funcionario.setProfissao(prof);
            funcionario.addFuncionari_cadastro(funcionario);
            fonedao.save(fone);
            funcionariodao.save(funcionario);
           
            
        } finally {
            fonedao.close();
            endDao.close();
            funcionariodao.close();

        }
    }
}
