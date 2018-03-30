package org.kesarweb.vending;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kesarweb.vending.enums.CoinType;
import org.kesarweb.vending.exception.InvalidCoinException;
import org.kesarweb.vending.exception.ProductOutOfStockException;
import org.kesarweb.vending.model.Coin;
import org.kesarweb.vending.model.Product;

public class TestMachine {

	private Machine machine;

	@Before
	public void setUp() {
		machine = new Machine();
	}

	@Test(expected = InvalidCoinException.class)
	public void shouldRejectPenny() throws InvalidCoinException {
		final Coin coin = new Coin(CoinType.PENNY);
		machine.acceptCoin(coin);
	}

	@Test(expected = ProductOutOfStockException.class)
	public void shouldThrowProductOutOfStockException() throws ProductOutOfStockException {
		machine.getKeyboard().one();
	}

	@Test
	public void shouldCancelProductSelection() throws ProductOutOfStockException, InvalidCoinException {
		setupCola();
		machine.getKeyboard().one();
		final Coin coin = new Coin(CoinType.QUARTER);
		machine.acceptCoin(coin);
		machine.getKeyboard().cancel();
	}

	@Test
	public void shouldEjectCola() throws ProductOutOfStockException, InvalidCoinException {
		setupCola();
		machine.getKeyboard().one();
		machine.acceptCoin(new Coin(CoinType.QUARTER));
		machine.acceptCoin(new Coin(CoinType.QUARTER));
		machine.acceptCoin(new Coin(CoinType.QUARTER));
		machine.acceptCoin(new Coin(CoinType.QUARTER));
	}

	@Test
	public void shouldEjectCoinWhenNoExactChange() throws ProductOutOfStockException, InvalidCoinException {
		setupCandy();
		machine.getKeyboard().three();
		machine.acceptCoin(new Coin(CoinType.QUARTER));
		machine.acceptCoin(new Coin(CoinType.QUARTER));
		machine.acceptCoin(new Coin(CoinType.QUARTER));
	}

	private void setupCola() {

		final List<Product> products = new ArrayList<Product>();
		final Product product = new Product();
		product.setCode(1);
		product.setName("Cola");
		product.setPrice(1.0);
		for (int i = 0; i < 5; i++) {
			products.add(product);
		}
		machine.loadProducts(products);
	}

	private void setupCandy() {

		final List<Product> products = new ArrayList<Product>();
		final Product product = new Product();
		product.setCode(3);
		product.setName("Candy");
		product.setPrice(.65);
		for (int i = 0; i < 5; i++) {
			products.add(product);
		}
		machine.loadProducts(products);
	}
}
