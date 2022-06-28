/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.controller;

import java.util.ArrayList;
import br.com.senactech.MCadastroPessoa.model.Carro;

/**
 *
 * @author casso
 */
public interface InterfaceController<T>{
    
    public int gerarId();
    
    public void add(T o);
    
    public ArrayList<T> getAll();
    
    public boolean deletar(T id);
    
    public T getByDoc(String placa);
    
}
