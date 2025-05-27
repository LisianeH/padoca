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
        System.out.println( "Tamanhos disponíveis: " );
        int t = 1;
        for ( TamanhoTorta tamanhoOpcao : TamanhoService.listarTamanhos() ) {
            System.out.println( t + " - " + tamanhoOpcao.getDescricao() );
            t++;
        }
        System.out.println( "Escolha o valor correspondente ao tamanho da sua torta: " );
        int tamanho = scanner.nextInt();
        scanner.nextLine();
        if ( tamanho < 1 || tamanho > TamanhoTorta.values().length ) {
            System.out.println( "Opção de tamanho inválida!" );
            return;
        }
        String tamanhoSelecionado = String.valueOf( TamanhoTorta.values()[ tamanho - 1 ] );

        //CAMADAS
        System.out.println( "Quantidade de camadas disponíveis: " );
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
        System.out.println( "Recheios disponíveis: " );
        if ( escolhaTorta == 1 ) {
            int r = 1;
            for ( RecheioDoceTorta recheioOpcao : RecheioService.listarRecheios() ) {
                System.out.println( r + " - " + recheioOpcao.getDescricao() );
                r++;
            }
            System.out.println( "Escolha o recheio: " );
            int recheio = scanner.nextInt();
            scanner.nextLine();
            if ( recheio < 1 || recheio > RecheioSalgadoTorta.values().length ) {
                System.out.println("Opção de camadas inválida!");
                return;
            }
        } else if ( escolhaTorta == 2 ) {
            int r = 1;
            for ( RecheioSalgadoTorta recheioOpcao : RecheioService.listarRecheioSalgado() ) {
                System.out.println( r + " - " + recheioOpcao.getDescricao() );
                r++;
            }
            System.out.println( "Escolha o recheio: " );
            int recheio = scanner.nextInt();
            scanner.nextLine();
            if ( recheio < 1 || recheio > RecheioSalgadoTorta.values().length ) {
                System.out.println( "Opção de camadas inválida!" );
                return;
            }
        } else {
            System.out.println( "Torta não identificada" );
        }
        String recheio = String.valueOf( CamadaTorta.values()[ tamanho - 1 ] );

        //COBERTURA
        System.out.println( "Coberturas disponíveis: " );
        CoberturaService.listarCoberturas( escolhaTorta ).forEach( System.out::println );
        System.out.println( "Escolha a cobertura: " );
        String cobertura = scanner.nextLine();

        //TORTA PRONTA
        Torta torta = pedido.montarTorta();
        torta.setTamanho( tamanhoSelecionado );
        torta.setCamada( camadasSelecionado );
        torta.setRecheio( recheio );
        torta.setCobertura( cobertura );

        torta.preparar();
        pedido.entregar();
    }
}
