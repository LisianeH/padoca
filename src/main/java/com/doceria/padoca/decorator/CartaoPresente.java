package com.doceria.padoca.decorator;

import com.doceria.padoca.model.Torta;

import java.util.Scanner;

public class CartaoPresente extends TortaDecorator {

	public CartaoPresente( Torta torta ) {
		super(torta);
	}

	@Override
	public void preparar() {
		super.preparar();
		System.out.println( "Adicionando cartão de presente." );

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a mensagem que deseja no cartão:");
		String mensagem = scanner.nextLine();

		System.out.println("Mensagem no cartão: \"" + mensagem + "\"");
	}

	@Override
	public void exibirDetalhes() {
		tortaDecorada.exibirDetalhes();
		System.out.println( "Inclui cartão presente." );
	}
}
