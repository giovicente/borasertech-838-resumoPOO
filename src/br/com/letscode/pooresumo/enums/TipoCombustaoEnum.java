package br.com.letscode.pooresumo.enums;

public enum TipoCombustaoEnum {

    //UPPER_SNAKE_CASE
    GASOLINA("Gasolina"),
    ALCOOL("Álcool"),
    FLEX("Flex"),
    ELETRICO("Elétrico");

    private String descricao;

    TipoCombustaoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
