package jugistanbul.pattern.visitor.export.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@JacksonXmlRootElement
public class DiagramXml {

    @JacksonXmlProperty(isAttribute = true)
    private final String name;

    @JacksonXmlProperty(isAttribute = true)
    private final String type;

    private volatile List<PropertyXml> properties;

    public DiagramXml(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public DiagramXml addProperty(PropertyXml property) {
        // TODO : make here thread safe
        properties = nonNull(properties) ? properties : new ArrayList<>();
        properties.add(property);
        return this;
    }

    public String getName() {
        return name;
    }
}
