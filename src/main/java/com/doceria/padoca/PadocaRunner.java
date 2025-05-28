package com.doceria.padoca;

import com.doceria.padoca.model.*;
import com.doceria.padoca.service.CamadaService;
import com.doceria.padoca.service.CoberturaService;
import com.doceria.padoca.service.RecheioService;
import com.doceria.padoca.factory.PedidoDoce;
import com.doceria.padoca.factory.PedidoSalgado;
import com.doceria.padoca.factory.Pedido;
import com.doceria.padoca.service.TamanhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class PadocaRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Bem-vindo à Padoca Delivery!" );
        System.out.println( "Escolha o tipo de torta: " );
        System.out.println( "1 - Doce" );
        System.out.println( "2 - Salgada" );

        int escolhaTorta = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido;
        TipoTorta tipo;
        if ( escolhaTorta == 1 ) {
            pedido = new PedidoDoce();
            tipo = TipoTorta.DOCE;
        } else if ( escolhaTorta == 2 ) {
            pedido = new PedidoSalgado();
            tipo = TipoTorta.SALGADA;
        } else {
            System.out.println( "Opção inválida!" );
            return;
        }

        System.out.println( "Vamos montar sua torta " + tipo + "!" );

        //TAMANHO
        System.out.println( "\nTamanhos disponíveis: " );
        int t = 1;
        for ( TamanhoTorta tamanhoOpcao : TamanhoService.listarTamanhos() ) {
            System.out.println( t + " - " + tamanhoOpcao.getDescricao() );
            t++;
        }
        System.out.println( "\nEscolha tamanho da sua torta: " );
        int tamanho = scanner.nextInt();
        scanner.nextLine();
        if ( tamanho < 1 || tamanho > TamanhoTorta.values().length ) {
            System.out.println( "Opção de tamanho inválida!" );
            return;
        }
        String tamanhoSelecionado = String.valueOf( TamanhoTorta.values()[ tamanho - 1 ] );

        //CAMADAS
        System.out.println( "\nQuantidade de camadas disponíveis: " );
        int c = 1;
        for ( CamadaTorta camadaOpcao : CamadaService.listarCamadas() ) {
            System.out.println( c + " - " + camadaOpcao.getDescricao() );
            c++;
        }
        System.out.println( "Escolha a quantidade de camadas: " );
        int camadas = scanner.nextInt();
        scanner.nextLine();
        if ( camadas < 1 || camadas > TamanhoTorta.values().length ) {
            System.out.println( "Opção de camadas inválida!" );
            return;
        }
        String camadasSelecionado = String.valueOf( CamadaTorta.values()[ tamanho - 1 ] );

        //RECHEIO
        List<String> recheiosEscolhidos = new ArrayList<>();

        System.out.println( "\nRecheios disponíveis: " );
        List<String> listaRecheios = new ArrayList<>();
        int r = 1;
        if (escolhaTorta == 1) {
            for (RecheioDoceTorta recheioOpcao : RecheioService.listarRecheios()) {
                System.out.println(r + " - " + recheioOpcao.getDescricao());
                listaRecheios.add(recheioOpcao.getDescricao());
                r++;
            }
        } else {
            for (RecheioSalgadoTorta recheioOpcao : RecheioService.listarRecheioSalgado()) {
                System.out.println(r + " - " + recheioOpcao.getDescricao());
                listaRecheios.add(recheioOpcao.getDescricao());
                r++;
            }
        }

        System.out.println( "\nA sua torta será: " );
        System.out.println( "1 - Toda com torta somente com um sabor" );
        System.out.println( "2 - Um recheio por camada" );
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if ( escolha == 1 ) {
            System.out.println( "\nEscolha o recheio: " );
            int opcaoRecheio = scanner.nextInt();
            scanner.nextLine();
            if (opcaoRecheio < 1 || opcaoRecheio > listaRecheios.size()) {
                System.out.println( "Opção inválida!" );
                return;
            }

            String recheioSelecionado = listaRecheios.get(opcaoRecheio - 1);
            for (int i = 0; i < camadas; i++) {
                recheiosEscolhidos.add(recheioSelecionado);
            }

        } else if (escolha == 2) {
            for (int i = 0; i < camadas; i++) {
                System.out.println( "\nEscolha o recheio para a camada " + (i + 1) + ": " );
                int opcaoRecheio = scanner.nextInt();
                scanner.nextLine();
                if ( opcaoRecheio < 1 || opcaoRecheio > listaRecheios.size() ) {
                    System.out.println( "Opção inválida!" );
                    return;
                }
                recheiosEscolhidos.add( listaRecheios.get( opcaoRecheio - 1 ) );
            }
        } else {
            System.out.println( "Opção inválida!" );
            return;
        }

        System.out.println( "Recheios escolhidos: " );
        for ( int i = 0; i < recheiosEscolhidos.size(); i++ ) {
            System.out.println( "Camada " + (i + 1) + ": " + recheiosEscolhidos.get( i ) );
        }
        String recheioSelecionado = String.valueOf( CamadaTorta.values()[ tamanho - 1 ] );

        //COBERTURA
        System.out.println( "\nCoberturas disponíveis: " );
        if ( escolhaTorta == 1 ) {
            int i = 1;
            for ( CoberturaDoceTorta coberturaOpcao : CoberturaService.listarCobertura() ) {
                System.out.println( i + " - " + coberturaOpcao.getDescricao() );
                i++;
            }
            System.out.println( "Escolha a cobertura: " );
            int cobertura = scanner.nextInt();
            scanner.nextLine();
            if ( cobertura < 1 || cobertura > CoberturaDoceTorta.values().length ) {
                System.out.println( "Opção de recheio inválido!" );
                return;
            }
        } else if ( escolhaTorta == 2 ) {
            int i = 1;
            for ( CoberturaSalgadaTorta coberturaOpcao : CoberturaService.listarCoberturaSalgado() ) {
                System.out.println( i + " - " + coberturaOpcao.getDescricao() );
                i++;
            }
            System.out.println( "Escolha a cobertura: " );
            int cobertura = scanner.nextInt();
            scanner.nextLine();
            if ( cobertura < 1 || cobertura > CoberturaSalgadaTorta.values().length ) {
                System.out.println( "Opção de recheio inválido!" );
                return;
            }
        } else {
            System.out.println( "Torta não identificada" );
        }
        String coberturaSelecionado = String.valueOf( CamadaTorta.values()[ tamanho - 1 ] );

        //TORTA PRONTA
        Torta torta = pedido.montarTorta();
        torta.setTamanho( tamanhoSelecionado );
        torta.setCamada( camadasSelecionado );
        torta.setRecheio( recheioSelecionado );
        torta.setCobertura( coberturaSelecionado );

        torta.preparar();
        pedido.entregar();
    }
}
