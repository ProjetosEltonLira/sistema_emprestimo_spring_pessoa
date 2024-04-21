package br.com.portifolioLira.sistema_financiamento_spring.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "telefone")
    private String telefone;

    @Column (name = "inscricaomunicipal") //escrever minusculo para a variável poder ser encontrada no banco de dados mySql
    private String inscricaoMunicipal;

    @Column (name = "tituloeleitor")
    private String tituloEleitor;

    @JsonFormat(pattern="dd/MM/yyyy")
    @Column (name = "dataaposentadoria")
    private Date dataAposentadoria;

    @Column (name = "tipopessoa")
    private String tipoPessoa;

    public Pessoa(){}
    public Pessoa(Long id, String nome, String telefone, String inscricaoMunicipal, String tituloEleitor, Date dataAposentadoria, String tipoPessoa){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.tituloEleitor = tituloEleitor;
        this.dataAposentadoria = dataAposentadoria;
        this.tipoPessoa = tipoPessoa;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public Date getDataAposentadoria() {
        return dataAposentadoria;
    }

    public void setDataAposentadoria(Date dataAposentadoria) {
        this.dataAposentadoria = dataAposentadoria;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
