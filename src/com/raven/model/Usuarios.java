package com.raven.model;

public class Usuarios {

    private String nome_admin;
    private String cpf_admin;
    private String email_admin;
    private String senha_admin;
    private String telefone_admin;
    private String cargo_admin;
    private String pesquisar;

    public Usuarios() {
    }

    public Usuarios(String nome_admin, String cpf_admin, String email_admin, String senha_admin, String telefone_admin, String cargo_admin, String pesquisar) {
        this.nome_admin = nome_admin;
        this.cpf_admin = cpf_admin;
        this.email_admin = email_admin;
        this.senha_admin = senha_admin;
        this.telefone_admin = telefone_admin;
        this.cargo_admin = cargo_admin;
        this.pesquisar = pesquisar;
    }
    /**
     * @return the nome_admin
     */
    public String getNome_admin() {
        return nome_admin;
    }

    /**
     * @param nome_admin the nome_admin to set
     */
    public void setNome_admin(String nome_admin) {
        this.nome_admin = nome_admin;
    }

    /**
     * @return the cpf_admin
     */
    public String getCpf_admin() {
        return cpf_admin;
    }

    /**
     * @param cpf_admin the cpf_admin to set
     */
    public void setCpf_admin(String cpf_admin) {
        this.cpf_admin = cpf_admin;
    }

    /**
     * @return the email_admin
     */
    public String getEmail_admin() {
        return email_admin;
    }

    /**
     * @param email_admin the email_admin to set
     */
    public void setEmail_admin(String email_admin) {
        this.email_admin = email_admin;
    }

    /**
     * @return the senha_admin
     */
    public String getSenha_admin() {
        return senha_admin;
    }

    /**
     * @param senha_admin the senha_admin to set
     */
    public void setSenha_admin(String senha_admin) {
        this.senha_admin = senha_admin;
    }

    /**
     * @return the telefone_admin
     */
    public String getTelefone_admin() {
        return telefone_admin;
    }

    /**
     * @param telefone_admin the telefone_admin to set
     */
    public void setTelefone_admin(String telefone_admin) {
        this.telefone_admin = telefone_admin;
    }

    /**
     * @return the cargo_admin
     */
    public String getCargo_admin() {
        return cargo_admin;
    }

    /**
     * @param cargo_admin the cargo_admin to set
     */
    public void setCargo_admin(String cargo_admin) {
        this.cargo_admin = cargo_admin;
    }

    /**
     * @return the pesquisar
     */
    public String getPesquisar() {
        return pesquisar;
    }

    /**
     * @param pesquisar the pesquisar to set
     */
    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }
}
