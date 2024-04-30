package br.com.portifolioLira.sistema_financiamento_spring.services.exceptions;

public class DataBaseException extends RuntimeException{

    public DataBaseException(String mensagem){
        super(mensagem);
    }
}
