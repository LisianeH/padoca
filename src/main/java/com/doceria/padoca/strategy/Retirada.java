package com.doceria.padoca.strategy;

public class Retirada implements Entrega {


    @Override
    public void entregar() {
        System.out.println( "Pedido será retirado na LOJA" );
    }
}
