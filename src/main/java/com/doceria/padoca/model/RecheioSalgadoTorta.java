package com.doceria.padoca.model;

public enum RecheioSalgadoTorta {
    FRANGO( "Frango com Catupiry" ),
    CARNE( "Carne desfiada" ),
    PALMITO( "Palmito" ),
    PRESUNTO( "Queijo e Presunto" ),
    ERVILHA( "Adicional de Ervilha" );

    private final String descricao;

    RecheioSalgadoTorta( String descricao ) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
