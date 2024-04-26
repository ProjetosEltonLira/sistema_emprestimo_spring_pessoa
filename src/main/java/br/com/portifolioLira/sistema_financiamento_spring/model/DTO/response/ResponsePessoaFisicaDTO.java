package br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response;

import br.com.portifolioLira.sistema_financiamento_spring.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ResponsePessoaFisicaDTO extends  ResponsePessoaDTO {

    private String cpf ;
    private String tituloEleitor;

    public ResponsePessoaFisicaDTO() {
    }
    public ResponsePessoaFisicaDTO(Long id, String nome, String telefone, TipoPessoa tipoPessoa, String cpf, String tituloEleitor ) {
        super(id, nome, telefone, tipoPessoa);
        this.cpf = cpf;
        this.tituloEleitor = tituloEleitor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }
}
