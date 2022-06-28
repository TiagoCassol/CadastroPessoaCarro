/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.controller;

import mCadastroPessoaJF.MCadastroPessoaJF;
import java.util.ArrayList;
import br.com.senactech.MCadastroPessoa.model.VagaEstacionamento;

/**
 *
 * @author casso
 */
public class CVagaEstacionamento implements InterfaceController<VagaEstacionamento>{

    ArrayList<VagaEstacionamento> vagas = new ArrayList<>();
    int idVaga = 1;
    
    public int addID(){
        return this.idVaga++;
    }
    
    @Override
    public void add(VagaEstacionamento o) {
        vagas.add(o);
    }

    @Override
    public ArrayList<VagaEstacionamento> getAll() {
        return vagas;
  }

    @Override
    public boolean deletar(VagaEstacionamento o) {
       boolean del = vagas.remove(o);
       return del;
    }

    @Override
    public VagaEstacionamento getByDoc(String placa) {
         return null;
    }

    @Override
    public int gerarId() {
        return idVaga++;
    }
    
    public void mokVagas(){
        VagaEstacionamento v1 = new VagaEstacionamento();
        v1.setIdVaga(gerarId());
        v1.setTpVaga("carro");
        v1.setC(MCadastroPessoaJF.cadCarros.getByDoc("CHS6647"));
        vagas.add(v1);
       
        VagaEstacionamento v2 = new VagaEstacionamento();
        v2.setIdVaga(gerarId());
        v2.setTpVaga("carro");
        v2.setC(MCadastroPessoaJF.cadCarros.getByDoc("IPP1234"));
        vagas.add(v2);
    }
    
}
