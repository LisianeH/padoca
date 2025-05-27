package com.doceria.padoca.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Torta {

    protected String recheio;
    protected String camada;
    protected String tamanho;
    protected String cobertura;

    public abstract void preparar();

}
