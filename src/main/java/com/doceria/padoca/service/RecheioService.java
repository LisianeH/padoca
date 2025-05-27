package com.doceria.padoca.service;

import com.doceria.padoca.model.RecheioDoceTorta;
import com.doceria.padoca.model.RecheioSalgadoTorta;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RecheioService {

    public static List< RecheioDoceTorta > listarRecheios() {
        return Arrays.asList( RecheioDoceTorta.values() );
    }

    public static List< RecheioSalgadoTorta > listarRecheioSalgado() {
        return Arrays.asList( RecheioSalgadoTorta.values() );
    }
}
