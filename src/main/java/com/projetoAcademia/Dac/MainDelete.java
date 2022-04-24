/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetoAcademia.Dac;

import com.projetoAcademia.DAO.ClienteDAO;
import com.projetoAcademia.DAO.EnderecoDAO;
import com.projetoAcademia.DAO.PacoteDAO;
import com.projetoAcademia.DAO.TelefoneDAO;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Cliente;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Endereco;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Pacote;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Telefone;

import java.util.Date;

/**
 *
 * @author debora
 */
public class MainDelete {

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
            end.setNumero(34);

            Telefone fone = new Telefone();
            fone.setTelefone("99290-9867");

            Cliente cliente = new Cliente();
            cliente.setNome("Ana Maria");
            cliente.setCpf("234.456.876-11");
            cliente.setData_nasc(new Date("05/09/1975"));
            cliente.setEmail("ana@gmail.com");
            cliente.setEndereco(end);
            cliente.setPacote(pacote);
            cliente.addContatos(fone);
            fone.setTelefone_id(cliente.getId());

            pacotedao.save(pacote);
            endDao.save(end);
            fonedao.save(fone);
            clientedao.save(cliente);

        } finally {
            pacotedao.close();
            fonedao.close();
            endDao.close();
            clientedao.close();
        }
    }

}
