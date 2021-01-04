/*******************************************************************************
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
 ******************************************************************************/
package info.rexs.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.Test;

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.db.constants.RexsUnitId;
import info.rexs.model.jaxb.Attribute;

public class RexsAttributeTest {

	@Test
	public void rawAttributeConstructor_getterMatchesValuePassedToConstructor() throws Exception {
		Attribute rawAttribute = new Attribute();
		rawAttribute.setId(RexsAttributeId.overrolling_frequency_rolling_element.getId());
		rawAttribute.setUnit(RexsUnitId.hertz.getId());
		RexsAttribute rexsAttribute = new RexsAttribute(rawAttribute);

		assertThat(rexsAttribute.getRawAttribute()).isEqualTo(rawAttribute);
	}

	@Test
	public void rawAttributeConstructor_incompatibleUnitsThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Attribute rawAttribute = new Attribute();
			rawAttribute.setId(RexsAttributeId.overrolling_frequency_rolling_element.getId());
			rawAttribute.setUnit(RexsUnitId.degree.getId());
			new RexsAttribute(rawAttribute);
		})
		.withMessageStartingWith("incompatible units");
	}

	@Test
	public void attributeIdConstructor_getterMatchesValuePassedToConstructor() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);

		assertThat(rexsAttribute.getAttributeId()).isEqualTo(RexsAttributeId.overrolling_frequency_rolling_element);
		assertThat(rexsAttribute.getUnit()).isEqualTo(RexsUnitId.hertz);
	}

	@Test
	public void attributeIdConstructor_rawAttributeIdCreated() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);

		assertThat(rexsAttribute.getRawAttribute()).isNotNull();
		assertThat(rexsAttribute.getRawAttribute().getId()).isEqualTo(RexsAttributeId.overrolling_frequency_rolling_element.getId());
		assertThat(rexsAttribute.getRawAttribute().getUnit()).isEqualTo(RexsUnitId.hertz.getId());
	}

	@Test
	public void hasValue_emptyValueReturnsFalse() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);

		assertThat(rexsAttribute.hasValue()).isFalse();
	}

	@Test
	public void hasValue_emptyStringValueReturnsFalse() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringValue("");

		assertThat(rexsAttribute.hasValue()).isFalse();
	}

	@Test
	public void hasValue_setStringValueReturnsTrue() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringValue("foo_bar");

		assertThat(rexsAttribute.hasValue()).isTrue();
	}

	@Test
	public void hasValue_emptyStringArrayValueReturnsFalse() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringArrayValue(new String[] {});

		assertThat(rexsAttribute.hasValue()).isFalse();
	}

	@Test
	public void hasValue_setStringArrayValueReturnsTrue() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringArrayValue(new String[] {"foo", "bar"});

		assertThat(rexsAttribute.hasValue()).isTrue();
	}

	@Test
	public void hasValue_emptyStringMatrixValueReturnsFalse() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);

		rexsAttribute.setStringMatrixValue(new String[][] {});
		assertThat(rexsAttribute.hasValue()).isFalse();

		rexsAttribute.setStringMatrixValue(new String[][] {{}});
		assertThat(rexsAttribute.hasValue()).isFalse();
	}

	@Test
	public void hasValue_setStringMatrixValueReturnsTrue() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringMatrixValue(new String[][] {{"foo"}, {"bar"}});

		assertThat(rexsAttribute.hasValue()).isTrue();
	}

	@Test
	public void getStringValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getStringValue();
		})
		.withMessage("string value cannot be null");
	}

	@Test
	public void getStringValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringValue("foo_bar");

		assertThat(rexsAttribute.getStringValue()).isEqualTo("foo_bar");
	}

	@Test
	public void getBooleanValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getBooleanValue();
		})
		.withMessage("boolean value cannot be null");
	}

	@Test
	public void getBooleanValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);

		rexsAttribute.setBooleanValue(Boolean.TRUE);
		assertThat(rexsAttribute.getBooleanValue()).isTrue();

		rexsAttribute.setBooleanValue(Boolean.FALSE);
		assertThat(rexsAttribute.getBooleanValue()).isFalse();
	}

	@Test
	public void getIntegerValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getIntegerValue();
		})
		.withMessage("integer value cannot be null");
	}

	@Test
	public void getIntegerValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setIntegerValue(42);

		assertThat(rexsAttribute.getIntegerValue()).isEqualTo(42);
	}

	@Test
	public void getDoubleValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getDoubleValue(RexsUnitId.hertz);
		})
		.withMessage("double value cannot be null");
	}

	@Test
	public void getDoubleValue_setValueButWrongUnitThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.setDoubleValue(8.24);
			rexsAttribute.getDoubleValue(RexsUnitId.degree_celsius);
		})
		.withMessageStartingWith("incompatible units");
	}

	@Test
	public void getDoubleValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setDoubleValue(8.24);

		assertThat(rexsAttribute.getDoubleValue(RexsUnitId.hertz)).isEqualTo(8.24);
	}

	@Test
	public void getStringArrayValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getStringArrayValue();
		})
		.withMessage("string array value cannot be null");
	}

	@Test
	public void getStringArrayValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringArrayValue(new String[] {"foo", "bar"});

		assertThat(rexsAttribute.getStringArrayValue()).isEqualTo(new String[] {"foo", "bar"});
	}

	@Test
	public void getBooleanArrayValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getBooleanArrayValue();
		})
		.withMessage("boolean array value cannot be null");
	}

	@Test
	public void getBooleanArrayValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setBooleanArrayValue(new Boolean[] {Boolean.FALSE, Boolean.TRUE});

		assertThat(rexsAttribute.getBooleanArrayValue()).isEqualTo(new Boolean[] {Boolean.FALSE, Boolean.TRUE});
	}

	@Test
	public void getIntegerArrayValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getIntegerArrayValue();
		})
		.withMessage("integer array value cannot be null");
	}

	@Test
	public void getIntegerArrayValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setIntegerArrayValue(new Integer[] {42, 23});

		assertThat(rexsAttribute.getIntegerArrayValue()).isEqualTo(new Integer[] {42, 23});
	}

	@Test
	public void getDoubleArrayValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getDoubleArrayValue(RexsUnitId.hertz);
		})
		.withMessage("double array value cannot be null");
	}

	@Test
	public void getDoubleArrayValue_setValueButWrongUnitThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.setDoubleArrayValue(new Double[] {8.24, 23.33});
			rexsAttribute.getDoubleArrayValue(RexsUnitId.degree_celsius);
		})
		.withMessageStartingWith("incompatible units");
	}

	@Test
	public void getDoubleArrayValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setDoubleArrayValue(new Double[] {8.24, 23.33});

		assertThat(rexsAttribute.getDoubleArrayValue(RexsUnitId.hertz)).isEqualTo(new Double[] {8.24, 23.33});
	}

	@Test
	public void getStringMatrixValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getStringMatrixValue();
		})
		.withMessage("string matrix value cannot be null");
	}

	@Test
	public void getStringMatrixValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringMatrixValue(new String[][] {{"foo"}, {"bar"}});

		assertThat(rexsAttribute.getStringMatrixValue()).isEqualTo(new String[][] {{"foo"}, {"bar"}});
	}

	@Test
	public void getBooleanMatrixValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getBooleanMatrixValue();
		})
		.withMessage("boolean matrix value cannot be null");
	}

	@Test
	public void getBooleanMatrixValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setBooleanMatrixValue(new Boolean[][] {{Boolean.FALSE}, {Boolean.TRUE}});

		assertThat(rexsAttribute.getBooleanMatrixValue()).isEqualTo(new Boolean[][] {{Boolean.FALSE}, {Boolean.TRUE}});
	}

	@Test
	public void getIntegerMatrixValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getIntegerMatrixValue();
		})
		.withMessage("integer matrix value cannot be null");
	}

	@Test
	public void getIntegerMatrixValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setIntegerMatrixValue(new Integer[][] {{42}, {23}});

		assertThat(rexsAttribute.getIntegerMatrixValue()).isEqualTo(new Integer[][] {{42}, {23}});
	}

	@Test
	public void getDoubleMatrixValue_emptyValueThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.getDoubleMatrixValue(RexsUnitId.hertz);
		})
		.withMessage("double matrix value cannot be null");
	}

	@Test
	public void getDoubleMatrixValue_setValueButWrongUnitThrowsRexsModelAccessException() throws Exception {
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
			rexsAttribute.setDoubleMatrixValue(new Double[][] {{8.24}, {23.33}});
			rexsAttribute.getDoubleMatrixValue(RexsUnitId.degree_celsius);
		})
		.withMessageStartingWith("incompatible units");
	}

	@Test
	public void getDoubleMatrixValue_setValueIsReturned() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setDoubleMatrixValue(new Double[][] {{8.24}, {23.33}});

		assertThat(rexsAttribute.getDoubleMatrixValue(RexsUnitId.hertz)).isEqualTo(new Double[][] {{8.24}, {23.33}});
	}

	@Test
	public void setStringArrayValue_nullValueIgnoresMethodCall() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringArrayValue(new String[] {"foo", "bar"});

		rexsAttribute.setStringArrayValue(null);

		assertThat(rexsAttribute.getStringArrayValue()).isEqualTo(new String[] {"foo", "bar"});
	}

	@Test
	public void setStringArrayValue_nullElementConvertsToEmptyString() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringArrayValue(new String[] {"foo", null, "bar"});

		assertThat(rexsAttribute.getStringArrayValue()).isEqualTo(new String[] {"foo", "", "bar"});
	}

	@Test
	public void setStringMatrixValue_nullValueIgnoresMethodCall() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringMatrixValue(new String[][] {{"foo"}, {"bar"}});

		rexsAttribute.setStringMatrixValue(null);

		assertThat(rexsAttribute.getStringMatrixValue()).isEqualTo(new String[][] {{"foo"}, {"bar"}});
	}

	@Test
	public void setStringMatrixValue_nullElementConvertsToEmptyString() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringMatrixValue(new String[][] {{"foo", null}, {"bar", ""}});

		assertThat(rexsAttribute.getStringMatrixValue()).isEqualTo(new String[][] {{"foo", ""}, {"bar", ""}});
	}

	@Test
	public void setStringMatrixValue_nullMatrixRowConvertsToNullElements() throws Exception {
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.overrolling_frequency_rolling_element);
		rexsAttribute.setStringMatrixValue(new String[][] {{"foo", "bar"}, null});

		assertThat(rexsAttribute.getStringMatrixValue()).isEqualTo(new String[][] {{"foo", "bar"}, {null, null}});
	}
}
