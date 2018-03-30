package org.kesarweb.vending.io;

import org.kesarweb.vending.Machine;
import org.kesarweb.vending.exception.ProductOutOfStockException;

public class Keyboard {

	public static final Integer cancelCode = -999;

	private Machine machine;

	public Keyboard(final Machine machine) {
		this.machine = machine;
	}

	public void one() throws ProductOutOfStockException {
		machine.selectProduct(1);
	}

	public void two() throws ProductOutOfStockException {
		machine.selectProduct(2);
	}

	public void three() throws ProductOutOfStockException {
		machine.selectProduct(3);
	}

	public void cancel() throws ProductOutOfStockException {
		machine.selectProduct(cancelCode);
	}
}
