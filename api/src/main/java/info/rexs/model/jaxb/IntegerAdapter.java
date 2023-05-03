package info.rexs.model.jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class IntegerAdapter extends XmlAdapter<String, Integer> {

	@Override
	public Integer unmarshal(String text) {
		return Integer.parseInt(text);
	}

	@Override
	public String marshal(Integer value) {
		if (value == null)
			return null;
		return value.toString();
	}
}
