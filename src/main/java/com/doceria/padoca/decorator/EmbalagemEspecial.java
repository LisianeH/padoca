package com.doceria.padoca.decorator;

import com.doceria.padoca.model.Torta;

public class EmbalagemEspecial extends TortaDecorator {

	public EmbalagemEspecial( Torta torta ) {
		super(torta);
	}

	@Override
	public void preparar() {
		super.preparar();
		System.out.println( "Adicionando embalagem especial." );
	}

	@Override
	public void exibirDetalhes() {
		tortaDecorada.exibirDetalhes();
		System.out.println( "Inclui embalagem especial." );
	}
}
