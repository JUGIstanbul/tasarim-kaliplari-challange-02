package jugistanbul.pattern.visitor.export.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jugistanbul.pattern.visitor.core.Connection;
import jugistanbul.pattern.visitor.core.Diagram;
import jugistanbul.pattern.visitor.core.Property;
import jugistanbul.pattern.visitor.export.Visitor;

import java.util.HashMap;
import java.util.Map;

public class XMLExporter implements Visitor {

    private final UmlXml uml = new UmlXml();

    private final Map<String, DiagramXml> diagrams = new HashMap<>();

    @Override
    public void visit(Diagram diagram) {
        var diagramXml = new DiagramXml(diagram.getName(), diagram.getType().toString());
        uml.addDiagram(diagramXml);
        diagrams.put(diagramXml.getName(), diagramXml);
    }

    @Override
    public void visit(Property property) {
        var diagramXml = diagrams.get(property.getParent().getName());
        var propertyXml = new PropertyXml(property.getName(), property.getType().toString());
        diagramXml.addProperty(propertyXml);
    }

    @Override
    public void visit(Connection connection) {
        var source = connection.getSource();
        var target = connection.getTarget();

        var connectionXml = new ConnectionXml(source.getName(), target.getName(), connection.getType().toString());
        uml.addConnection(connectionXml);
    }

    public void export() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(mapper.writeValueAsString(uml));
    }
}
