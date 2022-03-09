package br.com.letscode.pooresumo.exceptions;

public class LimiteCarrosAtingidoException extends Exception {

    public LimiteCarrosAtingidoException(String message) {
        super(message);
        final int STATUS_ERRO_LIMITE_CARROS_ATINGIDO = 1;
        System.out.println(message);
        System.exit(STATUS_ERRO_LIMITE_CARROS_ATINGIDO);
    }
}
