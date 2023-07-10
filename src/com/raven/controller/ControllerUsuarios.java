package com.raven.controller;

import com.raven.dao.UsuariosDao;
import com.raven.model.Usuarios;

public class ControllerUsuarios {

    UsuariosDao usuariosDao = new UsuariosDao();

    //Salvar Usuarios
    public boolean controllerSaveClientes(Usuarios usuarios) {
        return this.usuariosDao.daoSalvarUsuario(usuarios);
    }
    
     //Update Usuarios
    public boolean controllerUpdateClientes(Usuarios usuarios) {
        return this.usuariosDao.daoUpdateUsuarios(usuarios);
    }
    
    //verifica login existente cadastrador no banco
    public boolean controlGetFuncionario(String cpf_admin) {
        return this.usuariosDao.daoVerificarCPFexistente(cpf_admin);
    }
}
