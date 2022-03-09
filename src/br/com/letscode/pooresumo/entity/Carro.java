package br.com.letscode.pooresumo.entity;

import br.com.letscode.pooresumo.enums.TipoCombustaoEnum;
import br.com.letscode.pooresumo.interfaces.IOrcamento;

import java.math.BigDecimal;

public class Carro extends Veiculo implements IOrcamento {

    private int quantidadePortas;
    private boolean hasAirBag;

    // Carro carro1 = new Carro("Chevrolet", "Onix", 2017, TipoCombustaoEnum.FLEX.getDescricao(), 42000, 5, Boolean.TRUE);
    public Carro(String fabricante, String modelo, int ano, String tipoCombustaoEnum, double preco, int quantidadePortas, boolean hasAirBag) {
        super(fabricante, modelo, ano, tipoCombustaoEnum, preco);
        this.quantidadePortas = quantidadePortas;
        this.hasAirBag = hasAirBag;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public boolean hasAirBag() {
        return hasAirBag;
    }

    public void setHasAirBag(boolean hasAirBag) {
        this.hasAirBag = hasAirBag;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "quantidadePortas=" + quantidadePortas +
                ", hasAirBag=" + hasAirBag +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", tipoCombustaoEnum='" + tipoCombustaoEnum + '\'' +
                '}';
    }

    @Override
    public BigDecimal realizaOrcamento() {
        final BigDecimal ORCAMENTO_CARRO_ALCOOL = BigDecimal.valueOf(2500, 1); // 250.0
        final BigDecimal ORCAMENTO_CARRO_GASOLINA = BigDecimal.valueOf(5000, 1); // 500.0
        final BigDecimal ORCAMENTO_CARRO_FLEX = BigDecimal.valueOf(6250, 1); // 625.0

        if (this.tipoCombustaoEnum.equals(TipoCombustaoEnum.ALCOOL.getDescricao())) {
            return ORCAMENTO_CARRO_ALCOOL;
        } else if (this.tipoCombustaoEnum.equals(TipoCombustaoEnum.GASOLINA.getDescricao())) {
            return ORCAMENTO_CARRO_GASOLINA;
        }

        return ORCAMENTO_CARRO_FLEX;
    }
}
