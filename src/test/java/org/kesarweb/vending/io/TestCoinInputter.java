package org.kesarweb.vending.io;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.kesarweb.vending.enums.CoinType;
import org.kesarweb.vending.exception.InvalidCoinException;
import org.kesarweb.vending.external.CoinDetector;
import org.kesarweb.vending.io.CoinInputter;
import org.kesarweb.vending.model.Coin;
import org.kesarweb.vending.validator.CoinValidator;

public class TestCoinInputter {

	private CoinInputter coinInputter;

	private CoinValidator coinValidator;

	private CoinDetector coinDetector;

	@Before
	public void setUp() {
		coinValidator = new CoinValidator();
		coinDetector = new CoinDetector();
		coinInputter = new CoinInputter(coinValidator, coinDetector);
	}

	@Test
	public void shouldAcceptDime() throws InvalidCoinException {
		final Coin coin = new Coin(CoinType.DIME);
		coinInputter.accept(coin);
	}

	@Test
	public void shouldAcceptNickel() throws InvalidCoinException {
		final Coin coin = new Coin(CoinType.NICKEL);
		coinInputter.accept(coin);
	}

	@Test
	public void shouldAcceptQuarter() throws InvalidCoinException {
		final Coin coin = new Coin(CoinType.QUARTER);
		coinInputter.accept(coin);
	}

	@Test(expected = InvalidCoinException.class)
	public void shouldNotAcceptPenny() throws InvalidCoinException {
		final Coin coin = new Coin(CoinType.PENNY);
		coinInputter.accept(coin);
	}

	@Test
	public void shouldIcreamentBalance() throws InvalidCoinException {
		coinInputter.accept(new Coin(CoinType.NICKEL));
		coinInputter.accept(new Coin(CoinType.DIME));
		coinInputter.accept(new Coin(CoinType.QUARTER));
		assertEquals(new Double(40.0), coinInputter.getAmount());
	}
}
