package com.doceria.padoca.strategy;

public class EntregaExpressa implements Entrega {


    @Override
    public void entregar() {
        System.out.println( "Entrega rápida realizada em até 24 horas!" );
    }
}
