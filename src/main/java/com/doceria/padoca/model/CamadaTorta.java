package com.doceria.padoca.model;

public enum CamadaTorta {
    UMA("Uma"),
    DUAS( "Duas" ),
    TRÊS( "Três" ),
    QUATRO( "Quatro" );

    private final String descricao;

    CamadaTorta( String descricao ) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}