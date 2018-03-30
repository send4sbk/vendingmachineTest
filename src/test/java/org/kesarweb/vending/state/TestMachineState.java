package org.kesarweb.vending.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.kesarweb.vending.enums.State;
import org.kesarweb.vending.state.MachineState;

public class TestMachineState {

	private MachineState machineState;

	@Before
	public void setUp() {
		this.machineState = new MachineState();
	}

	@Test
	public void shouldShowDefaultMessage() {
		assertEquals(State.NO_CHANGE_DEFAULT.getMessage(), machineState.getMessage());
	}

	@Test
	public void shouldInitProperly() {
		assertEquals(State.NO_CHANGE_DEFAULT.getMessage(), machineState.getMessage());
		assertNull(machineState.getSelectedProduct());
		assertNull(machineState.getAmount());
	}
}
