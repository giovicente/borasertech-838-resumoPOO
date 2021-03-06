package br.com.letscode.pooresumo;

import br.com.letscode.pooresumo.entity.Carro;
import br.com.letscode.pooresumo.entity.Concessionaria;
import br.com.letscode.pooresumo.entity.Moto;
import br.com.letscode.pooresumo.enums.TipoCombustaoEnum;
import br.com.letscode.pooresumo.exceptions.LimiteCarrosAtingidoException;

import java.math.BigDecimal;

public class POOResumoApplication {

    public static void main(String[] args) {

        Carro carro1 = new Carro("Chevrolet", "Onix", 2017,
                TipoCombustaoEnum.FLEX.getDescricao(), 42000, 5, Boolean.TRUE);

        Carro carro2 = new Carro("Chevrolet", "Onix", 2018,
                TipoCombustaoEnum.GASOLINA.getDescricao(), 45000, 5, Boolean.TRUE);

        Carro carro3 = new Carro("Chevrolet", "Onix", 2019,
                TipoCombustaoEnum.FLEX.getDescricao(), 39000, 5, Boolean.TRUE);

        //String[] professores = new String[]{"Giovanni", "Hugo", "Angela"};
        Carro[] carros = new Carro[]{carro1, carro2, carro3};

        Moto moto = new Moto("Honda", "Biz", 2019,
                TipoCombustaoEnum.FLEX.getDescricao(), 12000, 125);

        Moto[] motos = new Moto[]{moto};

        final int LIMITE_CARROS = 10;

        Concessionaria concessionaria = new Concessionaria(carros, motos, LIMITE_CARROS);

        System.out.println("Lista de carros antes da compra");
        concessionaria.imprimeCarros();

        Carro carroCompra = new Carro("Chevrolet", "Camaro", 2019,
                TipoCombustaoEnum.FLEX.getDescricao(), 39000, 5, Boolean.TRUE);

        System.out.println("===============================================================");
        System.out.println("Lista de carros após a compra");


        try {
            concessionaria.compraCarro(carroCompra);
        } catch (LimiteCarrosAtingidoException e) {
            System.out.println(e.getMessage());
            final int STATUS_ERRO_LIMITE_CARROS_ATINGIDO = 1;
            System.exit(STATUS_ERRO_LIMITE_CARROS_ATINGIDO);
        }

        concessionaria.imprimeCarros();

        System.out.println("===============================================================");
        BigDecimal orcamento = carroCompra.realizaOrcamento();
        System.out.println("Orçamento do veículo " + carroCompra.getModelo() + ": " + orcamento);
        carroCompra.echo("Feliz dia das mulheres!!!");

        concessionaria.geraRelatorio();

    }
}
