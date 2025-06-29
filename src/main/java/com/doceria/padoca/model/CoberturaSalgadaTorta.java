package com.doceria.padoca.model;

public enum CoberturaSalgadaTorta {
	MAIONESE( "Maionese" ),
	CRU( "Sem Cobertura" );

	private final String descricao;

	CoberturaSalgadaTorta( String descricao ) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
