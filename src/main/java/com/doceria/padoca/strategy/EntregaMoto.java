package com.doceria.padoca.strategy;

public class EntregaMoto implements Entrega {


    @Override
    public void entregar() {
        System.out.println( "Pedido será entregue com MOTO" );
    }
}
