package com.raven.model;

public class Dependentes extends Titular {

    private int id;
    private int id_titular;
    private String dependencia_cliente;

    public Dependentes() {
    }

    public Dependentes(int id, int id_titular, String dependencia_cliente) {
        this.id = id;
        this.id_titular = id_titular;
        this.dependencia_cliente = dependencia_cliente;
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
     * @return the id_titular
     */
    public int getId_titular() {
        return id_titular;
    }

    /**
     * @param id_titular the id_titular to set
     */
    public void setId_titular(int id_titular) {
        this.id_titular = id_titular;
    }

    /**
     * @return the dependencia_cliente
     */
    public String getDependencia_cliente() {
        return dependencia_cliente;
    }

    /**
     * @param dependencia_cliente the dependencia_cliente to set
     */
    public void setDependencia_cliente(String dependencia_cliente) {
        this.dependencia_cliente = dependencia_cliente;
    }
}
