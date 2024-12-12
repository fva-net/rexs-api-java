package info.rexs.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import info.rexs.schema.constants.RexsAttributeId;
import info.rexs.schema.constants.RexsUnitId;

public class RexsModelTest {

	@Test
	public void rexsModel_constructor_copies_loadSpectrum()  {

		// create a model with a load spectrum
		RexsModel model = new RexsModel("","","");
		RexsLoadSpectrum loadSpectrum = new RexsLoadSpectrum(1);
		RexsLoadSpectrum rexsLoadSpectrum = new RexsLoadSpectrum(loadSpectrum);

		RexsComponent gearUnit = new RexsComponent(1, "gear_unit", "Gear unit [1]");
		gearUnit.addAttribute(RexsAttributeId.findById("operating_time"), 100000.0);
		model.addComponent(gearUnit);
		model.addLoadSpectrum(rexsLoadSpectrum);
	   model.getLoadSpectrums().get(0).addLoadCase(new RexsSubModel(1));
	   model.getLoadSpectrums().get(0).getLoadCase(1).addComponent(new RexsComponent(1, "gear_unit", "Gear unit [1]"));
	   model.getLoadSpectrums().get(0).getLoadCase(1).getComponent(1).addAttribute(RexsAttributeId.findById("operating_time"), 3.0);

        // create a copy of the model
		RexsModel copiedModel = new RexsModel(model);

		assertEquals(1, copiedModel.getLoadSpectrums().size());
		assertEquals(loadSpectrum.getId(), copiedModel.getLoadSpectrums().get(0).getId());
		assertEquals(1, copiedModel.getLoadSpectrums().get(0).getLoadCases().size());
		assertEquals(1, copiedModel.getLoadSpectrums().get(0).getLoadCase(1).getComponents().size());
		assertEquals(gearUnit.getId(), copiedModel.getLoadSpectrums().get(0).getLoadCase(1).getComponent(1).getId());
		assertNotEquals(gearUnit.getAttribute("operating_time"), copiedModel.getLoadSpectrums().get(0).getLoadCase(1).getComponent(1).getAttribute("operating_time"));
		assertEquals(3.0, copiedModel.getLoadSpectrums().get(0).getLoadCase(1).getComponent(1).getAttribute("operating_time").getDoubleValue(RexsUnitId.hour), 0.0);







	}
}
