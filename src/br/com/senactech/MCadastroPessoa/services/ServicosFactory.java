/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.services;

/**
 *
 * @author casso
 */
public class ServicosFactory {
  private static PessoaServicos pessoaServicos = new PessoaServicos();
  private static CarroServicos carroServicos = new CarroServicos();
  
  public static PessoaServicos getPessoaServicos(){
      return pessoaServicos;
  }
  
  public static CarroServicos getCarroServicos(){
      return carroServicos;
  }
}
