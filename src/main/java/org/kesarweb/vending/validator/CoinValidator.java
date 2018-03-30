package org.kesarweb.vending.validator;

import org.kesarweb.vending.enums.CoinType;
import org.kesarweb.vending.model.Coin;

public class CoinValidator {

	public Boolean validate(final Coin coin) {

		return CoinType.getValidCoinTypes().contains(coin.getType());
	}

}
