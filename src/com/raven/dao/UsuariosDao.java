package com.raven.dao;

import com.raven.banco.ConexaoBD;
import com.raven.model.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
//    public boolean daoUpdateUsuarios(Usuarios usuarios){
//    
//        
//    }
    
    
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
}
