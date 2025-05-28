package com.doceria.padoca.service;

import com.doceria.padoca.model.CoberturaDoceTorta;
import com.doceria.padoca.model.CoberturaSalgadaTorta;

import java.util.Arrays;
import java.util.List;

public class CoberturaService {

    public static List< CoberturaDoceTorta > listarCobertura() {
        return Arrays.asList( CoberturaDoceTorta.values() );
    }

    public static List< CoberturaSalgadaTorta > listarCoberturaSalgado() {
        return Arrays.asList( CoberturaSalgadaTorta.values() );
    }
}
