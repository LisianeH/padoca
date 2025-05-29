package com.doceria.padoca.decorator;

import com.doceria.padoca.model.Doce;
import com.doceria.padoca.model.Torta;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PedidoDecoratorTests {
	@Test
	public void deveAdicionarEmbalagemEspecial() {
		Torta tortaBase = new Doce();
		tortaBase.setTamanho( "Médio" );
		tortaBase.setCamada( "3" );
		tortaBase.setRecheio( "Brigadeiro" );
		tortaBase.setCobertura( "Chocolate" );

		Torta tortaComEmbalagem = new EmbalagemEspecial( tortaBase );

		assertEquals( "Médio", tortaComEmbalagem.getTamanho() );
		assertEquals( "3", tortaComEmbalagem.getCamada() );
		assertEquals( "Brigadeiro", tortaComEmbalagem.getRecheio() );
		assertEquals( "Chocolate", tortaComEmbalagem.getCobertura() );
	}

	@Test
	public void deveAdicionarCartaoPresente() {
		Torta tortaBase = new Doce();
		tortaBase.setTamanho( "Grande" );
		tortaBase.setCamada( "2" );
		tortaBase.setRecheio( "Doce de Leite" );
		tortaBase.setCobertura( "Coco" );

		Torta tortaComCartao = new CartaoPresente(tortaBase);

		assertEquals("Grande", tortaComCartao.getTamanho());
		assertEquals("2", tortaComCartao.getCamada());
		assertEquals("Doce de Leite", tortaComCartao.getRecheio());
		assertEquals("Coco", tortaComCartao.getCobertura());
	}
}
