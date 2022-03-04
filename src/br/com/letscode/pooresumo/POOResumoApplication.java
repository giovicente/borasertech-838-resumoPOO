package br.com.letscode.pooresumo;

import br.com.letscode.pooresumo.entity.Carro;
import br.com.letscode.pooresumo.entity.Concessionaria;
import br.com.letscode.pooresumo.entity.Moto;
import br.com.letscode.pooresumo.enums.TipoCombustaoEnum;

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

        Concessionaria concessionaria = new Concessionaria(carros, motos);
        concessionaria.imprimeCarros();

    }
}
