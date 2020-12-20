package com.uol.CompassoWS.model;

import com.uol.CompassoWS.model.enums.Sexo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "dbo", name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CLIENTE", length = 10)
    private Long id;

    @Column(name = "DES_NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "IND_SEXO", nullable = false, length = 1)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "DAT_NASCIMENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "QTD_ANOS", nullable = true, insertable = false, updatable = false)
    private Long anos;

    @JoinColumn(name = "COD_CIDADE", nullable = false)
    @ManyToOne
    private Cidade cidade;

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

    public Long getAnos() {
        return anos;
    }

    public void setAnos(Long anos) {
        this.anos = anos;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
