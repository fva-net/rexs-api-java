package info.rexs.model.jaxb;

import static org.assertj.core.api.Assertions.assertThat;

import info.rexs.db.constants.RexsUnitId;
import info.rexs.db.constants.standard.RexsStandardUnitIds;
import org.junit.Test;

public class RexsUnitAdapterTest {

    private static final RexsUnitAdapter ADAPTER = new RexsUnitAdapter();

    @Test
    public void unmarshal_ShouldReturnCorrectRexsUnitId_WhenIdIsValid() {
        assertThat(ADAPTER.unmarshal(32)).isEqualTo(RexsUnitId.hertz);
    }

    @Test
    public void unmarshal_ShouldReturnUnknown_WhenIdIsInvalid() {
        assertThat(ADAPTER.unmarshal(Integer.MAX_VALUE)).isEqualTo(RexsStandardUnitIds.UNKNOWN);
    }

    @Test
    public void marshal_ShouldReturnNumericId_WhenUnitIsValid() {
        assertThat(ADAPTER.marshal(RexsUnitId.kilo_newton)).isEqualTo(5);
    }

    @Test
    public void marshal_ShouldReturnZero_WhenUnitIsNull() {
        assertThat(ADAPTER.marshal(null)).isZero();
    }
}
