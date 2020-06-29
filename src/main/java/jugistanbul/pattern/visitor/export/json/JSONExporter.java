package jugistanbul.pattern.visitor.export.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jugistanbul.pattern.visitor.core.Connection;
import jugistanbul.pattern.visitor.core.Diagram;
import jugistanbul.pattern.visitor.core.Property;
import jugistanbul.pattern.visitor.Visitor;

import java.util.HashMap;
import java.util.Map;

public class JSONExporter implements Visitor {

    private final UmlJson uml = new UmlJson();

    private final Map<String, DiagramJson> diagrams = new HashMap<>();

    @Override
    public void visit(Diagram diagram) {
        var diagramJson = new DiagramJson(diagram.getName(), diagram.getType().toString());
        uml.addDiagram(diagramJson);
        diagrams.put(diagramJson.getName(), diagramJson);
    }

    @Override
    public void visit(Property property) {
        var diagramJson = diagrams.get(property.getParent().getName());
        var propertyJson = new PropertyJson(property.getName(), property.getType().toString());
        diagramJson.addProperty(propertyJson);
    }

    @Override
    public void visit(Connection connection) {
        var source = connection.getSource();
        var target = connection.getTarget();

        var connectionJson = new ConnectionJson(source.getName(), target.getName(), connection.getType().toString());
        uml.addConnection(connectionJson);
    }

    public void export() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        System.out.println(mapper.writeValueAsString(uml));
    }
}
