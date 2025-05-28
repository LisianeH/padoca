package com.doceria.padoca.factory;

import com.doceria.padoca.model.Salgada;
import com.doceria.padoca.model.Torta;

public class PedidoSalgado implements Pedido {

    @Override
    public Torta montarTorta() {
        return new Salgada();
    }

    @Override
    public void entregar() {
        System.out.println( "Entrega realizada!" );
    }
}
