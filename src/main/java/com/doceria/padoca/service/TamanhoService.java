package com.doceria.padoca.service;

import com.doceria.padoca.model.TamanhoTorta;

import java.util.Arrays;
import java.util.List;

public class TamanhoService {

    public static List< TamanhoTorta > listarTamanhos() {
        return Arrays.asList( TamanhoTorta.values() );
    }
}
