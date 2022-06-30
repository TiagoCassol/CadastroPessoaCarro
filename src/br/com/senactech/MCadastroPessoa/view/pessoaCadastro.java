/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.view;

import javax.swing.JOptionPane;

import br.com.senactech.MCadastroPessoa.util.ValidaCPF;
import java.util.regex.PatternSyntaxException;
import javax.swing.JButton;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static mCadastroPessoaJF.MCadastroPessoaJF.cadPessoas;
import br.com.senactech.MCadastroPessoa.model.Pessoa;
import br.com.senactech.MCadastroPessoa.services.PessoaServicos;
import br.com.senactech.MCadastroPessoa.services.ServicosFactory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author casso
 */
public class pessoaCadastro extends javax.swing.JFrame {

    JButton btnClick = null;

    /**
     * Creates new form pessoaCadastro
     */
    public pessoaCadastro() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        //cadPessoas.mokPessoas();
        // addRowToTable();
        addRowToTableBD();
    }

    public void addRowToTable() {
        //cria obj model e recebe a modelagem da tabela jtPessoa do JFrame
        DefaultTableModel model = (DefaultTableModel) jtPessoas.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[4];//cria vetor para as colunas da tabela
        for (Pessoa p : cadPessoas.getAll()) {
            rowData[0] = p.getNomePessoa();
            rowData[1] = p.getCpf();
            rowData[2] = p.getTelefone();
            if (p.isStatus()) {
                rowData[3] = "Ativo";
            } else {
                rowData[3] = "Inativo";
            }
            model.addRow(rowData);
        }
    }

    public void addRowToTableBD() throws SQLException {
        //cria obj model e recebe a modelagem da tabela jtPessoa do JFrame
        DefaultTableModel model = (DefaultTableModel) jtPessoas.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[4];//cria vetor para as colunas da tabela
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        for (Pessoa p : pessoaS.getPessoas()) {
            rowData[0] = p.getNomePessoa();
            rowData[1] = p.getCpf();
            rowData[2] = p.getTelefone();
            if (p.isStatus()) {
                rowData[3] = "Ativo";
            } else {
                rowData[3] = "Inativo";
            }
            model.addRow(rowData);
        }
    }

    public void jTableFilterClear() {
        DefaultTableModel model = (DefaultTableModel) jtPessoas.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        jtPessoas.setRowSorter(sorter);
        sorter.setRowFilter(null);
    }

    public Boolean validaInputs() {
        String telefone = jtfTelefone.getText();
        if (jtfNome.getText().isEmpty() || jtfCPF.getText().isEmpty()
                || jtfEndereco.getText().isEmpty() || jtfTelefone.getText().isEmpty()
                || jtfIdade.getText().isEmpty() || (!jRadioButton1.isSelected()
                && !jRadioButton2.isSelected())) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", ".:Erro:.", JOptionPane.ERROR_MESSAGE);
            jtfNome.requestFocus();
            return false;
        }
        if (telefone.length() < 14) {
            JOptionPane.showMessageDialog(this, "Telefone informado esta incorreto", ".:Erro:.", JOptionPane.ERROR_MESSAGE);
            jtfTelefone.requestFocus();
            return false;
        }
        if (!jtfIdade.getText().isEmpty()) {
            int idade = Integer.parseInt(jtfIdade.getText());
            if (idade == 0 || idade > 120) {
                JOptionPane.showMessageDialog(this, "Idade informada esta incorreta!", ".:Erro:.", JOptionPane.ERROR_MESSAGE);
                jtfIdade.requestFocus();
                return false;
            }
        }

        if (btnClick.getText() == "Salvar") {
            PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
            String cpf = jtfCPF.getText().substring(0, 3)
                    + jtfCPF.getText().substring(4, 7)
                    + jtfCPF.getText().substring(8, 11)
                    + jtfCPF.getText().substring(12, 14);

            if (!ValidaCPF.isCPF(cpf)) {
                JOptionPane.showMessageDialog(this,
                        "CPF informado esta incorreto!!!",
                        ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfCPF.requestFocus();
                return false;
            } else try {
                if (!pessoaS.verCPF(jtfCPF.getText())) {
                    JOptionPane.showMessageDialog(this,
                            "CPF já cadastrado!!!",
                            ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                    jtfCPF.requestFocus();
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(pessoaCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgStatus = new javax.swing.ButtonGroup();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfEndereco = new javax.swing.JTextField();
        jtfIdade = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jBSalvar = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPessoas = new javax.swing.JTable();
        jbDeletar = new javax.swing.JButton();
        jbConfirmar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbPesqCPF = new javax.swing.JButton();
        jtfTelefone = new javax.swing.JFormattedTextField();
        jtfCPF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Pessoa");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro Pessoa");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Endereço:");

        jLabel5.setText("Telefone:");

        jLabel6.setText("Idade:");

        jLabel7.setText("Status");

        jtfNome.setToolTipText("Nome Completo");
        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });
        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeKeyTyped(evt);
            }
        });

        jtfEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEnderecoActionPerformed(evt);
            }
        });
        jtfEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEnderecoKeyTyped(evt);
            }
        });

        jtfIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdadeActionPerformed(evt);
            }
        });
        jtfIdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdadeKeyTyped(evt);
            }
        });

        bgStatus.add(jRadioButton1);
        jRadioButton1.setText("Ativo");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        bgStatus.add(jRadioButton2);
        jRadioButton2.setText("Inativo");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        jtPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Telefone", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPessoasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPessoas);

        jbDeletar.setText("Deletar");
        jbDeletar.setEnabled(false);
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jbConfirmar.setText("Confirmar");
        jbConfirmar.setEnabled(false);
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbPesqCPF.setForeground(new java.awt.Color(0, 0, 255));
        jbPesqCPF.setText("Pesquisar CPF");
        jbPesqCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesqCPFActionPerformed(evt);
            }
        });

        try {
            jtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jtfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCPFFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNome)
                            .addComponent(jtfEndereco)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jRadioButton2))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbPesqCPF)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBSalvar)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jbEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbConfirmar)
                        .addGap(33, 33, 33)
                        .addComponent(jbDeletar)
                        .addGap(32, 32, 32)
                        .addComponent(jBSair))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBLimpar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jbPesqCPF)
                    .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jtfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBSalvar)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jBLimpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSair)
                    .addComponent(jbDeletar)
                    .addComponent(jbConfirmar)
                    .addComponent(jbEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        // TODO add your handling code here:
        jtfCPF.setText("");
        jtfEndereco.setText("");
        jtfIdade.setText("");
        jtfNome.setText("");
        jtfTelefone.setText("");
        bgStatus.clearSelection();
        jtfNome.requestFocus();

        jBSalvar.setEnabled(true);
        jbEditar.setEnabled(false);
        jbConfirmar.setEnabled(false);
        jbDeletar.setEnabled(false);
        jbPesqCPF.setEnabled(true);
        jtfCPF.setEnabled(true);
        jTableFilterClear();

    }//GEN-LAST:event_jBLimparActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jtfNomeActionPerformed

    private void jtfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321!@#$%¨&*()_+-={}[]/?;:|";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfNomeKeyTyped

    private void jtfIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdadeActionPerformed

    private void jtfIdadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdadeKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfIdadeKeyTyped

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        // TODO add your handling code here:
        btnClick = (JButton) evt.getSource();
        if (validaInputs()) {
            int id = cadPessoas.gerarId();
            String nomePessoa = jtfNome.getText();
            String cpf = jtfCPF.getText();
            String endereco = jtfEndereco.getText();
            String telefone = jtfTelefone.getText();
            int idade = Integer.parseInt(jtfIdade.getText());
            boolean status = jRadioButton1.isSelected();

            Pessoa p = new Pessoa(id, nomePessoa, cpf, endereco, telefone, idade, status);
            //cadPessoas.add(p);
            PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
            try {
                pessoaS.cadPessoa(p);
                jBLimpar.doClick();
                //addRowToTable();
                addRowToTableBD();
                JOptionPane.showMessageDialog(this, "Pessoa salva com sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro! " + ex.getMessage(),
                        "erro", JOptionPane.ERROR_MESSAGE);
            }
            //JOptionPane.showMessageDialog(this, "Pessoa salva com sucesso");
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jtfEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEnderecoKeyTyped
        // TODO add your handling code here:
        String caracteres = "!@#$%¨&*()_+={}[]?;|";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfEnderecoKeyTyped

    private void jtfEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEnderecoActionPerformed

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        // TODO add your handling code here:
        jbEditar.setEnabled(false);
        int linha;
        String cpf;
        linha = jtPessoas.getSelectedRow();
        cpf = (String) jtPessoas.getValueAt(linha, 1);
        //Pessoa p = cadPessoas.getByDoc(cpf);
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        Pessoa p = new Pessoa();
        try {
            p = pessoaS.buscaPessoaBD(cpf);
        } catch (SQLException ex) {
            Logger.getLogger(pessoaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        //int resposta = JOptionPane.showConfirmDialog(this, "deseja realmente deletar " + p.getNomePessoa() + "?", ".:Deletar:.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        Object[] resp = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this,
                "Deseja realmente deletar " + p.getNomePessoa() + "?",
                ".: Deletar :.", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, resp, resp[0]);
        if (resposta == 0) {
            //cadPessoas.deletar(p);
            try {
                //addRowToTable();
                pessoaS.deletarPessoaBD(p.getIdPessoa());
                addRowToTableBD();
                JOptionPane.showMessageDialog(this, "Pessoa deletada com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(pessoaCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Entedemos sua decisão", "", JOptionPane.INFORMATION_MESSAGE);
        }
        jbDeletar.setEnabled(false);
    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jtPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPessoasMouseClicked
        // TODO add your handling code here:
        jbDeletar.setEnabled(true);
        jbEditar.setEnabled(true);
    }//GEN-LAST:event_jtPessoasMouseClicked

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        // TODO add your handling code here:
        btnClick = (JButton) evt.getSource();
        if (validaInputs()) {
            try {
                PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
                //Pessoa p = cadPessoas.getByDoc(jtfCPF.getText())8;
                Pessoa p = pessoaS.buscaPessoaBD(jtfCPF.getText());
                p.setNomePessoa(jtfNome.getText());
                p.setCpf(jtfCPF.getText());
                p.setEndereco(jtfEndereco.getText());
                p.setIdade(Integer.parseInt(jtfIdade.getText()));
                p.setTelefone(jtfTelefone.getText());
                if (jRadioButton1.isSelected()) {
                    p.setStatus(true);
                } else {
                    p.setStatus(false);
                }
                //atualiza pessoa no BD com dados na tela
                pessoaS.atualizarPessoaBD(p);
                // addRowTo Table();
                addRowToTableBD();
            } catch (SQLException ex) {
                Logger.getLogger(pessoaCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
            jBLimpar.doClick();
            jBLimpar.setText("Limpar");
            jTableFilterClear();
            String msg = "Dados atualizados com sucesso!";
            JOptionPane.showMessageDialog(this, msg, ".: Atualizar :.",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            jBLimpar.doClick();
            jtfCPF.setEnabled(true);
        }
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            //ajustando comportamento dos botões
            jbDeletar.setEnabled(false);
            jBSalvar.setEnabled(false);
            jbEditar.setEnabled(false);
            jtfCPF.setEnabled(false);
            jbPesqCPF.setEnabled(false);
            jbConfirmar.setEnabled(true);
            jBLimpar.setText("Cancelar");
            //carregar os dados da pessoa selecionada nos JTextFields
            int linha;
            String cpf;
            linha = jtPessoas.getSelectedRow();
            cpf = (String) jtPessoas.getValueAt(linha, 1);
            //Pessoa p = cadPessoas.getByDoc(cpf);
            PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
            Pessoa p = pessoaS.buscaPessoaBD(cpf);

            jtfNome.setText(p.getNomePessoa());
            jtfCPF.setText(p.getCpf());
            jtfEndereco.setText(p.getEndereco());
            jtfTelefone.setText(p.getTelefone());
            jtfIdade.setText(Integer.toString(p.getIdade()));
            if (p.isStatus()) {
                jRadioButton1.setSelected(true);
                jRadioButton2.setSelected(false);
            } else {
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pessoaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbPesqCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesqCPFActionPerformed
        // TODO add your handling code here:
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        String cpf = jtfCPF.getText().substring(0, 3)
                + jtfCPF.getText().substring(4, 7)
                + jtfCPF.getText().substring(8, 11)
                +jtfCPF.getText().substring(12, 14);
        
        if (!ValidaCPF.isCPF(cpf)) {
            JOptionPane.showMessageDialog(this,
                    "CPF informado esta incorreto!!!",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jtfCPF.requestFocus();
        } else try {
            if (!pessoaS.verCPF(jtfCPF.getText())) {
                DefaultTableModel model = (DefaultTableModel) jtPessoas.getModel();
                final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                jtPessoas.setRowSorter(sorter);
                String text = jtfCPF.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    try {
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    } catch (PatternSyntaxException pse) {
                        JOptionPane.showMessageDialog(this, "Registro não encontrado!");
                    }
                }
                /*
                Pessoa p = cadPessoas.getByDoc(jtfCPF.getText());
                jtfNome.setText(p.getNomePessoa());
                jtfCPF.setText(p.getCpf());
                jtfEndereco.setText(p.getEndereco());
                jtfTelefone.setText(p.getTelefone());
                jtfIdade.setText(Integer.toString(p.getIdade()));
                if (p.isStatus()) {
                    jRadioButton1.setSelected(true);
                    jRadioButton2.setSelected(false);
                } else {
                    jRadioButton1.setSelected(false);
                    jRadioButton2.setSelected(true);
                }
                jbConfirmar.setEnabled(true);
                jBSalvar.setEnabled(false);
                
                jTableFilterClear();
                 */
            }
        } catch (SQLException ex) {
            Logger.getLogger(pessoaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbPesqCPFActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jtfCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCPFFocusLost
        // TODO add your handling code here:
        //860.516.950-87
        //

    }//GEN-LAST:event_jtfCPFFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pessoaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pessoaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pessoaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pessoaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new pessoaCadastro().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(pessoaCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgStatus;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbPesqCPF;
    private javax.swing.JTable jtPessoas;
    private javax.swing.JFormattedTextField jtfCPF;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfIdade;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JFormattedTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables
}
/*int count=0;
         if (jRadioButton1.isSelected()) {;
            count++;
        }
        if (jRadioButton2.isSelected()) {;
            count++;
        }
         if (count == 0) {
           JOptionPane.showMessageDialog(null, "Nenhum status selecionado", ".:Status:.", JOptionPane.ERROR_MESSAGE);
        } else{
              JOptionPane.showMessageDialog(null, "Nenhum scionado");
         }
 */
