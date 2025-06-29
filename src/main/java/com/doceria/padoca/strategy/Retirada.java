package com.doceria.padoca.strategy;

public class Retirada implements Entrega {


    @Override
    public void entregar() {
        System.out.println( "Pedido pode ser retirado na LOJA a das 09:00 as 14:00h do próximo dia." );
    }
}
