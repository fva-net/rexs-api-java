package info.rexs.model.jaxb;

import info.rexs.db.constants.RexsValueType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RexsValueTypeAdapterTest {

    private static final RexsValueTypeAdapter ADAPTER = new RexsValueTypeAdapter();

    @Test
    public void unmarshal_givenValidNumericId_returnsCorrectRexsValueType() {
        assertThat(ADAPTER.unmarshal(2)).isEqualTo(RexsValueType.BOOLEAN);
    }

    @Test
    public void unmarshal_givenInvalidNumericId_returnsNull() {
        assertThat(ADAPTER.unmarshal(-1)).isNull();
    }

    @Test
    public void marshal_givenValidRexsValueType_returnsCorrectNumericId() {
        assertThat(ADAPTER.marshal(RexsValueType.ENUM)).isEqualTo(4);
    }

    @Test
    public void marshal_givenNullRexsValueType_returnsNull() {
        assertThat(ADAPTER.marshal(null)).isNull();
    }
}