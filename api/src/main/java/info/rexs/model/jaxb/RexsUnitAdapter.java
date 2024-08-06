package info.rexs.model.jaxb;

import info.rexs.db.constants.RexsUnitId;
import info.rexs.db.constants.standard.RexsStandardUnitIds;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter class to convert between `Integer` and `RexsUnitId` for XML binding.
 * <p>
 * This adapter is used to marshal and unmarshal `RexsUnitId` objects to and from their numeric ID representation in XML.
 */
public class RexsUnitAdapter extends XmlAdapter<Integer, RexsUnitId> {

        @Override
        public RexsUnitId unmarshal(Integer id) {
            return RexsUnitId.findById(id);
        }

        @Override
        public Integer marshal(RexsUnitId unit) {
            if (unit == null)
                return RexsStandardUnitIds.UNKNOWN.getNumericId();
            return unit.getNumericId();
        }
}
