package com.raven.model;

public class Senha {

    private int id;
    private String cliente;
    private String Genero;
    private String Idade;
    private String tipoSenha;
    private String data_refeicao;

    public Senha() {
    }

    public Senha(int id, String cliente, String Genero, String Idade, String tipoSenha, String data_refeicao) {
        this.id = id;
        this.cliente = cliente;
        this.Genero = Genero;
        this.Idade = Idade;
        this.tipoSenha = tipoSenha;
        this.data_refeicao = data_refeicao;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the Genero
     */
    public String getGenero() {
        return Genero;
    }

    /**
     * @param Genero the Genero to set
     */
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    /**
     * @return the Idade
     */
    public String getIdade() {
        return Idade;
    }

    /**
     * @param Idade the Idade to set
     */
    public void setIdade(String Idade) {
        this.Idade = Idade;
    }

    /**
     * @return the tipoSenha
     */
    public String getTipoSenha() {
        return tipoSenha;
    }

    /**
     * @param tipoSenha the tipoSenha to set
     */
    public void setTipoSenha(String tipoSenha) {
        this.tipoSenha = tipoSenha;
    }

    /**
     * @return the data_refeicao
     */
    public String getData_refeicao() {
        return data_refeicao;
    }

    /**
     * @param data_refeicao the data_refeicao to set
     */
    public void setData_refeicao(String data_refeicao) {
        this.data_refeicao = data_refeicao;
    }
}
