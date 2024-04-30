package br.com.portifolioLira.sistema_financiamento_spring.model.DTO.request;

import br.com.portifolioLira.sistema_financiamento_spring.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class EntryPointPessoaDTO implements Serializable {

    private String cpf ;
    private String cnpj ;
    private String nome;
    private String telefone;
    private String inscricaoMunicipal;
    private String tituloEleitor;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataAposentadoria;
    private TipoPessoa tipoPessoa;

    public EntryPointPessoaDTO(){}
    public EntryPointPessoaDTO(String cpf, String cnpj, String nome, String telefone, String inscricaoMunicipal, String tituloEleitor, Date dataAposentadoria, TipoPessoa tipoPessoa){

        this.cpf = cpf;
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.tituloEleitor = tituloEleitor;
        this.dataAposentadoria = dataAposentadoria;
        this.tipoPessoa = tipoPessoa;
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

    /*public TipoPessoa getTipoPessoa() {
        return TipoPessoa.valueOf(String.valueOf(tipoPessoa));
    }*/

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}