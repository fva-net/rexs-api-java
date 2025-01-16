package info.rexs.model.jaxb;

import info.rexs.schema.constants.RexsVersion;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter class to convert between {@link String} and {@link RexsVersion} for XML binding. This adapter is used to marshal and unmarshal {@link RexsVersion}
 */
public class RexsVersionAdapter extends XmlAdapter<String, RexsVersion> {

	@Override
	public String marshal(final RexsVersion v) {
		if (v == null) {
			return null;
		}
		return v.getModelVersion();
	}

	@Override
	public RexsVersion unmarshal(final String v) {
		return RexsVersion.findByModelVersion(v);
	}
}
