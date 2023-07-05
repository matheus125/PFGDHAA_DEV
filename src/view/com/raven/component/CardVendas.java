package view.com.raven.component;

import com.raven.banco.ConexaoBD;
import com.raven.controller.ControllerSenha;
import com.raven.dao.SenhaDao;
import com.raven.dao.TitularDao;
import com.raven.model.Senha;
import com.raven.model.Titular;
import com.raven.tabelas.TabelaUniversal;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import view.com.raven.swing.ScrollBar;

public final class CardVendas extends javax.swing.JPanel {

    int id_clientes, contador = 400;
    String data2, genero, idade;

    ConexaoBD con = new ConexaoBD();

    ControllerSenha controllerSenha = new ControllerSenha();

    Senha senha = new Senha();
    Titular titular = new Titular();

    SenhaDao senhaDao = new SenhaDao();
    TitularDao titularDao = new TitularDao();

    public CardVendas() {
        initComponents();
        txtData_refeicao.setVisible(false);
        setOpaque(false);
//        tabela_cliente_titular("SELECT * FROM tb_clientes order by nome_cliente");

        // A  linha Abaixo exibe a Data Atual do Sistema.
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        txtData_refeicao.setText(df.format(data));
        data2 = txtData_refeicao.getText();
    }

    //TABELA CARREGANDO DADOS DOS CLIENTES
//    public final void tabela_cliente_titular(String Sql) {
//        spTableCliente_Titular.setVerticalScrollBar(new ScrollBar());
//        spTableCliente_Titular.getVerticalScrollBar().setBackground(Color.WHITE);
//        spTableCliente_Titular.getViewport().setBackground(Color.WHITE);
//
//        JPanel p = new JPanel();
//        p.setBackground(Color.WHITE);
//        spTableCliente_Titular.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
//
//        ArrayList dados = new ArrayList();
//        String[] colunas = new String[]{"ID", "NOME", "CPF", "RG", "IDADE", "GÊNERO"};
//        con.getConectar();
//        con.executarSql(Sql);
//        //Inserir dados na tabela
//        try {
//            con.getResultSet().first();
//            do {
//                dados.add(new Object[]{con.getResultSet().getInt("id_clientes"),
//                    con.getResultSet().getString("nome_cliente"),
//                    con.getResultSet().getString("cpf_cliente"),
//                    con.getResultSet().getString("rg_cliente"),
//                    con.getResultSet().getInt("idade_cliente"),
//                    con.getResultSet().getString("genero")
//                });
//            } while (con.getResultSet().next());
//        } catch (SQLException e) {
//
//        }
//
//        TabelaUniversal tabela = new TabelaUniversal(dados, colunas);
//
//        table_cliente_Titular.setModel(tabela);
//        table_cliente_Titular.getColumnModel().getColumn(0).setPreferredWidth(50);
//        table_cliente_Titular.getColumnModel().getColumn(0).setResizable(false);
//        table_cliente_Titular.getColumnModel().getColumn(1).setPreferredWidth(187);
//        table_cliente_Titular.getColumnModel().getColumn(1).setResizable(false);
//        table_cliente_Titular.getColumnModel().getColumn(2).setPreferredWidth(100);
//        table_cliente_Titular.getColumnModel().getColumn(2).setResizable(false);
//        table_cliente_Titular.getColumnModel().getColumn(3).setPreferredWidth(100);
//        table_cliente_Titular.getColumnModel().getColumn(3).setResizable(false);
//        table_cliente_Titular.getColumnModel().getColumn(4).setPreferredWidth(45);
//        table_cliente_Titular.getColumnModel().getColumn(4).setResizable(false);
//        table_cliente_Titular.getColumnModel().getColumn(5).setPreferredWidth(90);
//        table_cliente_Titular.getColumnModel().getColumn(5).setResizable(false);
//        table_cliente_Titular.getTableHeader().setReorderingAllowed(false);
//        table_cliente_Titular.setAutoResizeMode(table_cliente_Titular.AUTO_RESIZE_OFF);
//        table_cliente_Titular.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//    }

    //METODO PARA SALVAR SENHAS TITULADAS
    public void salvarSenhas() {
        String nome;

        nome = txtCliente.getText();

        if (!nome.isEmpty()) {
            senha.setCliente(nome);
            senha.setGenero(genero);
            senha.setIdade(idade);
            senha.setData_refeicao(data2);

            boolean resultado = controllerSenha.controlSaveSenhas(senha);
            if (resultado == true) {
                senhaDao.escreverNoTXT(senhaDao.recuperarSenha());
                ultimaSenha.setText("Última senha: " + controllerSenha.controlRetornarUltimaSenha());
                txtPesquisarNomeClientes.setText("");
                txtCliente.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao Salvar!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um nome!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            return;
        }//FIM IF "rua"

    }//FIM.

    //METODO PARA SALVAR SENHAS GENERICAS
    public void salvarSenhaGenerica() {
        senha.setData_refeicao(data2);

        boolean resultado = controllerSenha.controlSaveSenhasGenericas(senha);
        if (resultado == true) {
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
            senhaDao.escreverNoTXT(senhaDao.recuperarSenha());
            ultimaSenha.setText("Última senha: " + senhaDao.retornarUltimaSenha());
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao Salvar!");
        }
    }//FIM.

    //METODO PARA BUSCAR CLIENTES NA BARRA DE PESQUISA
    public void Buscar() {
        titular.setPesquisar(txtPesquisarNomeClientes.getText());
        titular = titularDao.buscarClientes(titular);
        id_clientes = Integer.parseInt((String.valueOf(titular.getId())));
//        tabela_cliente_titular("SELECT * FROM tb_clientes where nome_cliente like '%" + titular.getPesquisar() + "%'");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtPesquisarNomeClientes = new javax.swing.JTextField();
        btnTitulada = new javax.swing.JButton();
        btnGenerico = new javax.swing.JButton();
        ultimaSenha = new javax.swing.JLabel();
        txtData_refeicao = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        spTableCliente_Titular = new javax.swing.JScrollPane();
        table_cliente_Titular = new view.com.raven.swing.Table();
        txtCliente = new javax.swing.JTextField();
        btnBuscarClienteTitular = new button.Button();

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome Completo:");

        txtPesquisarNomeClientes.setDisabledTextColor(new java.awt.Color(187, 187, 187));
        txtPesquisarNomeClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarNomeClientesActionPerformed(evt);
            }
        });

        btnTitulada.setText("Gerar Senha");
        btnTitulada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTituladaActionPerformed(evt);
            }
        });

        btnGenerico.setText("Senha Genérica");
        btnGenerico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenericoActionPerformed(evt);
            }
        });

        ultimaSenha.setForeground(new java.awt.Color(255, 255, 255));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/atualizar.png"))); // NOI18N
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        table_cliente_Titular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_cliente_Titular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cliente_TitularMouseClicked(evt);
            }
        });
        spTableCliente_Titular.setViewportView(table_cliente_Titular);

        txtCliente.setEditable(false);
        txtCliente.setDisabledTextColor(new java.awt.Color(187, 187, 187));
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        btnBuscarClienteTitular.setText("Pesquisar");
        btnBuscarClienteTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteTitularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ultimaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(228, 228, 228)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(spTableCliente_Titular, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnTitulada)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnGenerico))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtPesquisarNomeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnBuscarClienteTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAtualizar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtData_refeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(487, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtData_refeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPesquisarNomeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTitulada)
                                .addComponent(btnGenerico)))
                        .addGap(8, 8, 8)
                        .addComponent(spTableCliente_Titular, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ultimaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscarClienteTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizar)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table_cliente_TitularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cliente_TitularMouseClicked
//        String nome = "" + table_cliente_Titular.getValueAt(table_cliente_Titular.getSelectedRow(), 1);
//        con.getConectar();
//        con.executarSql("SELECT * FROM tb_clientes where nome_cliente ='" + nome + "'");
//        try {
//            con.getResultSet().first();
//            txtCliente.setText(con.getResultSet().getString("nome_cliente"));
//            genero = con.getResultSet().getString("Genero");
//            idade = con.getResultSet().getString("idade_cliente");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro no ao selecionar os dados" + ex);
//        }
//        if (controllerSenha.controlVerificarSenhaCliente(table_cliente_Titular.getValueAt(table_cliente_Titular.getSelectedRow(), 1).toString())) {
//            JOptionPane.showMessageDialog(null, "Este cliente já comprou senha neste dia!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
//            txtCliente.setText("");
//            txtPesquisarNomeClientes.setText("");
//        }
    }//GEN-LAST:event_table_cliente_TitularMouseClicked

    private void table_cliente_FamiliaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cliente_FamiliaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_cliente_FamiliaMouseClicked

    private void btnTituladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTituladaActionPerformed

        int resultado = JOptionPane.showConfirmDialog(null, "Deseja gerar senha para: " + txtCliente.getText() + "?");

        if (resultado == 0) {

            if (controllerSenha.controlRetornarUltimaSenha() < contador) {

                for (int i = 0; i < 1; i++) {

                    if (controllerSenha.controlRetornarUltimaSenha() < contador) {
                        salvarSenhas();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senhas encerradas!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cancelado!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            txtCliente.setText("");
        }
    }//GEN-LAST:event_btnTituladaActionPerformed

    private void btnGenericoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenericoActionPerformed

        int resultado = JOptionPane.showConfirmDialog(null, "Deseja gerar senha genérica?");

        if (resultado == 0) {

            if (controllerSenha.controlRetornarUltimaSenha() < contador) {

                for (int i = 0; i < 1; i++) {

                    if (senhaDao.retornarUltimaSenha() < contador) {
                        salvarSenhaGenerica();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senhas encerradas!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cancelado!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            txtCliente.setText("");
        }
    }//GEN-LAST:event_btnGenericoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
//        tabela_cliente_titular("SELECT * FROM tb_clientes order by nome_cliente");
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtPesquisarNomeClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarNomeClientesActionPerformed
        btnBuscarClienteTitularActionPerformed(evt);
    }//GEN-LAST:event_txtPesquisarNomeClientesActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void btnBuscarClienteTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteTitularActionPerformed
        Buscar();
    }//GEN-LAST:event_btnBuscarClienteTitularActionPerformed

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private button.Button btnBuscarClienteTitular;
    private javax.swing.JButton btnGenerico;
    private javax.swing.JButton btnTitulada;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane spTableCliente_Titular;
    private view.com.raven.swing.Table table_cliente_Titular;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JLabel txtData_refeicao;
    private javax.swing.JTextField txtPesquisarNomeClientes;
    private javax.swing.JLabel ultimaSenha;
    // End of variables declaration//GEN-END:variables
}
