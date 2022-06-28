/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.dao;

/**
 *
 * @author casso
 */
public class DAOFactory {
    private static PessoaDAO pessoaDAO = new PessoaDAO();
    private static CarroDAO carroDAO = new CarroDAO();
    
    public static PessoaDAO getPessoaDAO(){
        return pessoaDAO;
    }
    public static CarroDAO getCarroDAO(){
        return carroDAO;
    }
}
