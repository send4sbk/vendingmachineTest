package org.kesarweb.vending;

import java.util.List;

import org.kesarweb.vending.exception.InvalidCoinException;
import org.kesarweb.vending.exception.ProductOutOfStockException;
import org.kesarweb.vending.external.CoinDetector;
import org.kesarweb.vending.inventory.CoinInventoryManager;
import org.kesarweb.vending.inventory.ProductInventoryManager;
import org.kesarweb.vending.io.CoinInputter;
import org.kesarweb.vending.io.CoinOutputter;
import org.kesarweb.vending.io.DisplayUnit;
import org.kesarweb.vending.io.Keyboard;
import org.kesarweb.vending.io.ProductOutputter;
import org.kesarweb.vending.model.Coin;
import org.kesarweb.vending.model.Product;
import org.kesarweb.vending.state.MachineState;
import org.kesarweb.vending.validator.CoinValidator;

public class Machine {

	private MachineState machineState = new MachineState();
	private CoinInputter coinInputter = new CoinInputter(new CoinValidator(), new CoinDetector());
	private CoinOutputter coinOutputter = new CoinOutputter();
	private DisplayUnit displayUnit = new DisplayUnit();
	private Keyboard keyboard = new Keyboard(this);
	private ProductInventoryManager productInventoryManager = new ProductInventoryManager();
	private CoinInventoryManager coinInventoryManager = new CoinInventoryManager();
	private ProductOutputter productOutputter = new ProductOutputter();

	public Machine() {
		machineState.register(displayUnit);
		machineState.register(productOutputter);
		displayUnit.showMessage(machineState.getMessage());
	}

	public void acceptCoin(final Coin coin) throws InvalidCoinException {
		coinInputter.accept(coin);
		machineState.setAmount(coinInputter.getAmount());
		if (coinInputter.getAmount().doubleValue() > machineState.getSelectedProduct().getPrice().doubleValue()) {
			coinOutputter.eject(coinInputter.returnMoney());
			machineState = new MachineState();
			machineState.register(displayUnit);
			machineState.register(productOutputter);
			displayUnit.showMessage(machineState.getMessage());
		}
	}

	public Keyboard getKeyboard() {
		return this.keyboard;
	}

	public void selectProduct(final Integer code) throws ProductOutOfStockException {
		if (Keyboard.cancelCode.intValue() == code.intValue()) {
			coinOutputter.eject(coinInputter.returnMoney());
			machineState = new MachineState();
			machineState.register(displayUnit);
			machineState.register(productOutputter);
			displayUnit.showMessage(machineState.getMessage());
		} else {
			final Product product = productInventoryManager.getProduct(code);
			machineState.setSelectedProduct(product);
		}
	}

	public void loadProducts(final List<Product> products) {
		productInventoryManager.load(products);
	}

}
