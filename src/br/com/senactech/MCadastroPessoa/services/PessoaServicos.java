/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.services;

import br.com.senactech.MCadastroPessoa.dao.PessoaDAO;
import br.com.senactech.MCadastroPessoa.dao.DAOFactory;
import br.com.senactech.MCadastroPessoa.model.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author casso
 */
public class PessoaServicos {

    public void cadPessoa(Pessoa pVO) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.cadastrarPessoa(pVO);
    }

    public ArrayList<Pessoa> getPessoas() throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.buscarPessoas();
    }

    public boolean verCPF(String cpf) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.verCPF(cpf);
    }

    public Pessoa buscaPessoaBD(String cpf) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.getByDocBD(cpf);
    }

    public void deletarPessoaBD(int id) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.deletarPessoa(id);
    }

    public void atualizarPessoaBD(Pessoa pVO) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.atualizarPessoa(pVO);
    }

    public String getNomePessoa(int id) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.getNomePessoa(id);
    }

    public int getIdPessoa(String cpf) throws SQLException {
    PessoaDAO pDAO = DAOFactory.getPessoaDAO();
    return pDAO.getIdPessoa(cpf);
    }
    
    public String getCPFPessoa(int id) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.getCPFPessoa(id);
    }
}
