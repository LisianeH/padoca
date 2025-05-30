package com.doceria.padoca.strategy;

import com.doceria.padoca.factory.PedidoDoce;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PedidoStrategyTests {

	@Test
	public void testRealizarEntregaSemSelecionar() {
		PedidoDoce pedido = new PedidoDoce();
		assertDoesNotThrow(pedido::realizarEntrega);
	}

	@Test
	public void testRealizarEntregaExpressa() {
		PedidoDoce pedido = new PedidoDoce();
		pedido.setEntrega( new EntregaExpressa() );
		assertDoesNotThrow( pedido::realizarEntrega );
	}

	@Test
	public void testRealizarEntregaNormal() {
		PedidoDoce pedido = new PedidoDoce();
		pedido.setEntrega( new EntregaNormal() );
		assertDoesNotThrow( pedido::realizarEntrega );
	}
}
