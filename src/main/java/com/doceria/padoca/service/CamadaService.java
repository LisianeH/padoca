package com.doceria.padoca.service;

import com.doceria.padoca.model.CamadaTorta;

import java.util.Arrays;
import java.util.List;

public class CamadaService {

    public static List< CamadaTorta > listarCamadas() {
        return Arrays.asList( CamadaTorta.values() );
    }
}
