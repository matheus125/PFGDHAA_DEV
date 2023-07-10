package com.raven.dao;

import com.raven.banco.ConexaoBD;
import com.raven.model.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuariosDao extends ConexaoBD {

    //METODO PARA SALVAR TITULAR
    public boolean daoSalvarUsuario(Usuarios usuarios) {

        this.getConectar();
        try {
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO admins (nome_admin, cpf_admin, email_admin, senha_admin, telefone_admin, cargo_admin)"
                    + "VALUES (?,?,?,?,?,?)");
            ps.setString(1, usuarios.getNome_admin());
            ps.setString(2, usuarios.getCpf_admin());
            ps.setString(3, usuarios.getEmail_admin());
            ps.setString(4, usuarios.getSenha_admin());
            ps.setString(5, usuarios.getTelefone_admin());
            ps.setString(6, usuarios.getCargo_admin());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar!" + erro);
        } finally {
            this.getfecharConexao();
        }
        return false;
    }//FIM.

    public boolean daoUpdateUsuarios(Usuarios usuarios) {
        this.getConectar();
        try {
            PreparedStatement ps = this.con.prepareStatement("UPDATE admins SET  nome_admin=?, email_admin=?, senha_admin=?, telefone_admin=?, cargo_admin=? WHERE cpf_admin=?");
            ps.setString(1, usuarios.getNome_admin());
            ps.setString(2, usuarios.getEmail_admin());
            ps.setString(3, usuarios.getSenha_admin());
            ps.setString(4, usuarios.getTelefone_admin());
            ps.setString(5, usuarios.getCargo_admin());
            ps.setString(6, usuarios.getCpf_admin());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro em Alterar!" + erro);
        } finally {
            this.getfecharConexao();
        }
        return false;
    }

    //METODO PARA VERIFICAR SE JÁ EXISTE CPF CADASTRADO
    public boolean daoVerificarCPFexistente(String cpf_admin) {

        int contador = 0;
        this.getConectar();
        try {
            this.executarSql("select * from admins where cpf_admin='" + cpf_admin + "'");
            while (this.getResultSet().next()) {
                contador = 1;
            }
            return contador == 1;
        } catch (SQLException e) {
            return false;
        }
    }//FIM.

    public void daoDeleteUsuario(Usuarios usuarios) {
        this.getConectar();

        try {
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM admins WHERE cpf_admin=?");
            ps.setString(1, usuarios.getCpf_admin());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        this.getfecharConexao();
    }

    //METODO PARA PESQUISAR FUNCIONARIOS POR NOME
    public Usuarios buscarFuncionarios(Usuarios usuarios) {
        this.getConectar();
        this.executarSql("SELECT * FROM admins WHERE nome_admin like '%" + usuarios.getPesquisar() + "%'");
        try {
            this.getResultSet().first();
            usuarios.setNome_admin(this.getResultSet().getString("nome_admin"));
            usuarios.setCpf_admin(this.getResultSet().getString("cpf_admin"));
            usuarios.setEmail_admin(this.getResultSet().getString("email_admin"));
            usuarios.setSenha_admin(this.getResultSet().getString("senha_admin"));
            usuarios.setTelefone_admin(this.getResultSet().getString("telefone_admin"));
            usuarios.setCargo_admin(this.getResultSet().getString("cargo_admin"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Funcionário não cadastrado!");
        }
        this.getfecharConexao();
        return usuarios;
    }
}
