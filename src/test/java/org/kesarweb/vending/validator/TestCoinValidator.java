package org.kesarweb.vending.validator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.kesarweb.vending.enums.CoinType;
import org.kesarweb.vending.model.Coin;
import org.kesarweb.vending.validator.CoinValidator;

public class TestCoinValidator {

	private CoinValidator coinValidator;

	@Before
	public void setUp() {
		coinValidator = new CoinValidator();
	}

	@Test
	public void shouldValidateNickel() {
		final Coin coin = new Coin(CoinType.NICKEL);
		assertTrue(coinValidator.validate(coin));
	}

	@Test
	public void shouldValidateDime() {
		final Coin coin = new Coin(CoinType.DIME);
		assertTrue(coinValidator.validate(coin));
	}

	@Test
	public void shouldValidateQuarter() {
		final Coin coin = new Coin(CoinType.QUARTER);
		assertTrue(coinValidator.validate(coin));
	}

	@Test
	public void shouldNotValidatePenny() {
		final Coin coin = new Coin(CoinType.PENNY);
		assertFalse(coinValidator.validate(coin));
	}

}
