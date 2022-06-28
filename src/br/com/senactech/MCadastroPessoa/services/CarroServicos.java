/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.services;

import br.com.senactech.MCadastroPessoa.dao.DAOFactory;
import br.com.senactech.MCadastroPessoa.dao.CarroDAO;
import br.com.senactech.MCadastroPessoa.model.Carro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author casso
 */
public class CarroServicos {
    public void cadCarro(Carro cVO) throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.cadastrarCarro(cVO);
    }
    
   public ArrayList<Carro> getCarros() throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        return cDAO.buscarCarros();
    }

    public boolean verPlaca(String placa) throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        return cDAO.verPlaca(placa);
    }

    public Carro buscaCarroBD(String placa) throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        return cDAO.getByDocBD(placa);
    }

    public void deletarCarroBD(int id) throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.deletarCarro(id);
    }
    
    public void atualizarCarroBD(Carro cVO) throws SQLException{
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.atualizarCarro(cVO);
    } 
}
