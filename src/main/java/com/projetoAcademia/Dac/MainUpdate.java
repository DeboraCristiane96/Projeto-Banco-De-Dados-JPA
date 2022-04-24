package com.projetoAcademia.Dac;

import com.projetoAcademia.DAO.ClienteDAO;
import com.projetoAcademia.DAO.EnderecoDAO;
import com.projetoAcademia.DAO.PacoteDAO;
import com.projetoAcademia.DAO.TelefoneDAO;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Cliente;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Endereco;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Pacote;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Telefone;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainUpdate {

    public static void main(String[] args) throws DacException {

        ClienteDAO clientedao = new ClienteDAO();
        PacoteDAO pacotedao = new PacoteDAO();
        EnderecoDAO endDao = new EnderecoDAO();
        TelefoneDAO fonedao = new TelefoneDAO();
        try {
            Pacote pacote = new Pacote();
            pacote.setName("Prata");

            Endereco end = new Endereco();
            end.setRua("Rua Presidente Vargas");
            end.setNumero(1224);

            Telefone fone = new Telefone();
            fone.setTelefone("99200-6560");

            Cliente cliente = new Cliente();
            cliente.setNome("Bruna Andrade");
            cliente.setCpf("235.426.876-19");
            cliente.setData_nasc(new Date("05/08/1997"));
            cliente.setEmail("bruninha@gmail.com");
            cliente.setEndereco(end);
            cliente.setPacote(pacote);
            cliente.addContatos(fone);
            endDao.save(end);
            pacotedao.save(pacote);
            fonedao.save(fone);
            clientedao.save(cliente);
            
             // Depois atualizar pacote
             Pacote pacote2 = new Pacote();
             pacote.setName("Ouro");
             cliente.setPacote(pacote);
             clientedao.update(cliente);
             
             System.out.println(pacote.getName());

        } finally {
            pacotedao.close();
            fonedao.close();
            endDao.close();
            clientedao.close();

        }
     
    }

}
