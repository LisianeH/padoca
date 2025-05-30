package com.doceria.padoca;

import com.doceria.padoca.decorator.CartaoPresente;
import com.doceria.padoca.decorator.EmbalagemEspecial;
import com.doceria.padoca.model.*;
import com.doceria.padoca.service.CamadaService;
import com.doceria.padoca.service.CoberturaService;
import com.doceria.padoca.service.RecheioService;
import com.doceria.padoca.factory.PedidoDoce;
import com.doceria.padoca.factory.PedidoSalgado;
import com.doceria.padoca.factory.Pedido;
import com.doceria.padoca.service.TamanhoService;
import com.doceria.padoca.strategy.EntregaExpressa;
import com.doceria.padoca.strategy.EntregaNormal;
import com.doceria.padoca.strategy.Retirada;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Profile("!test")
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
	    String tamanhoSelecionado = TamanhoTorta.values()[tamanho - 1].getDescricao();

        //CAMADAS
        System.out.println( "\nQuantidade de camadas disponíveis: " );
        int c = 1;
        for ( CamadaTorta camadaOpcao : CamadaService.listarCamadas() ) {
            System.out.println( c + " - " + camadaOpcao.getDescricao() );
            c++;
        }
        System.out.println( "\nEscolha a quantidade de camadas: " );
        int camadas = scanner.nextInt();
        scanner.nextLine();
        if ( camadas < 1 || camadas > TamanhoTorta.values().length ) {
            System.out.println( "Opção de camadas inválida!" );
            return;
        }
	    String camadasSelecionado = CamadaTorta.values()[camadas - 1].getDescricao();

        //RECHEIO
        System.out.println( "\nRecheios disponíveis: " );
	    List< String > recheiosEscolhidos = new ArrayList<>();
	    List< String > listaRecheios = new ArrayList<>();

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
        System.out.println( "1 - Toda torta com o mesmo recheio" );
        System.out.println( "2 - Um recheio por camada" );
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if ( escolha == 1 ) {
            System.out.println( "\nEscolha o recheio: " );
            int opcaoRecheio = scanner.nextInt();
            scanner.nextLine();
            if ( opcaoRecheio < 1 || opcaoRecheio > listaRecheios.size() ) {
                System.out.println( "Opção inválida!" );
                return;
            }

            String recheioSelecionado = listaRecheios.get( opcaoRecheio - 1 );
            for ( int i = 0; i < camadas; i++ ) {
                recheiosEscolhidos.add( recheioSelecionado );
            }

        } else if ( escolha == 2 ) {
            for ( int i = 0; i < camadas; i++ ) {
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

        System.out.println( "\nRecheios escolhidos: " );
        for ( int i = 0; i < recheiosEscolhidos.size(); i++ ) {
            System.out.println( "Camada " + (i + 1) + ": " + recheiosEscolhidos.get( i ) );
        }

        //COBERTURA
        System.out.println( "\nCoberturas disponíveis: " );
	    String coberturaSelecionada = "";
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
	        coberturaSelecionada = CoberturaDoceTorta.values()[ cobertura - 1 ].getDescricao();
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
	        coberturaSelecionada = CoberturaSalgadaTorta.values()[ cobertura - 1 ].getDescricao();
        } else {
            System.out.println( "Torta não identificada" );
        }


        //TORTA PRONTA
        Torta torta = pedido.montarTorta();
        torta.setTamanho( tamanhoSelecionado );
        torta.setCamada( camadasSelecionado );
        torta.setRecheio( String.join(", ", recheiosEscolhidos) );
        torta.setCobertura( coberturaSelecionada );

        //EXTRAS
        System.out.println( "\nDeseja adicionar algum extra?" );
        System.out.println( "1 - Embalagem Especial" );
        System.out.println( "2 - Cartão Presente" );
        System.out.println( "3 - Sem extras" );
        int opcaoExtra = scanner.nextInt();
        scanner.nextLine();

        switch ( opcaoExtra ) {
            case 1:
                torta = new EmbalagemEspecial( torta );
                break;
            case 2:
                torta = new CartaoPresente( torta );
                break;
            default:
                break;
        }

        torta.preparar();
        torta.exibirDetalhes();

        //ENTREGA
        System.out.println("\nEscolha o tipo de entrega:");
        System.out.println("1 - Normal ( 3 dias )");
        System.out.println("2 - Expressa ( 24 horas )");
        System.out.println("3 - Retirada na Loja ( Retirada no próximo dia )");

        int opcaoEntrega = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoEntrega) {
            case 1:
                pedido.setEntrega( new EntregaNormal() );
                break;
            case 2:
                pedido.setEntrega( new EntregaExpressa() );
                break;
            case 3:
                pedido.setEntrega( new Retirada() );
                break;
            default:
                System.out.println( "Opção inválida." );
                break;
        }

        pedido.realizarEntrega();

        System.out.println( "\nPedido finalizado. Volte sempre!" );
        System.exit( 0 );
    }
}
