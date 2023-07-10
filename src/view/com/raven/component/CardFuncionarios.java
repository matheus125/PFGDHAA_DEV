package view.com.raven.component;

import view.com.raven.model.CPF;
import raven.glasspanepopup.GlassPanePopup;
import com.raven.banco.ConexaoBD;
import com.raven.controller.ControllerUsuarios;
import com.raven.dao.UsuariosDao;
import com.raven.model.Funcionarios;
import com.raven.model.Usuarios;
import com.raven.tabelas.TabelaUniversal;
import view.com.raven.model.Model_Card;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import view.com.raven.swing.ScrollBar;
import view.com.raven.swing.Table;

public final class CardFuncionarios extends javax.swing.JPanel {

    int flag = 0;
    String id;

    ControllerUsuarios controllerUsuarios = new ControllerUsuarios();
    Usuarios usuarios = new Usuarios();
    UsuariosDao usuariosDao = new UsuariosDao();

    ConexaoBD con = new ConexaoBD();

    public CardFuncionarios() {
        initComponents();

        desabilitarCampos();
        desabilitarBotao();
        loadFuncionariosTable("SELECT a.nome_admin, a.cpf_admin, a.email_admin, a.senha_admin, a.telefone_admin, a.cargo_admin FROM admins a order by nome_admin");
//92 994261554
//eduarda puts

//92 988560357
//Keyla puts
//92 993251520
//Prima
//92 993480332
//Casa rosa
    }

    public void limparCampos() {
        txtnome.setText("");
        txtlogin.setText("");
        txtFone.setText("");
        txtsenha.setText("");
        txtemail.setText("");
    }

    public final void desabilitarCampos() {
        txtnome.setEnabled(false);
        txtemail.setEnabled(false);
        txtlogin.setEnabled(false);
        txtFone.setEnabled(false);
        txtsenha.setEnabled(false);
        comboPerfil.setEnabled(false);

    }

    public void habilitarCampos() {
        txtnome.setEnabled(true);
        txtlogin.setEnabled(true);
        txtemail.setEnabled(true);
        txtsenha.setEnabled(true);
        txtFone.setEnabled(true);
        comboPerfil.setEnabled(true);
    }

    public final void desabilitarBotao() {
        btnNovo.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnRemover.setEnabled(false);
        btnCancelar.setEnabled(false);
    }

    public void habilitarBotao() {
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnRemover.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    public void saveFuncionarios() {

        //DECLARAÇÃO DE VARIÁVEIS PARA VALIDAÇÃO DE CAMPOS
        String Nome, Fone, Login, Password, Email;

        Nome = txtnome.getText();
        Fone = txtFone.getText();
        Login = txtlogin.getText();
        Password = txtsenha.getText();
        Email = txtemail.getText();

        CPF pf = new CPF(Login);
        //FIM DAS VARIÁVEIS.
        if (controllerUsuarios.controlGetFuncionario(txtlogin.getText()) == false) {//PRIMEIRO IF DE VERIFICAÇÃO DE CPF CADASTRADO
            if (!Nome.isEmpty()) {//PRIMEIRO IF "!Nome"
                if (txtlogin.getText().equals("   .   .   -  ")) {
                    JOptionPane.showMessageDialog(this, "Campo CPF é Obrigatório!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                    txtlogin.requestFocus();
                    return;
                }
                if (!Fone.isEmpty()) {//SEGUNDO IF "!Fone"
                    if (!Login.isEmpty()) {//TERCEIRO IF "!Login"
                        if (!Password.isEmpty()) {//QUARTO IF "!Password"
                            if (!Email.isEmpty()) {

                                if (pf.isCPF()) {
                                    usuarios.setNome_admin(Nome);
                                    usuarios.setCargo_admin((String) this.comboPerfil.getSelectedItem());
                                    usuarios.setCpf_admin(Login);
                                    usuarios.setEmail_admin(Email);
                                    usuarios.setSenha_admin(Password);
                                    usuarios.setTelefone_admin(Fone);
                                    controllerUsuarios.controllerSaveClientes(usuarios);
                                    loadFuncionariosTable("SELECT a.nome_admin, a.cpf_admin, a.email_admin, a.senha_admin, a.telefone_admin, a.cargo_admin FROM admins a order by nome_admin");

                                    limparCampos();
                                    desabilitarCampos();
                                    desabilitarBotao();
                                } else {
                                    JOptionPane.showMessageDialog(null, "CPF inválido!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Preencha o campo Email!");
                                txtemail.requestFocus();
                            }//FIM DO IF "Email".
                        } else {
                            JOptionPane.showMessageDialog(this, "Preencha o campo Password!");
                            txtsenha.requestFocus();
                        }//FIM DO QUARTO IF "!Password".
                    } else {
                        JOptionPane.showMessageDialog(this, "Preencha o campo Login!");
                        txtlogin.requestFocus();
                    }//FIM DO TERCEIRO IF "!Login".
                } else {
                    JOptionPane.showMessageDialog(this, "Preencha o campo Telefone!");
                    txtFone.requestFocus();
                }//FIM DO SEGUNDO IF "!Fone".
            } else {
                JOptionPane.showMessageDialog(this, "Preencha o campo Nome!");
                txtnome.requestFocus();
            } //FIM DO PRIMEIRO IF "!Nome".
        } else {
            JOptionPane.showMessageDialog(null, "CPF já está sendo usado em outra conta!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            txtlogin.requestFocus();
        }//FIM IF "VERIFICAÇÃO DE CPF"
    }

    public void updateFuncionarios() {
        //DECLARAÇÃO DE VARIÁVEIS PARA VALIDAÇÃO DE CAMPOS
        String Nome, Fone, Login, Password, Email;

        Nome = txtnome.getText();
        Fone = txtFone.getText();
        Login = txtlogin.getText();
        Password = txtsenha.getText();
        Email = txtemail.getText();
        //FIM DAS VARIÁVEIS.

        if (!Nome.isEmpty()) {//PRIMEIRO IF "!Nome"
            if (!Fone.isEmpty()) {//SEGUNDO IF "!Fone"
                if (!Login.isEmpty()) {//TERCEIRO IF "!Login"
                    if (!Password.isEmpty()) {//QUARTO IF "!Password"
                        if (!Email.isEmpty()) {
                            usuarios.setCpf_admin(id);
                            usuarios.setNome_admin(Nome);
                            usuarios.setCargo_admin((String) this.comboPerfil.getSelectedItem());
                            usuarios.setSenha_admin(Password);
                            usuarios.setTelefone_admin(Fone);
                            usuarios.setEmail_admin(Fone);
                            controllerUsuarios.controllerUpdateClientes(usuarios);
                            loadFuncionariosTable("SELECT a.nome_admin, a.cpf_admin, a.email_admin, a.senha_admin, a.telefone_admin, a.cargo_admin FROM admins a order by nome_admin");
                            limparCampos();
                            desabilitarCampos();
                            desabilitarBotao();
                        } else {
                            JOptionPane.showMessageDialog(this, "Preencha o campo Email!");
                            txtemail.requestFocus();
                        }//FIM DO IF "Email".
                    } else {
                        JOptionPane.showMessageDialog(this, "Preencha o campo Password!");
                        txtsenha.requestFocus();
                    }//FIM DO QUARTO IF "!Password".
                } else {
                    JOptionPane.showMessageDialog(this, "Preencha o campo Login!");
                    txtlogin.requestFocus();
                }//FIM DO TERCEIRO IF "!Login".
            } else {
                JOptionPane.showMessageDialog(this, "Preencha o campo Telefone!");
                txtFone.requestFocus();
            }//FIM DO SEGUNDO IF "!Fone".
        } else {
            JOptionPane.showMessageDialog(this, "Preencha o campo Nome!");
            txtnome.requestFocus();
        } //FIM DO PRIMEIRO IF "!Nome".
    }

    public void excluirFuncionarios() {
        desabilitarCampos();
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir?");
        if (resposta == JOptionPane.YES_OPTION) {
            usuarios.setCpf_admin(id);
            usuariosDao.daoDeleteUsuario(usuarios);

            loadFuncionariosTable("SELECT a.nome_admin, a.cpf_admin, a.email_admin, a.senha_admin, a.telefone_admin, a.cargo_admin FROM admins a order by nome_admin");
            limparCampos();
            desabilitarCampos();
            desabilitarBotao();
            btnNovo.setEnabled(true);

        }
    }

    public void pesquisarFuncionarios() {
        usuarios.setPesquisar(txtpesquisarfuncionarios.getText());
        usuarios = usuariosDao.buscarFuncionarios(usuarios);
        id = ((String.valueOf(usuarios.getCpf_admin())));
        txtnome.setText((String.valueOf(usuarios.getNome_admin())));
        txtlogin.setText((String.valueOf(usuarios.getCpf_admin())));
        comboPerfil.setSelectedItem(usuarios.getCargo_admin());
        txtFone.setText((String.valueOf(usuarios.getTelefone_admin())));
        txtlogin.setText((String.valueOf(usuarios.getEmail_admin())));
        txtsenha.setText((String.valueOf(usuarios.getSenha_admin())));
        txtemail.setText((String.valueOf(usuarios.getEmail_admin())));
        loadFuncionariosTable("select a.nome_admin, a.cpf_admin, a.email_admin, a.senha_admin, a.telefone_admin, a.cargo_admin from admins a where nome_admin like '%" + usuarios.getPesquisar() + "%'");
    }

    public void loadFuncionariosTable(String Sql) {
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Nome", "CPF", "Email", "Telefone", "Perfil"};

        con.getConectar();
        con.executarSql(Sql);

        try {
            con.getResultSet().first();
            do {
                dados.add(new Object[]{con.getResultSet().getString("nome_admin"), con.getResultSet().getString("cpf_admin"),
                    con.getResultSet().getString("email_admin"), con.getResultSet().getString("telefone_admin"), con.getResultSet().getString("cargo_admin")});
            } while (con.getResultSet().next());
        } catch (SQLException e) {

        }

        TabelaUniversal tabela = new TabelaUniversal(dados, colunas);

        Tabela_funcionarios_user.setModel(tabela);
        Tabela_funcionarios_user.getColumnModel().getColumn(0).setPreferredWidth(190);
        Tabela_funcionarios_user.getColumnModel().getColumn(0).setResizable(false);
        Tabela_funcionarios_user.getColumnModel().getColumn(1).setPreferredWidth(140);
        Tabela_funcionarios_user.getColumnModel().getColumn(1).setResizable(false);
        Tabela_funcionarios_user.getColumnModel().getColumn(2).setPreferredWidth(150);
        Tabela_funcionarios_user.getColumnModel().getColumn(2).setResizable(false);
        Tabela_funcionarios_user.getColumnModel().getColumn(3).setPreferredWidth(115);
        Tabela_funcionarios_user.getColumnModel().getColumn(3).setResizable(false);
        Tabela_funcionarios_user.getColumnModel().getColumn(4).setPreferredWidth(140);
        Tabela_funcionarios_user.getColumnModel().getColumn(4).setResizable(false);
        Tabela_funcionarios_user.getTableHeader().setReorderingAllowed(false);
        Tabela_funcionarios_user.setAutoResizeMode(Table.AUTO_RESIZE_OFF);
        Tabela_funcionarios_user.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void setData(Model_Card data) {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_name = new javax.swing.JLabel();
        lb_login = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        lb_function = new javax.swing.JLabel();
        lb_password = new javax.swing.JLabel();
        txtsenha = new javax.swing.JPasswordField();
        comboPerfil = new javax.swing.JComboBox<>();
        txtpesquisarfuncionarios = new javax.swing.JTextField();
        lb_name1 = new javax.swing.JLabel();
        txtFone = new javax.swing.JFormattedTextField();
        txtlogin = new javax.swing.JFormattedTextField();
        spTable = new javax.swing.JScrollPane();
        Tabela_funcionarios_user = new view.com.raven.swing.Table();
        btnRemover = new button.Button();
        btnNovo = new button.Button();
        btnSalvar = new button.Button();
        btnCancelar = new button.Button();
        btnAlterar = new button.Button();
        btnBuscar = new button.Button();
        lb_name2 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1085, 622));

        lb_name.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_name.setForeground(new java.awt.Color(255, 255, 255));
        lb_name.setText("Nome:");

        lb_login.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_login.setForeground(new java.awt.Color(255, 255, 255));
        lb_login.setText("Login:");

        txtnome.setEnabled(false);

        lb_function.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_function.setForeground(new java.awt.Color(255, 255, 255));
        lb_function.setText("Perfil:");

        lb_password.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_password.setForeground(new java.awt.Color(255, 255, 255));
        lb_password.setText("Password:");

        txtsenha.setEnabled(false);

        comboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Atendente" }));

        txtpesquisarfuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesquisarfuncionariosActionPerformed(evt);
            }
        });

        lb_name1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_name1.setForeground(new java.awt.Color(255, 255, 255));
        lb_name1.setText("Telefone:");

        try {
            txtFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFone.setEnabled(false);

        try {
            txtlogin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtlogin.setEnabled(false);

        spTable.setBorder(null);

        Tabela_funcionarios_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabela_funcionarios_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabela_funcionarios_userMouseClicked(evt);
            }
        });
        spTable.setViewportView(Tabela_funcionarios_user);

        btnRemover.setBackground(new java.awt.Color(253, 83, 83));
        btnRemover.setForeground(new java.awt.Color(245, 245, 245));
        btnRemover.setText("Excluir");
        btnRemover.setRippleColor(new java.awt.Color(255, 255, 255));
        btnRemover.setShadowColor(new java.awt.Color(253, 83, 83));
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(29, 162, 253));
        btnNovo.setForeground(new java.awt.Color(245, 245, 245));
        btnNovo.setText("Novo");
        btnNovo.setRippleColor(new java.awt.Color(255, 255, 255));
        btnNovo.setShadowColor(new java.awt.Color(29, 162, 253));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(30, 180, 114));
        btnSalvar.setForeground(new java.awt.Color(245, 245, 245));
        btnSalvar.setText("Salvar");
        btnSalvar.setRippleColor(new java.awt.Color(255, 255, 255));
        btnSalvar.setShadowColor(new java.awt.Color(30, 180, 114));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(103, 103, 103));
        btnCancelar.setForeground(new java.awt.Color(245, 245, 245));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(246, 159, 50));
        btnAlterar.setForeground(new java.awt.Color(245, 245, 245));
        btnAlterar.setText("Alterar");
        btnAlterar.setRippleColor(new java.awt.Color(255, 255, 255));
        btnAlterar.setShadowColor(new java.awt.Color(246, 159, 50));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Pesquisar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lb_name2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_name2.setForeground(new java.awt.Color(255, 255, 255));
        lb_name2.setText("Email:");

        txtemail.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_name1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_login, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtnome)
                                            .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lb_function, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_password, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lb_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtemail)
                                            .addComponent(txtsenha, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtpesquisarfuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtnome)
                        .addComponent(lb_name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb_function, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_password, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtemail)
                        .addComponent(lb_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpesquisarfuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Tabela_funcionarios_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabela_funcionarios_userMouseClicked
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(true);
        btnRemover.setEnabled(true);
        btnCancelar.setEnabled(true);
        String nome = "" + Tabela_funcionarios_user.getValueAt(Tabela_funcionarios_user.getSelectedRow(), 0);
        con.getConectar();
        con.executarSql("SELECT * FROM admins where nome_admin ='" + nome + "'");
        try {
            con.getResultSet().first();
            id = con.getResultSet().getString("cpf_admin");
            txtnome.setText(con.getResultSet().getString("nome_admin"));
            txtemail.setText(con.getResultSet().getString("email_admin"));
            comboPerfil.setSelectedItem(con.getResultSet().getString("cargo_admin"));
            txtFone.setText(con.getResultSet().getString("telefone_admin"));
            txtlogin.setText(con.getResultSet().getString("cpf_admin"));
            txtsenha.setText(con.getResultSet().getString("senha_admin"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no ao selecionar os dados" + ex);
        }
    }//GEN-LAST:event_Tabela_funcionarios_userMouseClicked

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        excluirFuncionarios();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        flag = 1;
        habilitarCampos();
        habilitarBotao();
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnRemover.setEnabled(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (flag == 1) {
            saveFuncionarios();
        } else {
            updateFuncionarios();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        desabilitarBotao();
        desabilitarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        flag = 2;
        habilitarCampos();
        habilitarBotao();
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnRemover.setEnabled(false);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        pesquisarFuncionarios();
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtpesquisarfuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesquisarfuncionariosActionPerformed
        btnBuscarActionPerformed(evt);
    }//GEN-LAST:event_txtpesquisarfuncionariosActionPerformed

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
    private view.com.raven.swing.Table Tabela_funcionarios_user;
    private button.Button btnAlterar;
    private button.Button btnBuscar;
    private button.Button btnCancelar;
    private button.Button btnNovo;
    private button.Button btnRemover;
    private button.Button btnSalvar;
    private javax.swing.JComboBox<String> comboPerfil;
    private javax.swing.JLabel lb_function;
    private javax.swing.JLabel lb_login;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_name1;
    private javax.swing.JLabel lb_name2;
    private javax.swing.JLabel lb_password;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtemail;
    private javax.swing.JFormattedTextField txtlogin;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtpesquisarfuncionarios;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables

}
