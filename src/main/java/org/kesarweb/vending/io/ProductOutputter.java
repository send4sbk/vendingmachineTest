package org.kesarweb.vending.io;

import org.kesarweb.vending.model.Product;
import org.kesarweb.vending.state.MachineState;
import org.kesarweb.vending.state.subscriber.Subscriber;

public class ProductOutputter implements Subscriber {

	public Product eject(final Product product) {
		System.out.println(">>>>>>>>>>> ejecting" + product);
		return product;
	}

	public void udpate(MachineState machineState) {
		if (machineState.readyToDisposeProduct()) {
			eject(machineState.getSelectedProduct());
			try {
				machineState.productDisposed();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
