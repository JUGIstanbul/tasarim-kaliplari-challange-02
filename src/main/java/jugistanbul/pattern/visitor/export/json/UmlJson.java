package jugistanbul.pattern.visitor.export.json;

import java.util.ArrayList;
import java.util.List;

public class UmlJson {

    private List<DiagramJson> diagrams = new ArrayList<>();

    private List<ConnectionJson> connections = new ArrayList<>();

    public UmlJson addDiagram(DiagramJson diagram) {
        this.diagrams.add(diagram);
        return this;
    }

    public UmlJson addConnection(ConnectionJson connection) {
        this.connections.add(connection);
        return this;
    }

    public List<ConnectionJson> getConnections() {
        return connections;
    }

    public List<DiagramJson> getDiagrams() {
        return diagrams;
    }
}
