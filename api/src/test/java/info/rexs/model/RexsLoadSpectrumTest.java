package info.rexs.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class RexsLoadSpectrumTest {

	@Test
	public void testCopyConstructor() {
		RexsSubModel subModel1 = new RexsSubModel(1);
		RexsSubModel subModel2 = new RexsSubModel(2);

		RexsLoadSpectrum originalSpectrum = new RexsLoadSpectrum(100);
		originalSpectrum.addLoadCase(subModel1);
		originalSpectrum.addLoadCase(subModel2);
		originalSpectrum.setAccumulation(new RexsSubModel(3, true));

		RexsLoadSpectrum copiedSpectrum = new RexsLoadSpectrum(originalSpectrum);

		// Verify the ID
		assertEquals(originalSpectrum.getId(), copiedSpectrum.getId());

		// Verify the load cases
		assertEquals(originalSpectrum.getLoadCases().size(), copiedSpectrum.getLoadCases().size());
		RexsSubModel copiedSubModel1 = copiedSpectrum.getLoadCase(subModel1.getId());
		assertNotNull(copiedSubModel1);
		assertEquals(subModel1.getId(), copiedSubModel1.getId());
		assertEquals(subModel1.isAccumulation(), copiedSubModel1.isAccumulation());

		RexsSubModel copiedSubModel2 = copiedSpectrum.getLoadCase(subModel2.getId());
		assertNotNull(copiedSubModel2);
		assertEquals(subModel2.getId(), copiedSubModel2.getId());
		assertEquals(subModel2.isAccumulation(), copiedSubModel2.isAccumulation());

		// Verify the accumulation
		assertNotNull(copiedSpectrum.getAccumulation());
		assertEquals(originalSpectrum.getAccumulation().getId(), copiedSpectrum.getAccumulation().getId());
		assertEquals(originalSpectrum.getAccumulation().isAccumulation(), copiedSpectrum.getAccumulation().isAccumulation());
	}
}
