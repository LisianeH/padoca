package com.doceria.padoca.decorator;

import com.doceria.padoca.model.Torta;

public abstract class TortaDecorator extends Torta {
    protected Torta tortaDecorada;

    public TortaDecorator(Torta tortaDecorada) {
        this.tortaDecorada = tortaDecorada;
    }

    @Override
    public void preparar() {
        tortaDecorada.preparar();
    }

    @Override
    public void exibirDetalhes() {
        tortaDecorada.exibirDetalhes();
    }

    @Override
    public String getTamanho() {
        return tortaDecorada.getTamanho();
    }

    @Override
    public String getCamada() {
        return tortaDecorada.getCamada();
    }

    @Override
    public String getRecheio() {
        return tortaDecorada.getRecheio();
    }

    @Override
    public String getCobertura() {
        return tortaDecorada.getCobertura();
    }
}