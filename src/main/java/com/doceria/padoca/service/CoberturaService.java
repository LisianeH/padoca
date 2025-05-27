package com.doceria.padoca.service;

import java.util.Arrays;
import java.util.List;

public class CoberturaService {

    public static List< String > listarCoberturas( Integer opcaoEscolhida ) {
        if ( opcaoEscolhida == 1 ) {
            return Arrays.asList( "Musse Chocolate Meio Amargo", "Morango com Nata", "Morango com Brigadeiro",
                    "Doce de Leite", "Musse Chocolate Branco", "Pêssego", "Leite Condensado" );
        } else if ( opcaoEscolhida == 2 ) {
            return Arrays.asList( "Frango com Catupiry", "Carne desfiada", "Palmito", "Queijo e Presunto", "Adicional de Ervilha" );
        } else {
            return List.of();
        }
    }
}
