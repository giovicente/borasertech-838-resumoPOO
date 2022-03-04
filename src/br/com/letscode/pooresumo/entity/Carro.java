package br.com.letscode.pooresumo.entity;

import br.com.letscode.pooresumo.enums.TipoCombustaoEnum;

public class Carro extends Veiculo {

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
}
