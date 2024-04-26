package br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response;

import br.com.portifolioLira.sistema_financiamento_spring.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ResponsePessoaDTO implements Serializable {

    private Long id;
    private String nome;
    private String telefone;
    private TipoPessoa tipoPessoa;

    public ResponsePessoaDTO(){}

    public ResponsePessoaDTO(Long id, String nome, String telefone, TipoPessoa tipoPessoa) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
