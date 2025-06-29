package com.doceria.padoca.factory;

import com.doceria.padoca.model.Doce;
import com.doceria.padoca.model.Salgada;
import com.doceria.padoca.model.Torta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoFactoryTests {

	@Test
	void testMontarTortaDoce() {
		Pedido pedidoDoce = new PedidoDoce();
		Torta torta = pedidoDoce.montarTorta();

		assertNotNull(torta);
		assertTrue(torta instanceof Doce);
	}

	@Test
	void testMontarTortaSalgada() {
		Pedido pedidoSalgado = new PedidoSalgado();
		Torta torta = pedidoSalgado.montarTorta();

		assertNotNull(torta);
		assertTrue(torta instanceof Salgada);
	}
}
