package com.doceria.padoca.factory;

import com.doceria.padoca.model.Doce;
import com.doceria.padoca.model.Torta;

public class PedidoDoce implements Pedido {

    @Override
    public Torta montarTorta() {
        return new Doce();
    }

    @Override
    public void entregar() {
        System.out.println( "Entrega realizada!" );
    }
}
