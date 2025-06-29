package com.doceria.padoca.model;

public enum RecheioDoceTorta {
    LEITE_CONDENSADO( "Leite Condensado" ),
    DOCE_DE_LEITE( "Doce de Leite" ),
    MORANGO( "Morango com Nata" ),
    PESSEGO( "Pêssego" ),
    MUSSE_CHOCO_BRANCO( "Musse Chocolate Branco" ),
    MUSSE_CHOCO_AMAGO( "Musse Chocolate Meio Amargo" ),
    MORANGO_BRIGADEIRO( "Morango com Brigadeiro" );

    private final String descricao;

    RecheioDoceTorta(String descricao ) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
