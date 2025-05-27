package com.doceria.padoca.strategy;

public class EntregaCarro implements Entrega {

    @Override
    public void entregar() {
        System.out.println( "Pedido será entregue com CARRO" );
    }
}
