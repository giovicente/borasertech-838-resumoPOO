package br.com.letscode.pooresumo.entity;

import br.com.letscode.pooresumo.exceptions.LimiteCarrosAtingidoException;
import br.com.letscode.pooresumo.interfaces.IOrcamento;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Concessionaria {

    private Carro[] carros;
    private Moto[] motos;
    private int limiteCarros;

    public Concessionaria(Carro[] carros, Moto[] motos, int limiteCarros) {
        this.carros = carros;
        this.motos = motos;
        this.limiteCarros = limiteCarros;
    }

    public Carro[] getCarros() {
        return carros;
    }

    public void setCarros(Carro[] carros) {
        this.carros = carros;
    }

    public Moto[] getMotos() {
        return motos;
    }

    public void setMotos(Moto[] motos) {
        this.motos = motos;
    }

    public int getLimiteCarros() { return limiteCarros; }

    public void setLimiteCarros(int limiteCarros) { this.limiteCarros = limiteCarros; }

    public void imprimeCarros() {
        // Um array tem tamanho N e (N-1) índices
        for (int i = 0; i <= this.carros.length; i++) {
            try {
                System.out.println(this.carros[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Elemento não encontrado para impressão! " +
                        "Motivo: " + e.getMessage());
            }
        }
    }

    public String compraCarro(Carro carroCompra) throws LimiteCarrosAtingidoException {

        if ((this.getCarros().length + 1) > this.limiteCarros) {
            throw new LimiteCarrosAtingidoException("Limite de carros atingido!");
        }

        Carro[] listaCarrosAtualizada = new Carro[this.getCarros().length + 1];

        for (int i = 0; i < this.getCarros().length; i++) {
            listaCarrosAtualizada[i] = this.getCarros()[i];
        }

        listaCarrosAtualizada[this.getCarros().length] = carroCompra;
        this.setCarros(listaCarrosAtualizada);

        return "Compra efetuada com sucesso";
    }

    /* try catch default
    public void geraRelatorio() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter("log-letscode.txt", "UTF-8");
            writer.println("Data de referência: " + LocalDateTime.now() + " - "
                    + " Total de carros: " + this.getCarros().length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
    */

    // try-with-resources
    public void geraRelatorio() {
        try (PrintWriter writer =
                     new PrintWriter("log-letscode.txt", "UTF-8")) {
            writer.println("Data de referência: " + LocalDateTime.now() + " - "
                    + " Total de carros: " + this.getCarros().length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
