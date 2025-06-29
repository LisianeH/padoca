package com.doceria.padoca.factory;

import com.doceria.padoca.model.Salgada;
import com.doceria.padoca.model.Torta;
import com.doceria.padoca.strategy.Entrega;

public class PedidoSalgado implements Pedido {

    private Entrega entrega;

    @Override
    public Torta montarTorta() {
        return new Salgada();
    }

    @Override
    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    @Override
    public void realizarEntrega() {
        if (entrega != null) {
            entrega.entregar();
        } else {
            System.out.println("Nenhuma opção de entrega selecionada");
        }
    }
}
