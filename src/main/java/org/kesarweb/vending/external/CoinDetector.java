package org.kesarweb.vending.external;

import org.kesarweb.vending.enums.CoinType;
import org.kesarweb.vending.model.Coin;

public class CoinDetector {

	public CoinType detect(final Coin coin) {
		return coin.getType();
	}

	public Double getCoinValue(final Coin coin) {
		return detect(coin).value();
	}

}
