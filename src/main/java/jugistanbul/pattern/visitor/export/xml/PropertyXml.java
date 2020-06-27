package jugistanbul.pattern.visitor.export.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class PropertyXml {

    @JacksonXmlProperty(isAttribute = true)
    private final String name;

    @JacksonXmlProperty(isAttribute = true)
    private final String type;

    public PropertyXml(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
