package com.doceria.padoca.model;

import lombok.Getter;
import lombok.Setter;

public abstract class Torta {

    protected String recheio;
    protected String camada;
    protected String tamanho;
    protected String cobertura;

    public abstract void preparar();

    public void exibirDetalhes() {
        System.out.println( "\n--- Encomenda ---" );
        System.out.println( "Tamanho: " + tamanho );
        System.out.println( "Camadas: " + camada );
        System.out.println( "Recheio: " + recheio );
        System.out.println( "Cobertura: " + cobertura );
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getCamada() {
        return camada;
    }

    public void setCamada(String camada) {
        this.camada = camada;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }
}