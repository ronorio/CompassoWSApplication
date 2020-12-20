package com.uol.CompassoWS.model.enums;

public enum Sexo {
    M("Masculino"), F("Feminino");

    /**
     * Armazena a descricao do tipo de pessoa
     */
    private String descricao;

    private Sexo(String descricao) {
        setDescricao(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
