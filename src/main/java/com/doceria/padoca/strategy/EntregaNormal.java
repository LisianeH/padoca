package com.doceria.padoca.strategy;

public class EntregaNormal implements Entrega {

    @Override
    public void entregar() {
        System.out.println( "Entrega normal realizada em até 3 dias." );
    }
}
