package com.uol.CompassoWS.dto;

import com.uol.CompassoWS.model.enums.Sexo;

import java.util.Date;

public class ClienteDTOV1 {

    private Long id;
    private String nome;
    private Sexo sexo;
    private Date dataNascimento;
    private Long codigoCidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(Long codigoCidade) {
        this.codigoCidade = codigoCidade;
    }
}
