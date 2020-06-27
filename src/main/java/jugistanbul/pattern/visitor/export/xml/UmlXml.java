package jugistanbul.pattern.visitor.export.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement
public class UmlXml {

    @JacksonXmlElementWrapper( localName = "diagrams")
    @JacksonXmlProperty(localName = "diagram")
    private List<DiagramXml> diagrams = new ArrayList<>();

    @JacksonXmlElementWrapper( localName = "connections")
    @JacksonXmlProperty(localName = "connection")
    private List<ConnectionXml> connections = new ArrayList<>();

    public UmlXml addDiagram(DiagramXml diagram) {
        this.diagrams.add(diagram);
        return this;
    }

    public UmlXml addConnection(ConnectionXml connection) {
        this.connections.add(connection);
        return this;
    }

    public List<ConnectionXml> getConnections() {
        return connections;
    }

    public List<DiagramXml> getDiagrams() {
        return diagrams;
    }
}
