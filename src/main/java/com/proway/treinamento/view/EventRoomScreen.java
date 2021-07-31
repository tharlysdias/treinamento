/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;

/**
 * @author tharl
 */
public class EventRoomScreen extends javax.swing.JInternalFrame {

    EventRoomTableModel Modelo;

    public void LoadTableRoom() {
        Modelo = new EventRoomTableModel(EventRoomController.getRooms());
        tabelaSalas.setModel(Modelo);

        tabelaSalas.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabelaSalas.getColumnModel().getColumn(1).setPreferredWidth(100);
    }

    public void Botoes(boolean N, boolean S, boolean C) {
        botaoNovoSala.setEnabled(N);
        botaoSalvarSala.setEnabled(S);
        botaoCancelarSala.setEnabled(C);
    }

    public void ManipulaCampo(String modo) {
        switch (modo) {
            case "Limpa":
                campoNomeSala.setText("");
                campoLotacaoSala.setText("");
                break;
            case "Bloqueia":
                campoNomeSala.setEnabled(false);
                campoLotacaoSala.setEnabled(false);
                break;
            case "Desbloqueia":
                campoNomeSala.setEnabled(true);
                campoLotacaoSala.setEnabled(true);
                break;
            default:
                System.out.println("Modo inválido");
        }
    }

    /**
     * Creates new form EventRoomScreen
     */
    public EventRoomScreen() {
        initComponents();
        LoadTableRoom();
        ManipulaCampo("Bloqueia");
        Botoes(true, false, false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneSalas = new javax.swing.JScrollPane();
        tabelaSalas = new javax.swing.JTable();
        panelCampos = new javax.swing.JPanel();
        labelNomeSala = new javax.swing.JLabel();
        labelLotacaoSala = new javax.swing.JLabel();
        campoNomeSala = new javax.swing.JTextField();
        campoLotacaoSala = new javax.swing.JTextField();
        panelBotoes = new javax.swing.JPanel();
        botaoNovoSala = new javax.swing.JButton();
        botaoSalvarSala = new javax.swing.JButton();
        botaoCancelarSala = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Salas do Evento");
        setPreferredSize(new java.awt.Dimension(468, 447));

        tabelaSalas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Nome", "Lotação"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabelaSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaSalasMouseClicked(evt);
            }
        });
        scrollPaneSalas.setViewportView(tabelaSalas);

        panelCampos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelNomeSala.setText("Nome:");

        labelLotacaoSala.setText("Lotação:");

        javax.swing.GroupLayout panelCamposLayout = new javax.swing.GroupLayout(panelCampos);
        panelCampos.setLayout(panelCamposLayout);
        panelCamposLayout.setHorizontalGroup(
                panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCamposLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelNomeSala)
                                        .addComponent(labelLotacaoSala))
                                .addGap(18, 18, 18)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoLotacaoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCamposLayout.setVerticalGroup(
                panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelNomeSala)
                                        .addComponent(campoNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(campoLotacaoSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelLotacaoSala))
                                .addGap(23, 23, 23))
        );

        panelBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        botaoNovoSala.setText("Novo");
        botaoNovoSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoSalaActionPerformed(evt);
            }
        });

        botaoSalvarSala.setText("Salvar");
        botaoSalvarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarSalaActionPerformed(evt);
            }
        });

        botaoCancelarSala.setText("Cancelar");
        botaoCancelarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarSalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
                panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBotoesLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoNovoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(botaoSalvarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(botaoCancelarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
        );
        panelBotoesLayout.setVerticalGroup(
                panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesLayout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botaoNovoSala)
                                        .addComponent(botaoSalvarSala)
                                        .addComponent(botaoCancelarSala))
                                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPaneSalas)
                        .addComponent(panelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollPaneSalas, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSalasMouseClicked
        Botoes(true, false, false);

        int index = tabelaSalas.getSelectedRow();
        if (index >= 0 && index < Modelo.getRowCount()) {
            String temp[] = Modelo.getEventRoom(index);
            campoNomeSala.setText(temp[0]);
            campoLotacaoSala.setText(temp[1]);
        }
    }//GEN-LAST:event_tabelaSalasMouseClicked

    private void botaoNovoSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoSalaActionPerformed
        Botoes(false, true, true);
        ManipulaCampo("Limpa");
        ManipulaCampo("Desbloqueia");
    }//GEN-LAST:event_botaoNovoSalaActionPerformed

    private void botaoSalvarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarSalaActionPerformed

        /**
         * Converte uma String para um inteiro
         *
         */
        if ((campoNomeSala.getText() == null || campoNomeSala.getText().trim().isEmpty()) || (campoLotacaoSala.getText() == null || campoLotacaoSala.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Você precisa preencher todos os campos!");
            Botoes(false, true, true);
        } else {
            if (EventRoomController.SaveRoom(campoNomeSala.getText(), Integer.parseInt(campoLotacaoSala.getText()))) {
                this.LoadTableRoom();
                JOptionPane.showMessageDialog(this, "Sala salva com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar a sala!");
            }
            Botoes(true, false, false);
            ManipulaCampo("Limpa");
            ManipulaCampo("Bloqueia");
        }
    }//GEN-LAST:event_botaoSalvarSalaActionPerformed

    private void botaoCancelarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarSalaActionPerformed
        Botoes(true, false, false);
        ManipulaCampo("Limpa");
        ManipulaCampo("Bloqueia");
    }//GEN-LAST:event_botaoCancelarSalaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelarSala;
    private javax.swing.JButton botaoNovoSala;
    private javax.swing.JButton botaoSalvarSala;
    private javax.swing.JTextField campoLotacaoSala;
    private javax.swing.JTextField campoNomeSala;
    private javax.swing.JLabel labelLotacaoSala;
    private javax.swing.JLabel labelNomeSala;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JScrollPane scrollPaneSalas;
    private javax.swing.JTable tabelaSalas;
    // End of variables declaration//GEN-END:variables
}
