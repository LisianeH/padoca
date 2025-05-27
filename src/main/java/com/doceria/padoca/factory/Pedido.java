package com.doceria.padoca.factory;

import com.doceria.padoca.model.Torta;

public interface Pedido {

    Torta montarTorta();

    void entregar();
}
