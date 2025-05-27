package com.doceria.padoca.model;

public enum CoberturaDoceTorta {
    CHANTILLY( "Chantilly" ),
    NATA( "Nata" ),
    PALMITO( "Palmito" );

    private final String descricao;

    CoberturaDoceTorta( String descricao ) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
