package com.doceria.padoca.model;

public enum TamanhoTorta {
    PEQUENA( "8 pedaços" ),
    MEDIA("12 pedaços"),
    GRANDE("18 pedaços"),
    FAMILIA("25 pedaços"),
    FESTA("30 pedaços");

    private final String descricao;

    TamanhoTorta( String descricao ) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
