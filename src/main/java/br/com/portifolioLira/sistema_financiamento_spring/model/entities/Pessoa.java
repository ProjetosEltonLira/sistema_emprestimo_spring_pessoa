package br.com.portifolioLira.sistema_financiamento_spring.model.entities;

import br.com.portifolioLira.sistema_financiamento_spring.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table (name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "cpf")
    private String cpf ;

    @Column (name = "cnpj")
    private String cnpj ;

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

    @Enumerated(EnumType.STRING)
    @Column (name = "tipopessoa")
    private TipoPessoa tipoPessoa;

    public Pessoa(){}
    public Pessoa(String cpf, String nome, String telefone, String tituloEleitor){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.tituloEleitor = tituloEleitor;
        this.tipoPessoa = TipoPessoa.PESSOA_FISICA;
    }

    public Pessoa(String cpf, String nome, String telefone, String tituloEleitor, Date dataAposentadoria){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.tituloEleitor = tituloEleitor;
        this.dataAposentadoria = dataAposentadoria;
        this.tipoPessoa = TipoPessoa.PESSOA_FISICA_APOSENTADA;
    }

    public Pessoa(String cnpj, String nome, String telefone, String inscricaoMunicipal, TipoPessoa tipoPessoa) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.tipoPessoa = TipoPessoa.PESSOA_JURIDICA;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa DTOPessoa)) return false;
        return Objects.equals(id, DTOPessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
