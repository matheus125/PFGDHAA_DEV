/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.com.instalacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.swing.JOptionPane;
import view.com.login.TelaLogin;

/**
 *
 * @author USER
 */
public class CONFIGURACAO extends javax.swing.JFrame {

    final private String driver = "com.mysql.cj.jdbc.Driver";
    Connection CONEXAO;
    private boolean VERIFICACAO = false;

    public CONFIGURACAO() {
        initComponents();
        if (VERIFICACAO == false) {
            LE_CONFIGURACAO_GRAVADA();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        T_Host = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        T_Porta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        T_User = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        T_Senha = new javax.swing.JTextField();
        btnTestar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("host");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 60, 90, 40);

        T_Host.setText("localhost");
        jPanel1.add(T_Host);
        T_Host.setBounds(30, 100, 180, 30);

        jLabel2.setText("host");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 60, 90, 40);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(30, 100, 180, 30);

        jLabel3.setText("porta");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(240, 60, 90, 40);

        T_Porta.setText("3306");
        T_Porta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_PortaActionPerformed(evt);
            }
        });
        jPanel1.add(T_Porta);
        T_Porta.setBounds(240, 100, 180, 30);

        jLabel4.setText("User");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 140, 90, 40);

        T_User.setText("root");
        jPanel1.add(T_User);
        T_User.setBounds(30, 180, 180, 30);

        jLabel5.setText("Password");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 220, 90, 40);
        jPanel1.add(T_Senha);
        T_Senha.setBounds(30, 260, 180, 30);

        btnTestar.setText("testar");
        btnTestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestarActionPerformed(evt);
            }
        });
        jPanel1.add(btnTestar);
        btnTestar.setBounds(250, 170, 110, 22);

        btnSalvar.setText("salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar);
        btnSalvar.setBounds(250, 210, 110, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(650, 407));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void T_PortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_PortaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T_PortaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (CONEXAO_SERVIDOR(T_Host.getText(), T_Porta.getText(), T_User.getText(), T_Senha.getText())) {
            if (GRAVA_CONFIGURAÇÃO()) {//SE CONSEGUIR GRAVAR A CONFIGURAÇÃO PASSA PARA O PROXIMO PASSO
                if (LE_CONFIGURACAO_GRAVADA()) {//SE CONSEGUIR LER A GRAVAÇÃO REALIZADA PASSA PARA O PROXIMO PASSO
                    if (CRIA_DATA_BASE_COMPLETO()) {//SE NÃO OCORRER ERRO NAS QUERES SQL PASSA PARA O PROXIMO PASSO
                        FECHAR_CONEXAO();//PASSOU TODOS OS PASSOS AGORA IRÁ FECHAR A TELA E ABRIR OUTRA
                        new TelaLogin().setVisible(true);//CHAMA A TELA PRINCIPAL, OU SE QUISER POSSO CHAMAR A TELA DE LOGIN. FICA A CRITERIO DO PROGRAMADOR
                        dispose();
                    } else {
                        btnSalvar.setEnabled(false);
                    }
                } else {
                    btnSalvar.setEnabled(false);
                }
            } else {
                btnSalvar.setEnabled(false);
            }
        } else {
            btnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnTestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestarActionPerformed
        if (CONEXAO_SERVIDOR(T_Host.getText(), T_Porta.getText(), T_User.getText(), T_Senha.getText())) {
            JOptionPane.showMessageDialog(null, "Teste bem sucedido");
            btnSalvar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Falha na conexão", "Fala", 0);
        }
    }//GEN-LAST:event_btnTestarActionPerformed

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
            java.util.logging.Logger.getLogger(CONFIGURACAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CONFIGURACAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CONFIGURACAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CONFIGURACAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //CHAMADA A TELA PRINCIPAL OU DE LOGIN
        CONFIGURACAO TELA = new CONFIGURACAO();

        if (TELA.LE_CONFIGURACAO_GRAVADA()) {
            if (TELA.CRIA_DATA_BASE_COMPLETO()) {
                TELA.VERIFICACAO = true;
                TELA.FECHAR_CONEXAO();
                new TelaLogin().setVisible(true);
            }
        }
        if (TELA.VERIFICACAO == false) {

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new CONFIGURACAO().setVisible(true);
                }
            });
        }
        //FIM.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField T_Host;
    private javax.swing.JTextField T_Porta;
    private javax.swing.JTextField T_Senha;
    private javax.swing.JTextField T_User;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnTestar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    //METODO PARA LE A CONFIGURAÇÃO GRAVADA
    private boolean LE_CONFIGURACAO_GRAVADA() {
        boolean leitura = false;

        try {
            String linha;
            String ArquivoConfiguracao = "C:/ConexaoBanco/Configuracao/conexao.ini";
            int cont = 0;
            File arq = new File(ArquivoConfiguracao);
            if (arq.exists()) {

                FileReader reader = new FileReader(ArquivoConfiguracao);
                BufferedReader leitor = new BufferedReader(reader);

                while (true) {
                    linha = leitor.readLine();
                    if (cont == 0) {
                        T_Host.setText(linha);
                    }
                    if (cont == 1) {
                        T_Porta.setText(linha);
                    }
                    if (cont == 2) {
                        T_User.setText(linha);
                    }
                    if (cont >= 3) {
                        T_Senha.setText(linha);
                        break;
                    }
                    System.out.println(linha + "\n");
                    cont++;
                }
            }
            if (arq.exists()) {
                if (CONEXAO_SERVIDOR(T_Host.getText(), T_Porta.getText(), T_User.getText(), T_Senha.getText())) {
                    leitura = true;
                }
            }
        } catch (Exception erro) {
        }
        return leitura;
    }
    //FIM.

    //METODO PARA CRIAR O DIRETORIO DE CONFIGURAÇÃO
    private boolean GRAVA_CONFIGURAÇÃO() {
        boolean grava = false;

        try {
            File diretorio = new File("C:/ConexaoBanco/Configuracao");
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            FileWriter arql = new FileWriter("C:/ConexaoBanco/Configuracao/conexao.ini");
            PrintWriter gravarArq = new PrintWriter(arql);
            gravarArq.println(T_Host.getText());
            gravarArq.println(T_Porta.getText());
            gravarArq.println(T_User.getText());
            gravarArq.println(T_Senha.getText());
            arql.close();
            grava = true;
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, "Você não tem permissão de administrador para configurar o "
                    + "sistema.", "ERRO!", 0);
        }

        return grava;
    }
    //FIM.

    //METODO DE CONEXÃO COM O SERVIDOR
    private boolean CONEXAO_SERVIDOR(String Servidor, String Porta, String usuario, String Senha) {
        boolean com = false;
        String SERVIDOR = Servidor;
        String PORTA_CONEXAO = Porta;
        String USUARIO = usuario;
        String SENHA = Senha;

        try {
            Class.forName(driver);
            CONEXAO = DriverManager.getConnection("jdbc:mysql://" + SERVIDOR + ":"
                    + PORTA_CONEXAO + "", USUARIO, SENHA);
            com = true;
        } catch (ClassNotFoundException Fonte) {
            JOptionPane.showMessageDialog(null, "Driver não localizado");
        } catch (SQLException Fonte) {
        }

        return com;
    }
    //FIM.

    //METODO DE CONEXÃO COM O BANCO DE DADOS
    private boolean CONEXAO_DATABASE(String Servidor, String Porta, String usuario, String Senha) {
        boolean com = false;
        String SERVIDOR = Servidor;
        String PORTA_CONEXAO = Porta;
        String USUARIO = usuario;
        String SENHA = Senha;

        try {
            Class.forName(driver);
            CONEXAO = DriverManager.getConnection("jdbc:mysql://" + SERVIDOR + ":"
                    + PORTA_CONEXAO + "/pfgdhaabd3", USUARIO, SENHA);
            com = true;
        } catch (ClassNotFoundException Fonte) {
            JOptionPane.showMessageDialog(null, "Driver não localizado");
        } catch (SQLException Fonte) {
        }
        return com;
    }
    //FIM.

    //METODO PARA FECHAR CONEXÃO COM O BANCO DE DADOS
    private void FECHAR_CONEXAO() {
        try {
            CONEXAO.close();
        } catch (SQLException fech) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com o banco de dados" + fech);
        }
    }
    //FIM.

    //METODO DE VERIFICAÇÃO DO DATABASE
    private boolean CRIA_DATA_BASE_COMPLETO() {
        boolean sucesso = true;
        if (CRIA_BANCO() == false) {
            sucesso = false;
        } else if (CRIA_TABELAS() == false) {
            sucesso = false;
        } else if (CRIA_INSERTES() == false) {
            sucesso = false;
        }

        return sucesso;
    }
    //FIM.

    //METODO DE CRIAÇÃO DO DATABASE
    private boolean CRIA_BANCO() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE DATABASE IF NOT EXISTS pfgdhaabd3";

        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        FECHAR_CONEXAO();
        return sucesso;
    }
    //FIM.

    //METODO DE CHAMADA DE CRIAÇÃO DE TABELAS
    private boolean CRIA_TABELAS() {
        boolean sucesso = true;

        CONEXAO_DATABASE(T_Host.getText(), T_Porta.getText(), T_User.getText(), T_Senha.getText());
        if (CRIA_TABELA_ENDERECO() == false) {
            sucesso = false;
        } else if (CRIA_TABELA_CLIENTES() == false) {
            sucesso = false;
        } else if (CRIA_TABELA_SOCIO_ECONOMICO() == false) {
            sucesso = false;
        } else if (CRIA_TABELA_SOCIO_ECONOMICO_SAUDE() == false) {
            sucesso = false;
        } else if (CRIA_TABELA_DEPENDENTES() == false) {
            sucesso = false;
        } else if (CRIA_TABELA_REFEICOES_VENDIDAS() == false) {
            sucesso = false;
        } else if (CRIA_TABELA_FUNCIONARIO() == false) {
            sucesso = false;
        } else if (CRIA_TABELA_USER() == false) {
            sucesso = false;
        } else if (CRIA_TABELA_USER_LOGS() == false) {
            sucesso = false;
        }
        FECHAR_CONEXAO();
        return sucesso;
    }
    //FIM.

    //METODOS DE CRIAÇÃO DE TABELA_ENDERECO
    private boolean CRIA_TABELA_ENDERECO() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE TABLE IF NOT EXISTS tb_endereco ("
                + " id INT NOT NULL AUTO_INCREMENT , "
                + " cep VARCHAR (20) NULL ,"
                + " bairro VARCHAR (50) NULL ,"
                + " rua VARCHAR (100) NULL ,"
                + " numero VARCHAR (20) NULL ,"
                + " referencia VARCHAR (100) NULL ,"
                + " nacionalidade VARCHAR (50) NULL ,"
                + " naturalidade VARCHAR (50) NULL ,"
                + " tempoDeMoradia_cliente VARCHAR (30) NULL ,"
                + " PRIMARY KEY (id) "
                + ") ENGINE = InnoDB";

        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
    //FIM.

    //METODOS DE CRIAÇÃO DE TABELA_CLIENTES
    private boolean CRIA_TABELA_CLIENTES() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE TABLE IF NOT EXISTS tb_clientes ("
                + "id int primary key not null auto_increment,"
                + "id_endereco int,"
                + "nome_Completo VARCHAR(100) NULL,"
                + "nome_Social VARCHAR(100) NULL,"
                + "cor_cliente VARCHAR(100) NULL,"
                + "nome_Mae VARCHAR(100) NULL,"
                + "telefone VARCHAR(20) NULL,"
                + "data_Nascimento VARCHAR(20) NULL,"
                + "idade_cliente VARCHAR(5) NULL,"
                + "genero_cliente VARCHAR(30) NULL,"
                + "estado_Civil VARCHAR(50) NULL,"
                + "rg VARCHAR(20) NULL,"
                + "cpf VARCHAR(20) NULL,"
                + "nis VARCHAR(30) NULL,"
                + "status_Cliente varchar (8) not null,"
                + "registration_date timestamp  NULL DEFAULT CURRENT_TIMESTAMP,"
                + "registration_date_update timestamp NULL DEFAULT NULL,"
                + "FOREIGN KEY (id_endereco) REFERENCES tb_endereco (id)"
                + ")ENGINE = InnoDB";

        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
    //FIM.

    //METODOS DE CRIAÇÃO DE TABELA_SOCIO_ECONOMICO
    private boolean CRIA_TABELA_SOCIO_ECONOMICO() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE TABLE IF NOT EXISTS tb_socio_economico ("
                + "id int primary key not null auto_increment,"
                + "id_cliente int,"
                + "escolariedade varchar (50) null,"
                + "renda_Mensal decimal (10,2) null,"
                + "emprego varchar (50) null,"
                + "programas_sociais varchar (50) null,"
                + "moradia varchar (50) null,"
                + "estrutura_Moradia varchar (50) null,"
                + "qtdMoradores int null,"
                + "qtdPessoas_Trabalhando int NULL,"
                + "profissao_Responsavel VARCHAR(50) NULL,"
                + "AB_Agua varchar (3),"
                + "SN_basico varchar (3),"
                + "Energia_eletrica varchar (3),"
                + "Lixo_Domiciliar varchar (15),"
                + "frequenta_Centro varchar (5),"
                + "registration_date timestamp  NULL DEFAULT CURRENT_TIMESTAMP,"
                + "registration_date_update timestamp NULL DEFAULT NULL,"
                + "FOREIGN KEY (id_cliente) REFERENCES tb_clientes (id)"
                + ")ENGINE = InnoDB";

        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
    //FIM.

    //METODOS DE CRIAÇÃO DE TABELA_SOCIO_ECONOMICO_SAUDE
    private boolean CRIA_TABELA_SOCIO_ECONOMICO_SAUDE() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE TABLE IF NOT EXISTS tb_socio_economico_saude ("
                + "id int primary key not null auto_increment,"
                + "id_cliente int,"
                + "doenca varchar (100) null,"
                + "outras_Doencas varchar (100) null,"
                + "deficiencia varchar (3) null,"
                + "justificativa_Deficiencia varchar (100) null,"
                + "laudo varchar (100) null,"
                + "observacao varchar (100) null,"
                + "registration_date timestamp  NULL DEFAULT CURRENT_TIMESTAMP,"
                + "registration_date_update timestamp NULL DEFAULT NULL,"
                + "FOREIGN KEY (id_cliente) REFERENCES tb_clientes (id)"
                + ")ENGINE = InnoDB";

        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
    //FIM.

    //METODOS DE CRIAÇÃO DE TABELA_DEPENDENTES
    private boolean CRIA_TABELA_DEPENDENTES() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE TABLE IF NOT EXISTS tb_dependentes ("
                + "id int primary key not null auto_increment,"
                + "id_cliente int,"
                + "nome_dependente varchar (100) null,"
                + "rg varchar (10) null unique,"
                + "cpf varchar (15) null unique,"
                + "DT_nascimento varchar (10) null,"
                + "genero varchar (10) null,"
                + "status_Cliente varchar (8),"
                + "registration_date timestamp  NULL DEFAULT CURRENT_TIMESTAMP,"
                + "registration_date_update timestamp NULL DEFAULT NULL,"
                + "FOREIGN KEY (id_cliente) REFERENCES tb_clientes (id)"
                + ") ENGINE = InnoDB";

        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
    //FIM.

    //METODOS DE CRIAÇÃO DE TABELA_REFEICOES_VENDIDAS
    private boolean CRIA_TABELA_REFEICOES_VENDIDAS() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE TABLE IF NOT EXISTS tb_refeicoes_vendidas ("
                + "id int primary key auto_increment not null,"
                + "total_servido int not null,"
                + "data varchar (20),"
                + "registration_date timestamp  NULL DEFAULT CURRENT_TIMESTAMP,"
                + "registration_date_update timestamp NULL DEFAULT NULL"
                + ") ENGINE = InnoDB";

        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
    //FIM.

    //METODOS DE CRIAÇÃO DE TABELA_FUNCIONARIO
    private boolean CRIA_TABELA_FUNCIONARIO() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE TABLE IF NOT EXISTS tb_funcionario ("
                + "id int primary key auto_increment not null,"
                + "nome varchar (100) not null,"
                + "funcao varchar (50) not null,"
                + "telefone varchar (15) null,"
                + "registration_date timestamp  NULL DEFAULT CURRENT_TIMESTAMP,"
                + "registration_date_update timestamp NULL DEFAULT NULL"
                + ") ENGINE = InnoDB";

        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
    //FIM.

    //METODOS DE CRIAÇÃO DE TABELA_USER
    private boolean CRIA_TABELA_USER() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE TABLE IF NOT EXISTS tb_user ("
                + "id int primary key auto_increment not null,"
                + "id_funcionario int,"
                + "login varchar (15) not null,"
                + "password varchar (100) not null,"
                + "perfil varchar (50) not null,"
                + "registration_date timestamp  NULL DEFAULT CURRENT_TIMESTAMP,"
                + "registration_date_update timestamp NULL DEFAULT NULL,"
                + "FOREIGN KEY (id_funcionario) REFERENCES tb_funcionario (id)"
                + ") ENGINE = InnoDB";

        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
    //FIM.

    //METODOS DE CRIAÇÃO DE TABELA_USER_LOGS
    private boolean CRIA_TABELA_USER_LOGS() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE TABLE IF NOT EXISTS tb_userlogs ("
                + "id int primary key auto_increment not null,"
                + "id_user int,"
                + "login varchar (15),"
                + "nome varchar (100),"
                + "registration_date timestamp  NULL DEFAULT CURRENT_TIMESTAMP,"
                + "registration_date_update timestamp NULL DEFAULT NULL,"
                + "FOREIGN KEY (id_user) REFERENCES tb_user (id)"
                + ") ENGINE = InnoDB";

        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
    //FIM.

    //METODO DE CHAMADA DE CRIAÇÃO DE PROCEDURES
//    @SuppressWarnings("empty-statement")
    private boolean CRIA_PROCEDURES() {
        boolean sucesso = true;

        CONEXAO_DATABASE(T_Host.getText(), T_Porta.getText(), T_User.getText(), T_Senha.getText());
        if (CRIA_PROCIDURE_COR() == false) {
            sucesso = false;
        };
        FECHAR_CONEXAO();
        return sucesso;
    }
//    FIM.
//    METODO DE CRIAÇÃO DE PROCEDURES

    private boolean CRIA_PROCIDURE_COR() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "CREATE PROCEDURE IF NOT EXISTS sp_save_cor ("
                + "  pnome_Completo varchar(100), "
                + "  pnome_Social varchar(100), "
                + "  )"
                + "  BEGIN"
                + "  insert into tb_cor (descricao) values (pdescricao);"
                + "  END";
        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }

//    FIM.
    //METODO DE CHAMADA DE CRIAÇÃO DE INSERTES
//    @SuppressWarnings("empty-statement")
    private boolean CRIA_INSERTES() {
        boolean sucesso = true;

        CONEXAO_DATABASE(T_Host.getText(), T_Porta.getText(), T_User.getText(), T_Senha.getText());
        if (CRIA_INSERT_FUNCIONARIO() == false) {
            sucesso = false;
        } else if (CRIA_INSERT_USER() == false) {
            sucesso = false;
        };
        FECHAR_CONEXAO();
        return sucesso;
    }
//    FIM.

    //METODO DE INSERIR DADOS NA TABELA_FUNCIONARIO
    private boolean CRIA_INSERT_FUNCIONARIO() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "INSERT INTO tb_funcionario"
                + "  (nome, funcao, telefone) values "
                + "  ('Matheus Mota da Silva', 'Desenvolvedor', '(92) 98841-1136')";
        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
//    FIM.

    //METODO DE INSERIR DADOS NA TABELA_FUNCIONARIO
    private boolean CRIA_INSERT_USER() {
        boolean sucesso = false;
        PreparedStatement stm;
        String sql = "INSERT INTO tb_user"
                + "  (id_funcionario, login, password, perfil) values "
                + "  (1, '000.000.000-00', '123', 'Administrador')";
        try {
            stm = CONEXAO.prepareStatement(sql);
            stm.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
        return sucesso;
    }
//    FIM.
}