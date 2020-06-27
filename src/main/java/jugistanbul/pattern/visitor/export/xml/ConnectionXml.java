package jugistanbul.pattern.visitor.export.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class ConnectionXml {

    @JacksonXmlProperty(isAttribute = true)
    private final String source;

    @JacksonXmlProperty(isAttribute = true)
    private final String target;

    @JacksonXmlProperty(isAttribute = true)
    private final String type;

    public ConnectionXml(String source, String target, String type) {
        this.source = source;
        this.target = target;
        this.type = type;
    }
}
