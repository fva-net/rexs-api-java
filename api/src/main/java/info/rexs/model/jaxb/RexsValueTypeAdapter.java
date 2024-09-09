package info.rexs.model.jaxb;

import info.rexs.db.constants.RexsValueType;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter class to convert between {@link Integer} and {@link RexsValueType}  for XML binding.
 * <p>
 * This adapter is used to marshal and unmarshal {@link RexsValueType}  objects to and from their numeric ID representation in XML.
 */
public class RexsValueTypeAdapter extends XmlAdapter<Integer, RexsValueType> {

    @Override
    public RexsValueType unmarshal(Integer v) {
        return RexsValueType.findByNumericId(v);
    }

    @Override
    public Integer marshal(RexsValueType v) {
        if (v == null) {
            return null;
        }
        return v.getNumericId();
    }
}