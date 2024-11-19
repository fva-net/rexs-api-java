/*
 * Copyright (C) 2020 FVA GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package info.rexs.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

import info.rexs.schema.constants.standard.RexsStandardAttributeIds;
import info.rexs.schema.constants.standard.RexsStandardUnitIds;

public class RexsAttributeTest {

	@Test
	public void attributeIdConstructor_getterMatchesValuePassedToConstructor() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);

		assertThat(rexsAttribute.getAttributeId()).isEqualTo(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		assertThat(rexsAttribute.getUnit()).isEqualTo(RexsStandardUnitIds.hertz);
	}

	@Test
	public void attributeIdConstructor_originIdCreated() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);

		assertThat(rexsAttribute.getOriginAttributeId()).isNotNull();
		assertThat(rexsAttribute.getOriginAttributeId()).isEqualTo(RexsStandardAttributeIds.overrolling_frequency_rolling_element.getId());
	}

	@Test
	public void hasValue_emptyValueReturnsFalse() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);

		assertThat(rexsAttribute.hasValue()).isFalse();
	}

	@Test
	public void hasValue_emptyStringValueReturnsFalse() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringValue("");

		assertThat(rexsAttribute.hasValue()).isFalse();
	}

	@Test
	public void hasValue_setStringValueReturnsTrue() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringValue("foo_bar");

		assertThat(rexsAttribute.hasValue()).isTrue();
	}

	@Test
	public void hasValue_emptyStringArrayValueReturnsFalse() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringArrayValue(new String[] {});

		assertThat(rexsAttribute.hasValue()).isFalse();
	}

	@Test
	public void hasValue_setStringArrayValueReturnsTrue() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringArrayValue(new String[] {"foo", "bar"});

		assertThat(rexsAttribute.hasValue()).isTrue();
	}

	@Test
	public void hasValue_emptyStringMatrixValueReturnsFalse() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);

		rexsAttribute.setStringMatrixValue(new String[][] {});
		assertThat(rexsAttribute.hasValue()).isFalse();

		rexsAttribute.setStringMatrixValue(new String[][] {});
		assertThat(rexsAttribute.hasValue()).isFalse();
	}

	@Test
	public void hasValue_setStringMatrixValueReturnsTrue() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringMatrixValue(new String[][] {{"foo"}, {"bar"}});

		assertThat(rexsAttribute.hasValue()).isTrue();
	}

	@Test
	public void getStringValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getStringValue();
		})
				.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getStringValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringValue("foo_bar");

		assertThat(rexsAttribute.getStringValue()).isEqualTo("foo_bar");
	}

	@Test
	public void getBooleanValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getBooleanValue();
		})
				.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getBooleanValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);

		rexsAttribute.setBooleanValue(Boolean.TRUE);
		assertThat(rexsAttribute.getBooleanValue()).isTrue();

		rexsAttribute.setBooleanValue(Boolean.FALSE);
		assertThat(rexsAttribute.getBooleanValue()).isFalse();
	}

	@Test
	public void getIntegerValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getIntegerValue();
		})
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getIntegerValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setIntegerValue(42);

		assertThat(rexsAttribute.getIntegerValue()).isEqualTo(42);
	}

	@Test
	public void getDoubleValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getDoubleValue(RexsStandardUnitIds.hertz);
		})
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getDoubleValue_setValueButWrongUnitThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.setDoubleValue(8.24);
			rexsAttribute.getDoubleValue(RexsStandardUnitIds.degree_celsius);
		})
		.withMessageStartingWith("incompatible units");
	}

	@Test
	public void getDoubleValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setDoubleValue(8.24);

		assertThat(rexsAttribute.getDoubleValue(RexsStandardUnitIds.hertz)).isEqualTo(8.24);
	}

	@Test
	public void getStringArrayValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getStringArrayValue();
		})
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getStringArrayValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringArrayValue(new String[] {"foo", "bar"});

		assertThat(rexsAttribute.getStringArrayValue()).isEqualTo(new String[] {"foo", "bar"});
	}

	@Test
	public void getBooleanArrayValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getBooleanArrayValue();
		})
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getBooleanArrayValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setBooleanArrayValue(new Boolean[] {Boolean.FALSE, Boolean.TRUE});

		assertThat(rexsAttribute.getBooleanArrayValue()).isEqualTo(new Boolean[] {Boolean.FALSE, Boolean.TRUE});
	}

	@Test
	public void getIntegerArrayValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getIntegerArrayValue();
		})
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getIntegerArrayValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setIntegerArrayValue(new Integer[] {42, 23});

		assertThat(rexsAttribute.getIntegerArrayValue()).isEqualTo(new Integer[] {42, 23});
	}

	@Test
	public void getDoubleArrayValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getDoubleArrayValue(RexsStandardUnitIds.hertz);
		})
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getDoubleArrayValue_setValueButWrongUnitThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.setDoubleArrayValue(new Double[] {8.24, 23.33});
			rexsAttribute.getDoubleArrayValue(RexsStandardUnitIds.degree_celsius);
		})
		.withMessageStartingWith("incompatible units");
	}

	@Test
	public void getDoubleArrayValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setDoubleArrayValue(new Double[] {8.24, 23.33});

		assertThat(rexsAttribute.getDoubleArrayValue(RexsStandardUnitIds.hertz)).isEqualTo(new Double[] {8.24, 23.33});
	}

	@Test
	public void getStringMatrixValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getStringMatrixValue();
		})
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getStringMatrixValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringMatrixValue(new String[][] {{"foo"}, {"bar"}});

		assertThat(rexsAttribute.getStringMatrixValue()).isEqualTo(new String[][] {{"foo"}, {"bar"}});
	}

	@Test
	public void getBooleanMatrixValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getBooleanMatrixValue();
		})
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getBooleanMatrixValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setBooleanMatrixValue(new Boolean[][] {{Boolean.FALSE}, {Boolean.TRUE}});

		assertThat(rexsAttribute.getBooleanMatrixValue()).isEqualTo(new Boolean[][] {{Boolean.FALSE}, {Boolean.TRUE}});
	}

	@Test
	public void getIntegerMatrixValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getIntegerMatrixValue();
		})
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getIntegerMatrixValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setIntegerMatrixValue(new Integer[][] {{42}, {23}});

		assertThat(rexsAttribute.getIntegerMatrixValue()).isEqualTo(new Integer[][] {{42}, {23}});
	}

	@Test
	public void getDoubleMatrixValue_emptyValueThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.getDoubleMatrixValue(RexsStandardUnitIds.hertz);
		})
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void getDoubleMatrixValue_setValueButWrongUnitThrowsRexsModelAccessException() {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
			rexsAttribute.setDoubleMatrixValue(new Double[][] {{8.24}, {23.33}});
			rexsAttribute.getDoubleMatrixValue(RexsStandardUnitIds.degree_celsius);
		})
		.withMessageStartingWith("incompatible units");
	}

	@Test
	public void getDoubleMatrixValue_setValueIsReturned() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setDoubleMatrixValue(new Double[][] {{8.24}, {23.33}});

		assertThat(rexsAttribute.getDoubleMatrixValue(RexsStandardUnitIds.hertz)).isEqualTo(new Double[][] {{8.24}, {23.33}});
	}

	@Test
	public void setStringArrayValue_nullValueDeletesPreviousValue() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringArrayValue(new String[] {"foo", "bar"});

		rexsAttribute.setStringArrayValue(null);

		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(rexsAttribute::getStringArrayValue)
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void setStringArrayValue_nullElementConvertsToEmptyString() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringArrayValue(new String[] {"foo", null, "bar"});

		assertThat(rexsAttribute.getStringArrayValue()).isEqualTo(new String[] {"foo", "", "bar"});
	}

	@Test
	public void setStringMatrixValue_nullValueDeletesPreviousValue() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringMatrixValue(new String[][] {{"foo"}, {"bar"}});

		rexsAttribute.setStringMatrixValue(null);

		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(rexsAttribute::getStringMatrixValue)
		.withMessageStartingWith("value cannot be null for attribute");
	}

	@Test
	public void setStringMatrixValue_nullElementConvertsToEmptyString() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringMatrixValue(new String[][] {{"foo", null}, {"bar", ""}});

		assertThat(rexsAttribute.getStringMatrixValue()).isEqualTo(new String[][] {{"foo", ""}, {"bar", ""}});
	}

	@Test
	public void setStringMatrixValue_nullMatrixRowConvertsToNullElements() {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_rolling_element);
		rexsAttribute.setStringMatrixValue(new String[][] {{"foo", "bar"}, null});

		assertThat(rexsAttribute.getStringMatrixValue()).isEqualTo(new String[][] {{"foo", "bar"}, {null, null}});
	}
}
