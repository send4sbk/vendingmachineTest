package org.kesarweb.vending.io;

import org.kesarweb.vending.state.MachineState;
import org.kesarweb.vending.state.subscriber.Subscriber;

public class DisplayUnit implements Subscriber {

	public String showMessage(final String message) {
		System.out.println(">>>> " + message);
		return message;
	}

	public void udpate(MachineState machineState) {
		this.showMessage(machineState.getMessage());
	}

}
