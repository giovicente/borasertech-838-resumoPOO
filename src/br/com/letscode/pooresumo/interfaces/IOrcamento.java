package br.com.letscode.pooresumo.interfaces;

import java.math.BigDecimal;

public interface IOrcamento {

    BigDecimal realizaOrcamento();

    default void echo(String palavra) {
        System.out.println(palavra);
    }

}
