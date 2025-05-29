package com.doceria.padoca.factory;

import com.doceria.padoca.model.Torta;
import com.doceria.padoca.strategy.Entrega;

public interface Pedido {

    Torta montarTorta();

    void setEntrega( Entrega entrega );

    void realizarEntrega();
}
