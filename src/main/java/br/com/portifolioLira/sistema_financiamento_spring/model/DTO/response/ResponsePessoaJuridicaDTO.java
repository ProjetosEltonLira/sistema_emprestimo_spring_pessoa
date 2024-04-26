package br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response;

import br.com.portifolioLira.sistema_financiamento_spring.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ResponsePessoaJuridicaDTO extends ResponsePessoaDTO {

    private String cnpj ;
    private String inscricaoMunicipal;

    public ResponsePessoaJuridicaDTO(){}
    public ResponsePessoaJuridicaDTO(Long id, String nome, String telefone, TipoPessoa tipoPessoa, String cnpj, String inscricaoMunicipal) {
        super(id, nome, telefone, tipoPessoa);
        this.cnpj = cnpj;
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }
}
