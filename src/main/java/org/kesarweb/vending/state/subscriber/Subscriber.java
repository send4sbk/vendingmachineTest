package org.kesarweb.vending.state.subscriber;

import org.kesarweb.vending.state.MachineState;

public interface Subscriber {

	public void udpate(final MachineState machineState);

}
