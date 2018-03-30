package org.kesarweb.vending.model;

import org.kesarweb.vending.enums.CoinType;

public class Coin {

	private CoinType type;

	public Coin(final CoinType coinType) {
		this.type = coinType;
	}

	public CoinType getType() {
		return type;
	}

}
