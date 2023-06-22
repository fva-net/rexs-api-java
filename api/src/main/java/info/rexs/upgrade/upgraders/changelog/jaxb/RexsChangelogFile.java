package info.rexs.upgrade.upgraders.changelog.jaxb;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

public class RexsChangelogFile {

	@XmlRootElement(name = "rexsChangelog")
	public static class RexsChangelog {
	    @XmlAttribute(name = "fromVersion", required = true)
	    public String fromVersion;
	    @XmlAttribute(name = "toVersion", required = true)
	    public String toVersion;

		@XmlElementWrapper(name="componentChanges")
		@XmlElement(name = "componentChange")
	    public List<ComponentChange> componentChanges = new ArrayList<>();
		@XmlElementWrapper(name="attributeChanges")
		@XmlElement(name = "attributeChange")
	    public List<AttributeChange> attributeChanges = new ArrayList<>();
		@XmlElementWrapper(name="mappingChanges")
		@XmlElement(name = "mappingChange")
	    public List<MappingChange> mappingChanges = new ArrayList<>();

	}
	
	public static RexsChangelog load(InputStream input) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(RexsChangelog.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		RexsChangelog changelog = (RexsChangelog)unmarshaller.unmarshal(input);
		return changelog;
	}
}
