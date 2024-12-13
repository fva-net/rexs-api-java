package info.rexs.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.rexs.schema.constants.standard.RexsStandardComponentTypes;

public class IRexsModelTest {

	@Test
	public void testAddAndGetComponent() {
		IRexsModel rexsModel = new RexsSubModel(2);
		RexsComponent component = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsModel.addComponent(component);

		assertEquals(component, rexsModel.getComponent(1));
	}

	@Test
	public void testHasComponent() {
		IRexsModel rexsModel = new RexsSubModel(2);
		RexsComponent component = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsModel.addComponent(component);

		assertTrue(rexsModel.hasComponent(1));
		assertFalse(rexsModel.hasComponent(2));
	}

	@Test
	public void testGetComponents() {
		IRexsModel rexsModel = new RexsSubModel(2);
		RexsComponent component1 = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		RexsComponent component2 = new RexsComponent(2, RexsStandardComponentTypes.cylindrical_gear, null);
		rexsModel.addComponent(component1);
		rexsModel.addComponent(component2);

		assertEquals(2, rexsModel.getComponents().size());
		assertTrue(rexsModel.getComponents().contains(component1));
		assertTrue(rexsModel.getComponents().contains(component2));
		assertEquals(rexsModel.getComponent(1).getName(), component1.getName());
	}
}
