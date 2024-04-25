package br.com.portifolioLira.sistema_financiamento_spring.model.DTO;

import br.com.portifolioLira.sistema_financiamento_spring.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table (name = "pessoa")
public class PessoaDTO implements Serializable {

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

    @Column (name = "tipopessoa")
    private String tipoPessoa;

    public PessoaDTO(){}
    public PessoaDTO(Long id, String cpf, String cnpj, String nome, String telefone, String inscricaoMunicipal, String tituloEleitor, Date dataAposentadoria, String tipoPessoa){
        this.id = id;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.tituloEleitor = tituloEleitor;
        this.dataAposentadoria = dataAposentadoria;
        this.tipoPessoa = tipoPessoa;
    }

    public PessoaDTO(String cpf, String nome, String telefone, String tituloEleitor){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.tituloEleitor = tituloEleitor;
        this.tipoPessoa = "PESSOA_FISICA";
    }

    public PessoaDTO(String cpf, String nome, String telefone, String tituloEleitor, Date dataAposentadoria){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.tituloEleitor = tituloEleitor;
        this.dataAposentadoria = dataAposentadoria;
        this.tipoPessoa = "PESSOA_FISICA_APOSENTADA";
    }

    public PessoaDTO(String cnpj, String nome, String telefone, String inscricaoMunicipal, TipoPessoa tipoPessoa) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.tipoPessoa = "PESSOA_FISICA_APOSENTADA";
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

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
