package br.com.portifolioLira.sistema_financiamento_spring.model.enums;

public enum TipoPessoa {

    PESSOA_FISICA(0),
    PESSOA_FISICA_APOSENTADA(1),
    PESSOA_JURIDICA(2);

    private int codigo;
    private TipoPessoa(int code) {
        this.codigo = code;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoPessoa valueOf(int codigo){
        for (TipoPessoa value : TipoPessoa.values()){
            if (value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código do status do pedido inválido");
    }
}