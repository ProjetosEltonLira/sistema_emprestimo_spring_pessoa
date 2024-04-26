package br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response;

import br.com.portifolioLira.sistema_financiamento_spring.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ResponsePessoaFisicaAposentadaDTO extends ResponsePessoaFisicaDTO {

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataAposentadoria;

    public ResponsePessoaFisicaAposentadaDTO(){}
    public ResponsePessoaFisicaAposentadaDTO(Long id, String nome, String telefone, TipoPessoa tipoPessoa, String cpf, String tituloEleitor, Date dataAposentadoria) {
        super(id, nome, telefone, tipoPessoa, cpf, tituloEleitor);
        this.dataAposentadoria = dataAposentadoria;
    }

    public Date getDataAposentadoria() {
        return dataAposentadoria;
    }

    public void setDataAposentadoria(Date dataAposentadoria) {
        this.dataAposentadoria = dataAposentadoria;
    }
}
