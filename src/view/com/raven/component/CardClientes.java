package view.com.raven.component;

import view.com.raven.model.CPF;
import com.raven.banco.ConexaoBD;
import com.raven.controller.ControllerTitular;
import com.raven.controller.ControllerDependentes;
import com.raven.controller.ControllerSocioEconomico;
import com.raven.controller.ControllerSocioEconomicoSaude;
import com.raven.dao.ClientesDao;
import com.raven.dao.TitularDao;
import com.raven.model.Titular;
import com.raven.model.Dependentes;
import com.raven.model.Endereco;
import com.raven.model.SocioEconomico;
import com.raven.model.SocioEconomicoSaude;
import com.raven.tabelas.TabelaUniversal;
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
import javax.swing.table.DefaultTableModel;
import view.com.raven.swing.ScrollBar;
import view.com.raven.swing.Table2;

public class CardClientes extends javax.swing.JPanel {

    // VARIAVEIS GLOBAIS.
    int id, flag = 0, cliIdade;
    int id_dependente;
    int id_titular;
    int id_cliente;

    //INSTANCIAMENTO DE CLASSES.
    Titular titular = new Titular();
    Endereco endereco = new Endereco();
    Dependentes dependentes = new Dependentes();
    SocioEconomico socioEconomico = new SocioEconomico();
    SocioEconomicoSaude socioEconomicoSaude = new SocioEconomicoSaude();

    //INSTANCIAMENTO PARA METODO ARRAYLIST.
    ArrayList<Titular> listTitular = new ArrayList<>();
    ArrayList<Dependentes> listDependentes = new ArrayList<>();

    //INSTANCIAMENTO DE CLASSE DE CONEXÃO DO BANCO DE DADOS.
    ConexaoBD con = new ConexaoBD();

    //INSTANCIAMENTO DAS CASSES CONTROLADORAS.
    ControllerTitular controllerTitular = new ControllerTitular();
    ControllerDependentes controllerDependetes = new ControllerDependentes();
    ControllerSocioEconomico controllerSocioEconomico = new ControllerSocioEconomico();
    ControllerSocioEconomicoSaude controllerSocioEconomicoSaude = new ControllerSocioEconomicoSaude();

    TitularDao titularDao = new TitularDao();

    public CardClientes() {
        initComponents();
        setOpaque(false);

        //CHAMADA DE METODOS PARA DESABILITAR CAMPOS E BOTÕES.
        desabilitarCampos();
        desabilitarBotao();

        //INICIALIZAÇÃO DE TABELAS AO LIGAR O SISTEMA.
//        tabela_cliente("SELECT * FROM tb_clientes");
//
//        tabela_cliente_dependente("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id order by nome_Completo");
//
//        tabela_cliente_socio_economico("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id order by nome_Completo");
//
//        tabela_cliente_socio_economico_Saude("select id_clientes, nome_cliente, cpf_cliente, rg_cliente, idade_cliente, genero from tb_clientes order by nome_cliente");
//
//        tabela_dependente();
    }
    

    //TABELA CARREGANDO DADOS DOS CLIENTES NA GUIA CLIENTE
//    public final void tabela_cliente(String Sql) {
//        spTableCliente.setVerticalScrollBar(new ScrollBar());
//        spTableCliente.getVerticalScrollBar().setBackground(Color.WHITE);
//        spTableCliente.getViewport().setBackground(Color.WHITE);
//
//        JPanel p = new JPanel();
//        p.setBackground(Color.WHITE);
//        spTableCliente.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
//
//        ArrayList dados = new ArrayList();
//        String[] colunas = new String[]{"ID", "Nome", "RG", "CPF", "DT NASCIMENTO", "TELEFONE"};
//
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
//                    con.getResultSet().getString("genero")});
//            } while (con.getResultSet().next());
//        } catch (SQLException e) {
//
//        }
//
//        TabelaUniversal tabela = new TabelaUniversal(dados, colunas);
//
//        table_cliente.setModel(tabela);
//        table_cliente.getColumnModel().getColumn(0).setPreferredWidth(30);
//        table_cliente.getColumnModel().getColumn(0).setResizable(false);
//        table_cliente.getColumnModel().getColumn(1).setPreferredWidth(190);
//        table_cliente.getColumnModel().getColumn(1).setResizable(false);
//        table_cliente.getColumnModel().getColumn(2).setPreferredWidth(120);
//        table_cliente.getColumnModel().getColumn(2).setResizable(false);
//        table_cliente.getColumnModel().getColumn(3).setPreferredWidth(115);
//        table_cliente.getColumnModel().getColumn(3).setResizable(false);
//        table_cliente.getColumnModel().getColumn(4).setPreferredWidth(140);
//        table_cliente.getColumnModel().getColumn(4).setResizable(false);
//        table_cliente.getColumnModel().getColumn(5).setPreferredWidth(168);
//        table_cliente.getColumnModel().getColumn(5).setResizable(false);
//        table_cliente.getTableHeader().setReorderingAllowed(false);
//        table_cliente.setAutoResizeMode(Table2.AUTO_RESIZE_OFF);
//        table_cliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//    }//FIM.

    //TABELA CARREGANDO DADOS DOS CLIENTES NA GUIA DEPENDENTES 
//    public final void tabela_cliente_dependente(String Sql) {
//        spTableCliente_dependente.setVerticalScrollBar(new ScrollBar());
//        spTableCliente_dependente.getVerticalScrollBar().setBackground(Color.WHITE);
//        spTableCliente_dependente.getViewport().setBackground(Color.WHITE);
//
//        JPanel p = new JPanel();
//        p.setBackground(Color.WHITE);
//        spTableCliente_dependente.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
//
//        ArrayList dados = new ArrayList();
//        String[] colunas = new String[]{"ID", "Nome", "RG", "CPF", "DT NASCIMENTO", "TELEFONE", "ESTADO CIVIL", "STATUS"};
//
//        con.getConectar();
//        con.executarSql(Sql);
//        //Inserir dados na tabela
//        try {
//            con.getResultSet().first();
//            do {
//                dados.add(new Object[]{con.getResultSet().getInt("id"), con.getResultSet().getString("nome_Completo"),
//                    con.getResultSet().getString("rg"), con.getResultSet().getString("cpf"),
//                    con.getResultSet().getString("data_Nascimento"), con.getResultSet().getString("telefone"), con.getResultSet().getString("estado_Civil"),
//                    con.getResultSet().getString("status_Cliente")});
//            } while (con.getResultSet().next());
//        } catch (SQLException e) {
//
//        }
//
//        TabelaUniversal tabela = new TabelaUniversal(dados, colunas);
//
//        table_cliente_dependente.setModel(tabela);
//        table_cliente_dependente.getColumnModel().getColumn(0).setPreferredWidth(30);
//        table_cliente_dependente.getColumnModel().getColumn(0).setResizable(false);
//        table_cliente_dependente.getColumnModel().getColumn(1).setPreferredWidth(190);
//        table_cliente_dependente.getColumnModel().getColumn(1).setResizable(false);
//        table_cliente_dependente.getColumnModel().getColumn(2).setPreferredWidth(120);
//        table_cliente_dependente.getColumnModel().getColumn(2).setResizable(false);
//        table_cliente_dependente.getColumnModel().getColumn(3).setPreferredWidth(115);
//        table_cliente_dependente.getColumnModel().getColumn(3).setResizable(false);
//        table_cliente_dependente.getColumnModel().getColumn(4).setPreferredWidth(140);
//        table_cliente_dependente.getColumnModel().getColumn(4).setResizable(false);
//        table_cliente_dependente.getColumnModel().getColumn(5).setPreferredWidth(168);
//        table_cliente_dependente.getColumnModel().getColumn(5).setResizable(false);
//        table_cliente_dependente.getColumnModel().getColumn(6).setPreferredWidth(115);
//        table_cliente_dependente.getColumnModel().getColumn(6).setResizable(false);
//        table_cliente_dependente.getColumnModel().getColumn(7).setPreferredWidth(140);
//        table_cliente_dependente.getColumnModel().getColumn(7).setResizable(false);
//        table_cliente_dependente.getTableHeader().setReorderingAllowed(false);
//        table_cliente_dependente.setAutoResizeMode(table_cliente_dependente.AUTO_RESIZE_OFF);
//        table_cliente_dependente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//    }//FIM.

    //TABELA CARREGANDO DADOS DEPENDENTES NA GUIA DEPENDENTES
//    public final void tabela_dependente() {
//        spTableDependentes.setVerticalScrollBar(new ScrollBar());
//        spTableDependentes.getVerticalScrollBar().setBackground(Color.WHITE);
//        spTableDependentes.getViewport().setBackground(Color.WHITE);
//
//        JPanel p = new JPanel();
//        p.setBackground(Color.WHITE);
//        spTableDependentes.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
//
//        listDependentes = controllerDependetes.returnListDependentesController();
//        DefaultTableModel table = (DefaultTableModel) spTableDependente.getModel();
//        table.setNumRows(0);
//        //Inserir dados na tabela
//        int cont = listDependentes.size();
//        for (int i = 0; i < cont; i++) {
//            table.addRow(new Object[]{
//                listDependentes.get(i).getId(),
//                listDependentes.get(i).getNome_Completo(),
//                listDependentes.get(i).getRg(),
//                listDependentes.get(i).getCpf(),
//                listDependentes.get(i).getIdade_cliente(),
//                listDependentes.get(i).getGenero_cliente(),
//                listDependentes.get(i).getDependencia_cliente()
//            });
//        }
//    }//FIM.

    //TABELA CARREGANDO DADOS DOS CLIENTES NA GUIA SOCIO_ECONOMICO
//    public final void tabela_cliente_socio_economico(String Sql) {
//        spTableCliente_Socio_Economico.setVerticalScrollBar(new ScrollBar());
//        spTableCliente_Socio_Economico.getVerticalScrollBar().setBackground(Color.WHITE);
//        spTableCliente_Socio_Economico.getViewport().setBackground(Color.WHITE);
//
//        JPanel p = new JPanel();
//        p.setBackground(Color.WHITE);
//        spTableCliente_Socio_Economico.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
//
//        ArrayList dados = new ArrayList();
//        String[] colunas = new String[]{"ID", "Nome", "RG", "CPF", "DT NASCIMENTO", "TELEFONE", "ESTADO CIVIL", "STATUS"};
//
//        con.getConectar();
//        con.executarSql(Sql);
//        //Inserir dados na tabela
//        try {
//            con.getResultSet().first();
//            do {
//                dados.add(new Object[]{con.getResultSet().getInt("id"), con.getResultSet().getString("nome_Completo"),
//                    con.getResultSet().getString("rg"), con.getResultSet().getString("cpf"),
//                    con.getResultSet().getString("data_Nascimento"), con.getResultSet().getString("telefone"), con.getResultSet().getString("estado_Civil"),
//                    con.getResultSet().getString("status_Cliente")});
//            } while (con.getResultSet().next());
//        } catch (SQLException e) {
//
//        }
//
//        TabelaUniversal tabela = new TabelaUniversal(dados, colunas);
//
//        table_cliente_socio_Economico.setModel(tabela);
//        table_cliente_socio_Economico.getColumnModel().getColumn(0).setPreferredWidth(30);
//        table_cliente_socio_Economico.getColumnModel().getColumn(0).setResizable(false);
//        table_cliente_socio_Economico.getColumnModel().getColumn(1).setPreferredWidth(190);
//        table_cliente_socio_Economico.getColumnModel().getColumn(1).setResizable(false);
//        table_cliente_socio_Economico.getColumnModel().getColumn(2).setPreferredWidth(120);
//        table_cliente_socio_Economico.getColumnModel().getColumn(2).setResizable(false);
//        table_cliente_socio_Economico.getColumnModel().getColumn(3).setPreferredWidth(115);
//        table_cliente_socio_Economico.getColumnModel().getColumn(3).setResizable(false);
//        table_cliente_socio_Economico.getColumnModel().getColumn(4).setPreferredWidth(140);
//        table_cliente_socio_Economico.getColumnModel().getColumn(4).setResizable(false);
//        table_cliente_socio_Economico.getColumnModel().getColumn(5).setPreferredWidth(168);
//        table_cliente_socio_Economico.getColumnModel().getColumn(5).setResizable(false);
//        table_cliente_socio_Economico.getColumnModel().getColumn(6).setPreferredWidth(115);
//        table_cliente_socio_Economico.getColumnModel().getColumn(6).setResizable(false);
//        table_cliente_socio_Economico.getColumnModel().getColumn(7).setPreferredWidth(140);
//        table_cliente_socio_Economico.getColumnModel().getColumn(7).setResizable(false);
//        table_cliente_socio_Economico.getTableHeader().setReorderingAllowed(false);
//        table_cliente_socio_Economico.setAutoResizeMode(table_cliente_socio_Economico.AUTO_RESIZE_OFF);
//        table_cliente_socio_Economico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//    }//FIM.

    //TABELA CARREGANDO DADOS DOS CLIENTES NA GUIA SOCIO_ECONOMICO_SAUDE
//    public final void tabela_cliente_socio_economico_Saude(String Sql) {
//        spTableCliente_Socio_EconomicoSaude.setVerticalScrollBar(new ScrollBar());
//        spTableCliente_Socio_EconomicoSaude.getVerticalScrollBar().setBackground(Color.WHITE);
//        spTableCliente_Socio_EconomicoSaude.getViewport().setBackground(Color.WHITE);
//
//        JPanel p = new JPanel();
//        p.setBackground(Color.WHITE);
//        spTableCliente_Socio_EconomicoSaude.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
//
//        //Inserir dados na tabela
//        ArrayList dados = new ArrayList();
//        String[] colunas = new String[]{"ID", "Nome", "CPF", "RG", "IDADE", "SEXO"};
//
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
//                    con.getResultSet().getString("idade_cliente"),
//                    con.getResultSet().getString("genero")});
//            } while (con.getResultSet().next());
//        } catch (SQLException e) {
//
//        }
//
//        TabelaUniversal tabela = new TabelaUniversal(dados, colunas);
//
//        table_cliente_socio_EconomicoSaude.setModel(tabela);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(0).setPreferredWidth(30);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(0).setResizable(false);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(1).setPreferredWidth(190);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(1).setResizable(false);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(2).setPreferredWidth(120);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(2).setResizable(false);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(3).setPreferredWidth(115);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(3).setResizable(false);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(4).setPreferredWidth(140);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(4).setResizable(false);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(5).setPreferredWidth(420);
//        table_cliente_socio_EconomicoSaude.getColumnModel().getColumn(5).setResizable(false);
//        table_cliente_socio_EconomicoSaude.getTableHeader().setReorderingAllowed(false);
//        table_cliente_socio_EconomicoSaude.setAutoResizeMode(table_cliente_socio_EconomicoSaude.AUTO_RESIZE_OFF);
//        table_cliente_socio_EconomicoSaude.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//    }//FIM.

    //METODO PARA LIMPAR CAMPOS DA TELA CLIENTE
    public void limparCampos() {
        txtnomeCompleto.setText("");
        txtnomeSocial.setText("");
        txtnomeMae.setText("");
        txtDTNascimento.setText("");
        txtFone.setText("");
        txtRg.setText("");
        txtcpf.setText("");
        txtcep.setText("");
        txtbairro.setText("");
        txtrua.setText("");
        txtnumerocasa.setText("");
        txtreferencia.setText("");
        txtidade.setText("");
        txtnaturalidade.setText("");
        txtCidade.setText("");
        txttempomoradia.setText("");
    }//FIM.

    //METODO PARA LIMPAR CAMPOS DA TELA DEPENDENTES
    public void limparCamposDependentes() {
        txtNomeClienteTitular.setText("");
        txtnomeCompletoDependente.setText("");
        txtRgDependente.setText("");
        txtcpfDependente.setText("");
        txtIdateDependente.setText("");
    }//FIM.

    //METODO PARA LIMPAR CAMPOS DA TELA SOCIO_ECONOMICO
    public void limparCamposSocioEconomico() {
        txtNomeClienteTitularSocioEconomico.setText("");
        txtProfissaoResponsavel.setText("");
        txtPessoasTrabalhando.setText("");
        txtNomeClienteSocioEconomico.setText("");
    }//FIM.

    //METODO PARA LIMPAR CAMPOS DA TELA SOCIO_ECONOMICO_SAUDE
    public void limparCampoSocioEconomicoSaude() {
        txtoutrasDoencas.setText("");
        txtjustificativaDeficiencia.setText("");
        txtObservação.setText("");
        txtNomeClienteTitularSocioEconomicoSaude.setText("");
    }//FIM.

    //METODO PARA DESABILITAR CAMPOS DA TELA CLIENTE
    public final void desabilitarCampos() {
        txtnomeCompleto.setEnabled(false);
        txtnomeSocial.setEnabled(false);
        txtnomeMae.setEnabled(false);
        comboCor.setEnabled(false);
        txtFone.setEnabled(false);
        txtDTNascimento.setEnabled(false);
        comboSexo.setEnabled(false);
        comboEst_Civil.setEnabled(false);
        txtRg.setEnabled(false);
        txtcpf.setEnabled(false);
        comboStatus.setEnabled(false);
        txtcep.setEnabled(false);
        txtbairro.setEnabled(false);
        txtrua.setEnabled(false);
        txtnumerocasa.setEnabled(false);
        txtreferencia.setEnabled(false);
        txtidade.setEnabled(false);
        combonacionalidade.setEnabled(false);
        txtnaturalidade.setEnabled(false);
        txtCidade.setEnabled(false);
        txttempomoradia.setEnabled(false);
    }//FIM.

    //METODO PARA HABILITAR CAMPOS DA TELA CLIENTE
    public void habilitarCampos() {
        txtnomeCompleto.setEnabled(true);
        txtnomeSocial.setEnabled(true);
        txtnomeMae.setEnabled(true);
        comboCor.setEnabled(true);
        txtFone.setEnabled(true);
        txtDTNascimento.setEnabled(true);
        comboSexo.setEnabled(true);
        comboEst_Civil.setEnabled(true);
        txtRg.setEnabled(true);
        txtcpf.setEnabled(true);
        comboStatus.setEnabled(true);
        txtcep.setEnabled(true);
        txtbairro.setEnabled(true);
        txtrua.setEnabled(true);
        txtnumerocasa.setEnabled(true);
        txtreferencia.setEnabled(true);
        txtidade.setEnabled(true);
        combonacionalidade.setEnabled(true);
        txtnaturalidade.setEnabled(true);
        txtCidade.setEnabled(true);
        txttempomoradia.setEnabled(true);
    }//FIM.

    //METODO PARA DESABILITAR BOTÃO DA TELA CLIENTE
    public final void desabilitarBotao() {
        btnNovo.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//FIM.

    //METODO PARA HABILITAR BOTÃO DA TELA CLIENTE
    public void habilitarBotao() {
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//FIM.

    //METODO PARA VALIDAR CAMPOS NA TELA CLIENTE
    public void validarCamposTitular() {
        if (txtnomeCompleto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo Nome é Obrigatório!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtnomeCompleto.requestFocus();
            return;
        }

        if (txtFone.getText().equals("(  )      -    ")) {
            JOptionPane.showMessageDialog(this, "Campo Telefone é Obrigatório!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtFone.requestFocus();
            return;
        }

        if (txtcpf.getText().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(this, "Campo CPF é Obrigatório!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtcpf.requestFocus();
            return;
        }

        if (txtDTNascimento.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(this, "Campo Data de Nascimento é Obrigatório!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtDTNascimento.requestFocus();
            return;
        }

        if (txtidade.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo Idade é Obrigatório!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtidade.requestFocus();
            return;
        }
    }//FIM.

    //METODO PARA VALIDAR CAMPOS NA TELA DEPENDENTES
    public void validarCamposDependentes() {
        if (txtNomeClienteTitular.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione um Titular!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txtnomeCompletoDependente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo Nome é Obrigatório!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtnomeCompletoDependente.requestFocus();
            return;
        }

        if (txtIdateDependente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo Idade é Obrigatório!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtIdateDependente.requestFocus();
            return;
        }

    }//FIM.

    //METODO PARA VALIDAR CAMPOS NA TELA SOCIO_ECONOMICO
    public void validarCamposSocioEconomico() {
        if (txtNomeClienteTitularSocioEconomico.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione um Titular!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txtPessoasTrabalhando.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Informe a quantidade de pessoas trabalham!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtPessoasTrabalhando.requestFocus();
            return;
        }
    }//FIM.

    //METODO PARA VALIDAR CAMPOS NA TELA SOCIO_ECONOMICO_SAUDE
    public void validarCamposSocioEconomicoSaude() {
        if (txtNomeClienteTitularSocioEconomicoSaude.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione um Titular!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtNomeClienteTitularSocioEconomicoSaude.requestFocus();
            return;
        }
    }//FIM.

    //METODO SALVAR CLIENTES
    public void saveClientes() {
        //VARIAVEIS LOCAIS SENDO DECLARADAS COMO STRING.
        String rua, bairro, cidade, cpf;

        //VARIAVEIS RECEBENDO VALORES DA TELA PARA REALIZAR COMPARAÇÃO DE CAMPOS VAZIOS OU NULOS.
        rua = txtrua.getText();
        bairro = txtbairro.getText();
        cidade = txtCidade.getText();
        cpf = txtcpf.getText();

        cliIdade = Integer.parseInt(txtidade.getText());

        CPF pf = new CPF(cpf);

        if (controllerTitular.controlVerificarCPFCadastrado(txtcpf.getText()) == false) {//PRIMEIRO IF DE VERIFICAÇÃO DE CPF CADASTRADO
            if (!bairro.isEmpty()) {//SEGUNDO IF  PARA CAMPO VAZIO"rua"
                if (!rua.isEmpty()) {//TERCEIRO IF PARA CAMPO VAZIO "bairro"
                    if (!cidade.isEmpty()) {//QUARTO IF PARA CAMPO VAZIO "cidade"
                        if (cliIdade > 17) {//QUINTO IF PARA CAMPO VAZIO "idade"
                            if (pf.isCPF()) {
                                titular.setNome_Completo(txtnomeCompleto.getText());
                                titular.setNome_Social(txtnomeSocial.getText());
                                titular.setNome_Mae(txtnomeMae.getText());
                                titular.setCor_cliente((String) this.comboCor.getSelectedItem());
                                titular.setTelefone(txtFone.getText());
                                titular.setData_Nascimento(txtDTNascimento.getText());
                                titular.setGenero_cliente((String) this.comboSexo.getSelectedItem());
                                titular.setEstado_Civil((String) this.comboEst_Civil.getSelectedItem());
                                titular.setRg(txtRg.getText());
                                titular.setCpf(txtcpf.getText());
                                titular.setStatus_Cliente((String) this.comboStatus.getSelectedItem());
                                titular.setIdade_cliente(cliIdade);

                                endereco.setCep(txtcep.getText());
                                endereco.setBairro(bairro);
                                endereco.setRua(rua);
                                endereco.setNumero(txtnumerocasa.getText());
                                endereco.setReferencia(txtreferencia.getText());
                                endereco.setNacionalidade((String) this.combonacionalidade.getSelectedItem());
                                endereco.setNaturalidade(txtnaturalidade.getText());
                                endereco.setCidade(cidade);
                                endereco.setTempoDeMoradia_cliente(txttempomoradia.getText());

                                boolean resultado = controllerTitular.controlSaveClientes(titular, endereco);
                                if (resultado == true) {//CONDIÇÃO PARA MANDAR O RESULTADO PARA O BACK-END, PARA SALVAR
                                    ClientesDao clientesDao = new ClientesDao();
                                    clientesDao.inserirClientesCadastrados();
                                    JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
//                                    tabela_cliente("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                                            + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                                            + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                                            + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id order by nome_Completo");
//                                    tabela_cliente_dependente("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                                            + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                                            + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                                            + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id order by nome_Completo");
//                                    tabela_cliente_socio_economico("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                                            + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                                            + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                                            + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id order by nome_Completo");
//                                    tabela_cliente_socio_economico_Saude("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                                            + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                                            + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                                            + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id order by nome_Completo");
                                    limparCampos();
                                    desabilitarCampos();
                                    desabilitarBotao();
                                } else {
                                    JOptionPane.showMessageDialog(this, "Erro ao Salvar!");
                                    limparCampos();
                                    desabilitarCampos();
                                    desabilitarBotao();
                                }//FIM DA CONDIÇÃO PARA SALVAR.

                            } else {
                                JOptionPane.showMessageDialog(null, "CPF inválido!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Cliente tem que ter 18 anos para realizar o cadastro!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                            txtidade.requestFocus();
                        }//FIM DA VERIFICAÇÃO DE IDADE.
                    } else {
                        JOptionPane.showMessageDialog(this, "Preencha o campo Cidade!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                        txtCidade.requestFocus();
                    }//FIM IF "Cidade". 
                } else {
                    JOptionPane.showMessageDialog(this, "Preencha o campo Rua!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                    txtrua.requestFocus();
                }//FIM IF "bairro". 
            } else {

                JOptionPane.showMessageDialog(this, "Preencha o campo Bairro!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                txtbairro.requestFocus();
            }//FIM IF "rua"
        } else {
            JOptionPane.showMessageDialog(null, "Cliente com o mesmo CPF já cadastrado!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            txtcpf.requestFocus();
        }//FIM IF "VERIFICAÇÃO DE CPF"
    }//FIM.

    //METODO UPDATE CLIENTES
    public void updateClientes() {

        String nomeCompleto, cpf, telefone, rua, bairro, cidade;

        nomeCompleto = txtnomeCompleto.getText();
        cpf = txtcpf.getText();
        telefone = txtFone.getText();
        rua = txtrua.getText();
        bairro = txtbairro.getText();
        cidade = txtCidade.getText();

        cliIdade = Integer.parseInt(txtidade.getText());

        if (!nomeCompleto.isEmpty()) {//PRIMEIRO IF "nomeCompleto"
            if (!cpf.isEmpty()) {//SEGUNDO IF "cpf"
                if (!telefone.isEmpty()) {//TERCEIRO IF "telefone"
                    if (!rua.isEmpty()) {//QUARTO IF "rua"
                        if (!bairro.isEmpty()) {//QUINTO IF "bairro"
                            if (!cidade.isEmpty()) {//SEXTO IF "cidade"
                                titular.setId(this.id);
                                titular.setNome_Completo(nomeCompleto);
                                titular.setNome_Social(txtnomeSocial.getText());
                                titular.setNome_Mae(txtnomeMae.getText());
                                titular.setCor_cliente((String) this.comboCor.getSelectedItem());
                                titular.setTelefone(telefone);
                                titular.setData_Nascimento(txtDTNascimento.getText());
                                titular.setGenero_cliente((String) this.comboSexo.getSelectedItem());
                                titular.setEstado_Civil((String) this.comboEst_Civil.getSelectedItem());
                                titular.setRg(txtRg.getText());
                                titular.setCpf(cpf);
                                titular.setStatus_Cliente((String) this.comboStatus.getSelectedItem());
                                titular.setIdade_cliente(cliIdade);

                                endereco.setCep(txtcep.getText());
                                endereco.setBairro(bairro);
                                endereco.setRua(rua);
                                endereco.setNumero(txtnumerocasa.getText());
                                endereco.setReferencia(txtreferencia.getText());
                                endereco.setNacionalidade((String) this.combonacionalidade.getSelectedItem());
                                endereco.setNaturalidade(txtnaturalidade.getText());
                                endereco.setCidade(cidade);
                                endereco.setTempoDeMoradia_cliente(txttempomoradia.getText());

                                boolean resultado = controllerTitular.controlUpdateClientes(titular, endereco);
                                if (resultado == true) {//CONDIÇÃO PARA MANDAR O RESULTADO PARA O BACK-END, PARA SALVAR
                                    JOptionPane.showMessageDialog(this, "Alterado com sucesso!");
//                                    tabela_cliente("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                                            + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                                            + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                                            + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id order by nome_Completo");
//                                    tabela_cliente_dependente("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                                            + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                                            + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                                            + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id order by nome_Completo");
//                                    tabela_cliente_socio_economico("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                                            + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                                            + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                                            + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id order by nome_Completo");
//                                    tabela_cliente_socio_economico_Saude("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                                            + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                                            + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                                            + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id order by nome_Completo");
                                    limparCampos();
                                    desabilitarCampos();
                                    desabilitarBotao();
                                } else {
                                    JOptionPane.showMessageDialog(this, "Erro ao Salvar!");
                                    limparCampos();
                                    desabilitarCampos();
                                    desabilitarBotao();
                                }//FIM DA CONDIÇÃO PARA SALVAR.
                            } else {
                                JOptionPane.showMessageDialog(this, "Preencha o campo Cidade!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                                txtCidade.requestFocus();
                            }//FIM IF "Cidade".         
                        } else {
                            JOptionPane.showMessageDialog(this, "Preencha o campo Bairro!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                            txtbairro.requestFocus();
                        }//FIM IF "bairro". 
                    } else {
                        JOptionPane.showMessageDialog(this, "Preencha o campo Rua!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                        txtrua.requestFocus();
                    }//FIM IF "rua"
                } else {
                    JOptionPane.showMessageDialog(this, "Preencha o campo Telefone!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                    txtFone.requestFocus();
                }//FIM IF "Fone"
            } else {
                JOptionPane.showMessageDialog(this, "Preencha o campo CPF!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                txtcpf.requestFocus();
            }//FIM IF "cpf"
        } else {
            JOptionPane.showMessageDialog(this, "Preencha o campo Nome!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtnomeCompleto.requestFocus();
        }//FIM IF "nomeCompleto"
    }//FIM.

    //METODO SALVAR DEPENDENTES
    public void saveDependentes() {
        int cliIdadedep;
        String nomeDependente, teste;
        nomeDependente = txtnomeCompletoDependente.getText();

        cliIdadedep = Integer.parseInt(txtIdateDependente.getText());

        if (cliIdadedep > 5) {
            if (!nomeDependente.isEmpty()) {
                dependentes.setId_titular(id);
                dependentes.setNome_Completo(nomeDependente);
                dependentes.setRg(txtRgDependente.getText());
                dependentes.setCpf(txtcpfDependente.getText());
                dependentes.setIdade_cliente(cliIdadedep);
                dependentes.setGenero_cliente((String) comboSexoDependente.getSelectedItem());
                dependentes.setDependencia_cliente((String) comboParentesco.getSelectedItem());
                boolean resultado = controllerDependetes.controlSaveDependentes(dependentes);
                if (resultado == true) {//CONDIÇÃO PARA MANDAR O RESULTADO PARA O BACK-END, PARA SALVAR
                    JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
                    limparCamposDependentes();
//                    tabela_dependente();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao Salvar!");
                }//FIM DA CONDIÇÃO PARA SALVAR.
            } else {
                JOptionPane.showMessageDialog(this, "Preencha o Nome do Dependente!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                txtnomeCompletoDependente.requestFocus();
            }//FIM IF "Idade".
        } else {
            JOptionPane.showMessageDialog(this, "Dependente com menos de 5 anos não precisa ser cadastrado no sistema!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            txtIdateDependente.requestFocus();
        }//FIM IF "Idade".  
    }//FIM.

    //METODO SALVAR SOCIO_ECONOMICO
    public void saveSocioEconomico() {
        socioEconomico.setIId_titular(id);
        socioEconomico.setEscolariedade((String) this.comboEscolariedade.getSelectedItem());
        socioEconomico.setRenda_mensal_familia((String) this.comboRenda.getSelectedItem());
        socioEconomico.setProgramas_sociais((String) this.comboProgramaSocial.getSelectedItem());
        socioEconomico.setComposicao_familiar((String) this.comboComposicaoFamiliar.getSelectedItem());
        socioEconomico.setMoradia((String) this.comboMoradia.getSelectedItem());
        socioEconomico.setEstrutura_Moradia((String) this.comboEstruturaMoraria.getSelectedItem());
        socioEconomico.setQtdPessoas_Trabalhando(Integer.parseInt(txtPessoasTrabalhando.getText()));
        socioEconomico.setEmprego((String) this.comboEmprego.getSelectedItem());
        socioEconomico.setProfissao_Responsavel(txtProfissaoResponsavel.getText());
        socioEconomico.setAB_Agua((String) this.comboAgua.getSelectedItem());
        socioEconomico.setSN_basico((String) this.comboSaneamento.getSelectedItem());
        socioEconomico.setEnergia_eletrica((String) this.comboEnergia.getSelectedItem());
        socioEconomico.setLixo_Domiciliar((String) this.comboLixo.getSelectedItem());
        socioEconomico.setFrequenta_Centro((String) this.comboCentroConvivencia.getSelectedItem());

        boolean resultado = controllerSocioEconomico.controlSaveSocioEconomico(socioEconomico);
        if (resultado == true) {
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
            limparCamposSocioEconomico();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao Salvar!");
            limparCamposSocioEconomico();
        }
    }//FIM.

    //METODO SALVAR SOCIO_ECONOMICO_SAUDE
    public void saveSocioEconomicoSaude() {

        socioEconomicoSaude.setId_titular(id);
        socioEconomicoSaude.setDoenca((String) this.comboDoenca.getSelectedItem());
        socioEconomicoSaude.setOutras_Doenças(txtoutrasDoencas.getText());
        socioEconomicoSaude.setDeficiencia((String) this.comboDeficiencia.getSelectedItem());
        socioEconomicoSaude.setJustificar_deficiencia(txtjustificativaDeficiencia.getText());
        socioEconomicoSaude.setLaudo((String) this.comboLaudo.getSelectedItem());
        socioEconomicoSaude.setObservacao(txtObservação.getText());

        boolean resultado = controllerSocioEconomicoSaude.controlSaveSocioEconomico(socioEconomicoSaude);
        if (resultado == true) {//CONDIÇÃO PARA MANDAR O RESULTADO PARA O BACK-END, PARA SALVAR
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
            limparCampoSocioEconomicoSaude();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao Salvar!");
            limparCampoSocioEconomicoSaude();
        }//FIM DA CONDIÇÃO PARA SALVAR.
    }//FIM.

    public void BuscarTitularPreenchendoTable() {
        titular.setPesquisar(txtNomeClientePesquisar.getText());
        titular = titularDao.buscarTitular(titular, endereco);
        id = Integer.parseInt((String.valueOf(titular.getId())));
        txtnomeCompleto.setText((String.valueOf(titular.getNome_Completo())));
        txtnomeSocial.setText((String.valueOf(titular.getNome_Social())));
        comboCor.setSelectedItem((String.valueOf(titular.getCor_cliente())));
        txtnomeMae.setText((String.valueOf(titular.getNome_Mae())));
        txtFone.setText((String.valueOf(titular.getTelefone())));
        txtDTNascimento.setText((String.valueOf(titular.getData_Nascimento())));
        txtidade.setText((String.valueOf(titular.getIdade_cliente())));
        comboSexo.setSelectedItem((String.valueOf(titular.getGenero_cliente())));
        comboEst_Civil.setSelectedItem((String.valueOf(titular.getEstado_Civil())));
        txtRg.setText((String.valueOf(titular.getRg())));
        txtcpf.setText((String.valueOf(titular.getCpf())));
        comboStatus.setSelectedItem((String.valueOf(titular.getStatus_Cliente())));
        txtcep.setText((String.valueOf(endereco.getCep())));
        txtbairro.setText((String.valueOf(endereco.getBairro())));
        txtrua.setText((String.valueOf(endereco.getRua())));
        txtnumerocasa.setText((String.valueOf(endereco.getNumero())));
        txtreferencia.setText((String.valueOf(endereco.getReferencia())));
        combonacionalidade.setSelectedItem((String.valueOf(endereco.getNacionalidade())));
        txtnaturalidade.setText((String.valueOf(endereco.getNaturalidade())));
        txtCidade.setText((String.valueOf(endereco.getCidade())));
        txttempomoradia.setText((String.valueOf(endereco.getTempoDeMoradia_cliente())));
//        tabela_cliente("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id where nome_Completo like '%" + titular.getPesquisar() + "%'");
    }

    public void BuscarTitularDependentePreenchendoTable() {
        titular.setPesquisar(txtPesquisarNomeTitular.getText());
        titular = titularDao.buscarTitular(titular, endereco);

        id = Integer.parseInt((String.valueOf(titular.getId())));
        txtNomeClienteTitular.setText((String.valueOf(titular.getNome_Completo())));

//        tabela_cliente_dependente("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id where nome_Completo like '%" + titular.getPesquisar() + "%'");
    }

    public void BuscarTitularSocioEconomicoPreenchendoTable() {
        titular.setPesquisar(txtNomeClienteSocioEconomico.getText());
        titular = titularDao.buscarTitular(titular, endereco);
        id = Integer.parseInt((String.valueOf(titular.getId())));
        txtNomeClienteTitularSocioEconomico.setText((String.valueOf(titular.getNome_Completo())));

//        tabela_cliente_socio_economico("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id where nome_Completo like '%" + titular.getPesquisar() + "%'");
    }

    public void BuscarTitularSocioEconomicoSaudePreenchendoTable() {
        titular.setPesquisar(txtNomeClienteSocioEconomicoEconomico.getText());
        titular = titularDao.buscarTitular(titular, endereco);
        id = Integer.parseInt((String.valueOf(titular.getId())));
        txtNomeClienteTitularSocioEconomicoSaude.setText((String.valueOf(titular.getNome_Completo())));

//        tabela_cliente_socio_economico_Saude("select id_clientes, nome_cliente, cpf_cliente, rg_cliente, idade_cliente, genero from tb_clientes where nome_cliente like '%" + titular.getPesquisar() + "%'");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPaneCustom1 = new raven.tabbed.TabbedPaneCustom();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnomeCompleto = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtFone = new javax.swing.JFormattedTextField();
        jLabel36 = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        txtDTNascimento = new javax.swing.JFormattedTextField();
        txtcep = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        txtreferencia = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        btnCancelar = new button.Button();
        jLabel20 = new javax.swing.JLabel();
        combonacionalidade = new javax.swing.JComboBox<>();
        txtbairro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtidade = new javax.swing.JTextField();
        comboStatus = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnomeSocial = new javax.swing.JTextField();
        comboEst_Civil = new javax.swing.JComboBox<>();
        btnSalvar = new button.Button();
        btnNovo = new button.Button();
        jLabel21 = new javax.swing.JLabel();
        txtnaturalidade = new javax.swing.JTextField();
        txtrua = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        txtnomeMae = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtcpf = new javax.swing.JFormattedTextField();
        comboCor = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtnumerocasa = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txttempomoradia = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnBuscarCliente = new button.Button();
        txtNomeClientePesquisar = new javax.swing.JTextField();
        btnAlterar = new button.Button();
        panelBorder1 = new view.com.raven.swing.PanelBorder();
        spTableCliente = new javax.swing.JScrollPane();
        table_cliente = new view.com.raven.swing.Table2();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtPesquisarNomeTitular = new javax.swing.JTextField();
        btnBuscarClienteDependente = new javax.swing.JButton();
        spTableCliente_dependente = new javax.swing.JScrollPane();
        table_cliente_dependente = new view.com.raven.swing.Table2();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNomeClienteTitular = new javax.swing.JTextField();
        txtnomeCompletoDependente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        comboSexoDependente = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        comboParentesco = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtRgDependente = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txtcpfDependente = new javax.swing.JFormattedTextField();
        jLabel43 = new javax.swing.JLabel();
        txtIdateDependente = new javax.swing.JTextField();
        btnAlterarDependente = new button.Button();
        btnSalvarDependente = new button.Button();
        id_titular_dep = new javax.swing.JTextField();
        spTableDependentes = new javax.swing.JScrollPane();
        spTableDependente = new view.com.raven.swing.Table2();
        jPanel7 = new javax.swing.JPanel();
        txtNomeClienteSocioEconomico = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        btnBuscarClienteSocioEconomico = new javax.swing.JButton();
        spTableCliente_Socio_Economico = new javax.swing.JScrollPane();
        table_cliente_socio_Economico = new view.com.raven.swing.Table2();
        btnSalvarClienteSocioEconomico = new button.Button();
        jLabel31 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        comboCentroConvivencia = new javax.swing.JComboBox<>();
        comboEnergia = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        comboLixo = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        comboSaneamento = new javax.swing.JComboBox<>();
        txtPessoasTrabalhando = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        comboAgua = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        txtProfissaoResponsavel = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        comboEmprego = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        comboComposicaoFamiliar = new javax.swing.JComboBox<>();
        comboEscolariedade = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNomeClienteTitularSocioEconomico = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        comboMoradia = new javax.swing.JComboBox<>();
        comboRenda = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        comboEstruturaMoraria = new javax.swing.JComboBox<>();
        comboProgramaSocial = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txtNomeClienteSocioEconomicoEconomico = new javax.swing.JTextField();
        btnBuscarClienteSocioEconomicoSaude = new javax.swing.JButton();
        spTableCliente_Socio_EconomicoSaude = new javax.swing.JScrollPane();
        table_cliente_socio_EconomicoSaude = new view.com.raven.swing.Table2();
        jLabel48 = new javax.swing.JLabel();
        txtNomeClienteTitularSocioEconomicoSaude = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        comboDoenca = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        txtoutrasDoencas = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        comboDeficiencia = new javax.swing.JComboBox<>();
        comboLaudo = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        txtObservação = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtjustificativaDeficiencia = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        btnSalvarSocioEconomicoSaude = new button.Button();

        setPreferredSize(new java.awt.Dimension(1095, 697));

        tabbedPaneCustom1.setBackground(new java.awt.Color(242, 242, 242));
        tabbedPaneCustom1.setBackground(new java.awt.Color(0,0,0,50));
        tabbedPaneCustom1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabbedPaneCustom1.setSelectedColor(new java.awt.Color(48, 158, 242));
        tabbedPaneCustom1.setBackground(new java.awt.Color(0,0,0,50));
        tabbedPaneCustom1.setUnselectedColor(new java.awt.Color(186, 215, 255));

        jPanel5.setPreferredSize(new java.awt.Dimension(1095, 697));
        jPanel5.setBackground(new java.awt.Color(0,0,0,0));
        jPanel5.setToolTipText("");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome Completo:");

        txtnomeCompleto.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Telefone:");

        try {
            txtFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFone.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Sexo:");

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Data Nascimento:");

        try {
            txtDTNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDTNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDTNascimentoActionPerformed(evt);
            }
        });

        try {
            txtcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcep.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CEP:");

        txtreferencia.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Referência:");

        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Cidade:");

        txtCidade.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        btnCancelar.setBackground(new java.awt.Color(103, 103, 103));
        btnCancelar.setForeground(new java.awt.Color(245, 245, 245));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nacionalidade:");

        combonacionalidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brasil", "Argentina", "Bolívia", "Chile", "Colômbia", "Costa Rica", "Equador", "El Salvador", "Guatemala", "Haiti", "Honduras", "México", "Nicarágua", "Panamá", "Paraguai", "Peru", "República Dominicana", "Uruguai", "Venezuela" }));

        txtbairro.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Bairro:");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Idade:");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO" }));
        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Status:");

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Estado Civil:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nome Social:");

        txtnomeSocial.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        comboEst_Civil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado (a)", "Solteiro (a)", "União Estável", "Viúvo (a)", "Separado, divorciado" }));

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

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Naturalidade:");

        txtnaturalidade.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        txtrua.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Rua:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("RG:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome da Mãe:");

        txtRg.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        txtnomeMae.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CPF:");

        try {
            txtcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcpf.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        comboCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Branco", "Pardo", "Negro", "Outros" }));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("COR:");

        txtnumerocasa.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Tempo de moradia:");

        txttempomoradia.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nº:");

        btnBuscarCliente.setText("Pesquisar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        txtNomeClientePesquisar.setDisabledTextColor(new java.awt.Color(187, 187, 187));
        txtNomeClientePesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClientePesquisarActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(246, 159, 50));
        btnAlterar.setForeground(new java.awt.Color(245, 245, 245));
        btnAlterar.setText("Aterar");
        btnAlterar.setRippleColor(new java.awt.Color(255, 255, 255));
        btnAlterar.setShadowColor(new java.awt.Color(246, 159, 50));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setForeground(new java.awt.Color(204, 204, 204));

        spTableCliente.setBorder(null);

        table_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "RG", "CPF", "DT NASCIMENTO", "TELEFONE", "ESTADO CIVIL", "STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_cliente.getTableHeader().setReorderingAllowed(false);
        table_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_clienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_clienteMousePressed(evt);
            }
        });
        spTableCliente.setViewportView(table_cliente);
        if (table_cliente.getColumnModel().getColumnCount() > 0) {
            table_cliente.getColumnModel().getColumn(0).setResizable(false);
            table_cliente.getColumnModel().getColumn(1).setResizable(false);
            table_cliente.getColumnModel().getColumn(2).setResizable(false);
            table_cliente.getColumnModel().getColumn(3).setResizable(false);
            table_cliente.getColumnModel().getColumn(4).setResizable(false);
            table_cliente.getColumnModel().getColumn(5).setResizable(false);
            table_cliente.getColumnModel().getColumn(6).setResizable(false);
            table_cliente.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(spTableCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(spTableCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(958, 958, 958))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(combonacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtnomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtnomeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(17, 17, 17)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(comboEst_Civil, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtidade, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel2)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)))
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtnaturalidade, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtrua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txttempomoradia))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboCor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtnumerocasa, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcpf))))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtDTNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(100, 100, 100))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtNomeClientePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnomeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFone)
                            .addComponent(jLabel38)
                            .addComponent(comboEst_Civil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSexo, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDTNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtnumerocasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combonacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttempomoradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeClientePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );

        tabbedPaneCustom1.addTab("Cliente", jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(1095, 697));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome Completo:");

        txtPesquisarNomeTitular.setDisabledTextColor(new java.awt.Color(187, 187, 187));
        txtPesquisarNomeTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarNomeTitularActionPerformed(evt);
            }
        });

        btnBuscarClienteDependente.setText("PESQUISAR");
        btnBuscarClienteDependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteDependenteActionPerformed(evt);
            }
        });

        spTableCliente_dependente.setBorder(null);

        table_cliente_dependente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "RG", "CPF", "DT NASCIMENTO", "TELEFONE", "ESTADO CIVIL", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_cliente_dependente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cliente_dependenteMouseClicked(evt);
            }
        });
        spTableCliente_dependente.setViewportView(table_cliente_dependente);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ADICIONAR DEPENDENTE");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Titular:");

        txtNomeClienteTitular.setEditable(false);
        txtNomeClienteTitular.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        txtnomeCompletoDependente.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nome Completo:");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Sexo:");

        comboSexoDependente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Dependencia:");

        comboParentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CÔNJUGE", "UNIÃO ESTÁVEL", "FILHO/ENTEADO", "IRMÃO", "AVÓ", "INCAPAZ", "AGREGADO" }));
        comboParentesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboParentescoActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("RG:");

        try {
            txtRgDependente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRgDependente.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CPF:");

        try {
            txtcpfDependente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcpfDependente.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Idade:");

        btnAlterarDependente.setBackground(new java.awt.Color(246, 159, 50));
        btnAlterarDependente.setForeground(new java.awt.Color(245, 245, 245));
        btnAlterarDependente.setText("Alterar");
        btnAlterarDependente.setRippleColor(new java.awt.Color(255, 255, 255));
        btnAlterarDependente.setShadowColor(new java.awt.Color(30, 180, 114));
        btnAlterarDependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDependenteActionPerformed(evt);
            }
        });

        btnSalvarDependente.setBackground(new java.awt.Color(30, 180, 114));
        btnSalvarDependente.setForeground(new java.awt.Color(245, 245, 245));
        btnSalvarDependente.setText("Salvar");
        btnSalvarDependente.setRippleColor(new java.awt.Color(255, 255, 255));
        btnSalvarDependente.setShadowColor(new java.awt.Color(30, 180, 114));
        btnSalvarDependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDependenteActionPerformed(evt);
            }
        });

        spTableDependentes.setBorder(null);

        spTableDependente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "RG", "CPF", "IDADE", "GENERO", "DEPENDENTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTableDependente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spTableDependenteMouseClicked(evt);
            }
        });
        spTableDependentes.setViewportView(spTableDependente);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnAlterarDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvarDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(id_titular_dep, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPesquisarNomeTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscarClienteDependente))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNomeClienteTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(spTableCliente_dependente)
                        .addComponent(spTableDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(txtnomeCompletoDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRgDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtcpfDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel43)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtIdateDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(comboSexoDependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel42)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(comboParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(40, 40, 40))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisarNomeTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarClienteDependente)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTableCliente_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeClienteTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnomeCompletoDependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRgDependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtcpfDependente)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdateDependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboSexoDependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarDependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarDependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_titular_dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(spTableDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPaneCustom1.addTab("Dependentes", jPanel6);

        jPanel7.setPreferredSize(new java.awt.Dimension(1095, 697));

        txtNomeClienteSocioEconomico.setDisabledTextColor(new java.awt.Color(187, 187, 187));
        txtNomeClienteSocioEconomico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteSocioEconomicoActionPerformed(evt);
            }
        });

        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Nome Completo:");

        btnBuscarClienteSocioEconomico.setText("PESQUISAR");
        btnBuscarClienteSocioEconomico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteSocioEconomicoActionPerformed(evt);
            }
        });

        spTableCliente_Socio_Economico.setBorder(null);

        table_cliente_socio_Economico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "RG", "CPF", "DT NASCIMENTO", "TELEFONE", "ESTADO CIVIL", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_cliente_socio_Economico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cliente_socio_EconomicoMouseClicked(evt);
            }
        });
        spTableCliente_Socio_Economico.setViewportView(table_cliente_socio_Economico);

        btnSalvarClienteSocioEconomico.setBackground(new java.awt.Color(30, 180, 114));
        btnSalvarClienteSocioEconomico.setForeground(new java.awt.Color(245, 245, 245));
        btnSalvarClienteSocioEconomico.setText("Salvar");
        btnSalvarClienteSocioEconomico.setRippleColor(new java.awt.Color(255, 255, 255));
        btnSalvarClienteSocioEconomico.setShadowColor(new java.awt.Color(30, 180, 114));
        btnSalvarClienteSocioEconomico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarClienteSocioEconomicoActionPerformed(evt);
            }
        });

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Energia Elétrica ?");

        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Frequenta Centro de Convivencia ?");
        jLabel41.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        comboCentroConvivencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NÃO" }));

        comboEnergia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NÃO" }));

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Lixo Domiciliar / Coleta ?");

        comboLixo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NÃO" }));

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Saneamento Básico ?");

        comboSaneamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NÃO" }));

        txtPessoasTrabalhando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPessoasTrabalhandoActionPerformed(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Água Encanada ?");

        comboAgua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NÃO", "POÇO" }));

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Nº Pessoas trabalham:");

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Profissão:");

        comboEmprego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CLT", "CONTRATO", "EMPREGADO", "DESEMPREGADO", "AUTÔNOMO" }));

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Emprego:");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Composição Familiar:");

        comboComposicaoFamiliar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MORA SOZINHO", "1 A 3 PESSOAS", "4 A 7 PESSOAS", "8 A 10 PESSOAS", "ACIMA DE 10 PESSOAS" }));

        comboEscolariedade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ANALFABETO", "ENSINO FUNDAMENTAL - COMPLETO", "ENSINO FUNDAMENTAL - INCOMPLETO", "ENSINO MÉDIO - COMPLETO", "ENSINO MÉDIO - INCOMPLETO", "NIVEL SUPERIOR" }));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Escolariedade:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nome:");

        txtNomeClienteTitularSocioEconomico.setEditable(false);
        txtNomeClienteTitularSocioEconomico.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Renda Mensal:");

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Moradia:");

        comboMoradia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRÓPRIA", "ALUGADA", "CEDIDA", "OCUPADA" }));

        comboRenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 A 89,00", "89,01 A 178,00", "178,01 A MEIO SALÁRIO", "RENDA DE 1 SALÁRIO", "RENDA DE 1 A 2  SALÁRIOS", "RENDA DE 2 A 3  SALÁRIOS" }));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Programas Sociais:");

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Estrutura Moradia:");

        comboEstruturaMoraria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALVENARIA", "MADEIRA", "MISTA" }));

        comboProgramaSocial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOLSA FÁMILIA", "AUXÍLIO DOENÇA", "SEGURO DESEMPREGO", "CADASTRO ÚNICO DO GOVERNO FEDERAL", "BPC / IDOSO", "BPC / PCD", "APOSENTADO(A) / INSS", "PENSIONISTA / INSS", "NÃO PARTIPA DE NENHUM PROGRAMA SOCIAL" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeClienteSocioEconomico, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarClienteSocioEconomico))
                            .addComponent(spTableCliente_Socio_Economico, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboEscolariedade, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboComposicaoFamiliar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboEmprego, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEnergia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeClienteTitularSocioEconomico))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCentroConvivencia, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(18, 18, 18)
                                .addComponent(comboLixo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProfissaoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboRenda, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboEstruturaMoraria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboProgramaSocial, 0, 307, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSaneamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(137, 137, 137))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPessoasTrabalhando, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnSalvarClienteSocioEconomico, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(963, 963, 963)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeClienteSocioEconomico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarClienteSocioEconomico)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTableCliente_Socio_Economico, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeClienteTitularSocioEconomico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEscolariedade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(comboRenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(comboProgramaSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboComposicaoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29)
                        .addComponent(comboMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34)
                        .addComponent(comboEstruturaMoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPessoasTrabalhando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProfissaoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboEmprego)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboLixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboSaneamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboCentroConvivencia)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvarClienteSocioEconomico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPaneCustom1.addTab("Socio Econômico", jPanel7);

        jPanel8.setPreferredSize(new java.awt.Dimension(1095, 697));

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Nome Completo:");

        txtNomeClienteSocioEconomicoEconomico.setDisabledTextColor(new java.awt.Color(187, 187, 187));
        txtNomeClienteSocioEconomicoEconomico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteSocioEconomicoEconomicoActionPerformed(evt);
            }
        });

        btnBuscarClienteSocioEconomicoSaude.setText("PESQUISAR");
        btnBuscarClienteSocioEconomicoSaude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteSocioEconomicoSaudeActionPerformed(evt);
            }
        });

        spTableCliente_Socio_EconomicoSaude.setBorder(null);

        table_cliente_socio_EconomicoSaude.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_cliente_socio_EconomicoSaude.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cliente_socio_EconomicoSaudeMouseClicked(evt);
            }
        });
        spTableCliente_Socio_EconomicoSaude.setViewportView(table_cliente_socio_EconomicoSaude);

        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Nome:");

        txtNomeClienteTitularSocioEconomicoSaude.setEditable(false);
        txtNomeClienteTitularSocioEconomicoSaude.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Possui Alguma Doença?");

        comboDoenca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NÃO", "SIM" }));
        comboDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDoencaActionPerformed(evt);
            }
        });

        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Outras Doenças?");

        txtoutrasDoencas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtoutrasDoencasActionPerformed(evt);
            }
        });

        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Deficiencia?");

        comboDeficiencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NÃO", "SIM" }));
        comboDeficiencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDeficienciaItemStateChanged(evt);
            }
        });
        comboDeficiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDeficienciaActionPerformed(evt);
            }
        });

        comboLaudo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NÃO", "SIM" }));
        comboLaudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLaudoActionPerformed(evt);
            }
        });

        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Observação:");

        txtObservação.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservaçãoActionPerformed(evt);
            }
        });

        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Possui Laudo?");

        txtjustificativaDeficiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjustificativaDeficienciaActionPerformed(evt);
            }
        });

        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Justificativa Deficiencia:");

        btnSalvarSocioEconomicoSaude.setBackground(new java.awt.Color(30, 180, 114));
        btnSalvarSocioEconomicoSaude.setForeground(new java.awt.Color(245, 245, 245));
        btnSalvarSocioEconomicoSaude.setText("Salvar");
        btnSalvarSocioEconomicoSaude.setRippleColor(new java.awt.Color(255, 255, 255));
        btnSalvarSocioEconomicoSaude.setShadowColor(new java.awt.Color(30, 180, 114));
        btnSalvarSocioEconomicoSaude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarSocioEconomicoSaudeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeClienteTitularSocioEconomicoSaude))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtjustificativaDeficiencia)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtoutrasDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboLaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObservação, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeClienteSocioEconomicoEconomico, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarClienteSocioEconomicoSaude))
                    .addComponent(btnSalvarSocioEconomicoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spTableCliente_Socio_EconomicoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(149, 149, 149))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeClienteSocioEconomicoEconomico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarClienteSocioEconomicoSaude)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTableCliente_Socio_EconomicoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeClienteTitularSocioEconomicoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtoutrasDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjustificativaDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboLaudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObservação, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvarSocioEconomicoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.addTab("Socio Econômico Saúde", jPanel8);

        tabbedPaneCustom1.setBackground(new java.awt.Color(0,0,0,50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.setBackground(new java.awt.Color(0,0,0,50));
    }// </editor-fold>//GEN-END:initComponents

    private void comboParentescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboParentescoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboParentescoActionPerformed

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStatusActionPerformed

    private void table_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_clienteMouseClicked
//        btnNovo.setEnabled(false);
//        btnAlterar.setEnabled(true);
//        btnCancelar.setEnabled(true);
//        String nome = "" + table_cliente.getValueAt(table_cliente.getSelectedRow(), 1);
//        con.getConectar();
//
//        con.executarSql("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
//                + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
//                + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
//                + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id where nome_Completo ='" + nome + "'");
//
//        try {
//            con.getResultSet().first();
//            id = Integer.parseInt(con.getResultSet().getString("id"));
//            txtnomeCompleto.setText(con.getResultSet().getString("nome_Completo"));
//            txtnomeSocial.setText(con.getResultSet().getString("nome_Social"));
//            comboCor.setSelectedItem(con.getResultSet().getString("cor_cliente"));
//            txtnomeMae.setText(con.getResultSet().getString("nome_Mae"));
//            txtFone.setText(con.getResultSet().getString("telefone"));
//            txtDTNascimento.setText(con.getResultSet().getString("data_Nascimento"));
//            txtidade.setText(con.getResultSet().getString("idade_cliente"));
//            comboSexo.setSelectedItem(con.getResultSet().getString("genero_cliente"));
//            comboEst_Civil.setSelectedItem(con.getResultSet().getString("estado_Civil"));
//            txtRg.setText(con.getResultSet().getString("rg"));
//            txtcpf.setText(con.getResultSet().getString("cpf"));
//            comboStatus.setSelectedItem(con.getResultSet().getString("status_Cliente"));
//            txtcep.setText(con.getResultSet().getString("cep"));
//            txtbairro.setText(con.getResultSet().getString("bairro"));
//            txtrua.setText(con.getResultSet().getString("rua"));
//            txtnumerocasa.setText(con.getResultSet().getString("numero"));
//            txtreferencia.setText(con.getResultSet().getString("referencia"));
//            combonacionalidade.setSelectedItem(con.getResultSet().getString("nacionalidade"));
//            txtnaturalidade.setText(con.getResultSet().getString("naturalidade"));
//            txtCidade.setText(con.getResultSet().getString("cidade"));
//            txttempomoradia.setText(con.getResultSet().getString("tempoDeMoradia_cliente"));
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro no ao selecionar os dados" + ex);
//        }

        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(true);
        btnCancelar.setEnabled(true);
        String nome = "" + table_cliente.getValueAt(table_cliente.getSelectedRow(), 1);
        con.getConectar();

        con.executarSql("SELECT * FROM tb_clientes where nome_cliente ='" + nome + "'");

        try {
            con.getResultSet().first();
            id_cliente = Integer.parseInt(con.getResultSet().getString("id_clientes"));
            txtnomeCompleto.setText(con.getResultSet().getString("nome_cliente"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no ao selecionar cliente" + ex);
        }
    }//GEN-LAST:event_table_clienteMouseClicked

    private void table_cliente_dependenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cliente_dependenteMouseClicked
        String nome = "" + table_cliente_dependente.getValueAt(table_cliente_dependente.getSelectedRow(), 1);
        con.getConectar();

        con.executarSql("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
                + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
                + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
                + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id where nome_Completo ='" + nome + "'");
        try {
            con.getResultSet().first();
            id = Integer.parseInt(con.getResultSet().getString("id"));
            txtNomeClienteTitular.setText(con.getResultSet().getString("nome_Completo"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no ao selecionar os dados" + ex);
        }
    }//GEN-LAST:event_table_cliente_dependenteMouseClicked

    private void spTableDependenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spTableDependenteMouseClicked
        String nome = "" + spTableDependente.getValueAt(spTableDependente.getSelectedRow(), 1);
        con.getConectar();
        con.executarSql("select t.id, t.nome_Completo, d.id, d.id_titular, d.nome_dependente, d.rg, d.cpf, d.Idade, d.genero, d.dependencia_cliente from tb_titular t inner join tb_dependentes d on d.id_titular = t.id where nome_dependente ='" + nome + "'");
        try {
            con.getResultSet().first();
            id_dependente = Integer.parseInt(con.getResultSet().getString("d.id"));
            id_titular = Integer.parseInt(con.getResultSet().getString("t.id"));
            txtNomeClienteTitular.setText(con.getResultSet().getString("nome_Completo"));
            txtnomeCompletoDependente.setText(con.getResultSet().getString("nome_dependente"));
            txtRgDependente.setText(con.getResultSet().getString("rg"));
            txtcpfDependente.setText(con.getResultSet().getString("cpf"));
            txtIdateDependente.setText(con.getResultSet().getString("Idade"));
            comboSexoDependente.setSelectedItem(con.getResultSet().getString("genero"));
            comboParentesco.setSelectedItem(con.getResultSet().getString("dependencia_cliente"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dependente não cadastrado" + ex);
        }
    }//GEN-LAST:event_spTableDependenteMouseClicked

    private void txtPessoasTrabalhandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPessoasTrabalhandoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPessoasTrabalhandoActionPerformed

    private void table_cliente_socio_EconomicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cliente_socio_EconomicoMouseClicked
        String nome = "" + table_cliente_socio_Economico.getValueAt(table_cliente_socio_Economico.getSelectedRow(), 1);
        con.getConectar();

        con.executarSql("select c.id, c.nome_Completo, c.nome_Social, c.cor_cliente, c.nome_Mae, c.telefone, \n"
                + "		c.data_Nascimento, c.idade_cliente, c.genero_cliente, c.estado_Civil, c.rg, c.cpf, c.status_Cliente, \n"
                + "		e.id, e.cep, e.bairro, e.rua, e.numero, e.referencia, e.nacionalidade, e.naturalidade, e.cidade, e.tempoDeMoradia_cliente\n"
                + "	from tb_titular c inner join tb_endereco e on c.id_endereco = e.id where nome_Completo ='" + nome + "'");
        try {
            con.getResultSet().first();
            id = Integer.parseInt(con.getResultSet().getString("id"));
            txtNomeClienteTitularSocioEconomico.setText(con.getResultSet().getString("nome_Completo"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no ao selecionar os dados" + ex);
        }
    }//GEN-LAST:event_table_cliente_socio_EconomicoMouseClicked

    private void table_cliente_socio_EconomicoSaudeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cliente_socio_EconomicoSaudeMouseClicked
        String nome = "" + table_cliente_socio_EconomicoSaude.getValueAt(table_cliente_socio_EconomicoSaude.getSelectedRow(), 1);
        con.getConectar();

        con.executarSql("select id_clientes, nome_cliente, cpf_cliente, rg_cliente, idade_cliente, genero from tb_clientes where nome_cliente ='" + nome + "'");
        try {
            con.getResultSet().first();
            id = Integer.parseInt(con.getResultSet().getString("id_clientes"));
            txtNomeClienteTitularSocioEconomicoSaude.setText(con.getResultSet().getString("nome_cliente"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no ao selecionar os dados" + ex);
        }
    }//GEN-LAST:event_table_cliente_socio_EconomicoSaudeMouseClicked

    private void comboDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDoencaActionPerformed
    }//GEN-LAST:event_comboDoencaActionPerformed

    private void txtoutrasDoencasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtoutrasDoencasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtoutrasDoencasActionPerformed

    private void comboDeficienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDeficienciaActionPerformed

    }//GEN-LAST:event_comboDeficienciaActionPerformed

    private void txtjustificativaDeficienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjustificativaDeficienciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjustificativaDeficienciaActionPerformed

    private void comboLaudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLaudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboLaudoActionPerformed

    private void txtObservaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservaçãoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservaçãoActionPerformed

    private void comboDeficienciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDeficienciaItemStateChanged

    }//GEN-LAST:event_comboDeficienciaItemStateChanged

    private void txtDTNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDTNascimentoActionPerformed

    }//GEN-LAST:event_txtDTNascimentoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        flag = 1;
        habilitarCampos();
        habilitarBotao();
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (flag == 1) {
            validarCamposTitular();
            saveClientes();
        } else {
            updateClientes();
        };
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        flag = 2;
        habilitarCampos();
        habilitarBotao();
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        desabilitarBotao();
        desabilitarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        BuscarTitularPreenchendoTable();
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnSalvarDependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDependenteActionPerformed
        validarCamposDependentes();
        saveDependentes();
    }//GEN-LAST:event_btnSalvarDependenteActionPerformed

    private void btnSalvarClienteSocioEconomicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarClienteSocioEconomicoActionPerformed
        validarCamposSocioEconomico();
        saveSocioEconomico();
    }//GEN-LAST:event_btnSalvarClienteSocioEconomicoActionPerformed

    private void btnSalvarSocioEconomicoSaudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarSocioEconomicoSaudeActionPerformed
        validarCamposSocioEconomicoSaude();
        saveSocioEconomicoSaude();
    }//GEN-LAST:event_btnSalvarSocioEconomicoSaudeActionPerformed

    private void txtNomeClientePesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClientePesquisarActionPerformed
        btnBuscarClienteActionPerformed(evt);
    }//GEN-LAST:event_txtNomeClientePesquisarActionPerformed

    private void btnBuscarClienteDependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteDependenteActionPerformed
        BuscarTitularDependentePreenchendoTable();
    }//GEN-LAST:event_btnBuscarClienteDependenteActionPerformed

    private void txtPesquisarNomeTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarNomeTitularActionPerformed
        btnBuscarClienteDependenteActionPerformed(evt);
    }//GEN-LAST:event_txtPesquisarNomeTitularActionPerformed

    private void btnBuscarClienteSocioEconomicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteSocioEconomicoActionPerformed
        BuscarTitularSocioEconomicoPreenchendoTable();
    }//GEN-LAST:event_btnBuscarClienteSocioEconomicoActionPerformed

    private void btnBuscarClienteSocioEconomicoSaudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteSocioEconomicoSaudeActionPerformed
        BuscarTitularSocioEconomicoSaudePreenchendoTable();
    }//GEN-LAST:event_btnBuscarClienteSocioEconomicoSaudeActionPerformed

    private void txtNomeClienteSocioEconomicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteSocioEconomicoActionPerformed
        btnBuscarClienteSocioEconomicoActionPerformed(evt);
    }//GEN-LAST:event_txtNomeClienteSocioEconomicoActionPerformed

    private void txtNomeClienteSocioEconomicoEconomicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteSocioEconomicoEconomicoActionPerformed
        btnBuscarClienteSocioEconomicoSaudeActionPerformed(evt);
    }//GEN-LAST:event_txtNomeClienteSocioEconomicoEconomicoActionPerformed

    private void btnAlterarDependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDependenteActionPerformed

        dependentes.setId(this.id_dependente);
        dependentes.setId_titular(this.id_titular);
        dependentes.setNome_Completo(this.txtnomeCompletoDependente.getText());
        dependentes.setRg(this.txtRgDependente.getText());
        dependentes.setCpf(this.txtcpfDependente.getText());
        dependentes.setIdade_cliente(Integer.parseInt(this.txtIdateDependente.getText()));
        dependentes.setGenero_cliente((String) this.comboSexoDependente.getSelectedItem());
        dependentes.setDependencia_cliente((String) this.comboParentesco.getSelectedItem());
        controllerDependetes.controlUpdateDependente(dependentes);

        limparCamposDependentes();
//        tabela_dependente();
    }//GEN-LAST:event_btnAlterarDependenteActionPerformed

    private void table_clienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_clienteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_table_clienteMousePressed

    @Override
    protected void paintChildren(Graphics grphcs
    ) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button btnAlterar;
    private button.Button btnAlterarDependente;
    private button.Button btnBuscarCliente;
    private javax.swing.JButton btnBuscarClienteDependente;
    private javax.swing.JButton btnBuscarClienteSocioEconomico;
    private javax.swing.JButton btnBuscarClienteSocioEconomicoSaude;
    private button.Button btnCancelar;
    private button.Button btnNovo;
    private button.Button btnSalvar;
    private button.Button btnSalvarClienteSocioEconomico;
    private button.Button btnSalvarDependente;
    private button.Button btnSalvarSocioEconomicoSaude;
    private javax.swing.JComboBox<String> comboAgua;
    private javax.swing.JComboBox<String> comboCentroConvivencia;
    private javax.swing.JComboBox<String> comboComposicaoFamiliar;
    private javax.swing.JComboBox<String> comboCor;
    private javax.swing.JComboBox<String> comboDeficiencia;
    private javax.swing.JComboBox<String> comboDoenca;
    private javax.swing.JComboBox<String> comboEmprego;
    private javax.swing.JComboBox<String> comboEnergia;
    private javax.swing.JComboBox<String> comboEscolariedade;
    private javax.swing.JComboBox<String> comboEst_Civil;
    private javax.swing.JComboBox<String> comboEstruturaMoraria;
    private javax.swing.JComboBox<String> comboLaudo;
    private javax.swing.JComboBox<String> comboLixo;
    private javax.swing.JComboBox<String> comboMoradia;
    private javax.swing.JComboBox<String> comboParentesco;
    private javax.swing.JComboBox<String> comboProgramaSocial;
    private javax.swing.JComboBox<String> comboRenda;
    private javax.swing.JComboBox<String> comboSaneamento;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JComboBox<String> comboSexoDependente;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JComboBox<String> combonacionalidade;
    private javax.swing.JTextField id_titular_dep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private view.com.raven.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTableCliente;
    private javax.swing.JScrollPane spTableCliente_Socio_Economico;
    private javax.swing.JScrollPane spTableCliente_Socio_EconomicoSaude;
    private javax.swing.JScrollPane spTableCliente_dependente;
    private view.com.raven.swing.Table2 spTableDependente;
    private javax.swing.JScrollPane spTableDependentes;
    private raven.tabbed.TabbedPaneCustom tabbedPaneCustom1;
    private view.com.raven.swing.Table2 table_cliente;
    private view.com.raven.swing.Table2 table_cliente_dependente;
    private view.com.raven.swing.Table2 table_cliente_socio_Economico;
    private view.com.raven.swing.Table2 table_cliente_socio_EconomicoSaude;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtDTNascimento;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtIdateDependente;
    private javax.swing.JTextField txtNomeClientePesquisar;
    private javax.swing.JTextField txtNomeClienteSocioEconomico;
    private javax.swing.JTextField txtNomeClienteSocioEconomicoEconomico;
    private javax.swing.JTextField txtNomeClienteTitular;
    private javax.swing.JTextField txtNomeClienteTitularSocioEconomico;
    private javax.swing.JTextField txtNomeClienteTitularSocioEconomicoSaude;
    private javax.swing.JTextField txtObservação;
    private javax.swing.JTextField txtPesquisarNomeTitular;
    private javax.swing.JTextField txtPessoasTrabalhando;
    private javax.swing.JTextField txtProfissaoResponsavel;
    private javax.swing.JTextField txtRg;
    private javax.swing.JFormattedTextField txtRgDependente;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JFormattedTextField txtcpf;
    private javax.swing.JFormattedTextField txtcpfDependente;
    private javax.swing.JTextField txtidade;
    private javax.swing.JTextField txtjustificativaDeficiencia;
    private javax.swing.JTextField txtnaturalidade;
    private javax.swing.JTextField txtnomeCompleto;
    private javax.swing.JTextField txtnomeCompletoDependente;
    private javax.swing.JTextField txtnomeMae;
    private javax.swing.JTextField txtnomeSocial;
    private javax.swing.JTextField txtnumerocasa;
    private javax.swing.JTextField txtoutrasDoencas;
    private javax.swing.JTextField txtreferencia;
    private javax.swing.JTextField txtrua;
    private javax.swing.JTextField txttempomoradia;
    // End of variables declaration//GEN-END:variables
}
