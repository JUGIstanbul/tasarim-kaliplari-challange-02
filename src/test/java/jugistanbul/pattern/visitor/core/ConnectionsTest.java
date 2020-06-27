package jugistanbul.pattern.visitor.core;

import org.junit.jupiter.api.Test;

import static jugistanbul.pattern.visitor.core.ConnectionType.EXTEND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConnectionsTest {

    @Test
    public void should_add_connection() {
        Diagram diagram1 = new ClassDiagram("Car");
        Diagram diagram2 = new ClassDiagram("Ferrari");
        Connection connection = new Connection(diagram2, diagram1, EXTEND);

        Connections connections = new Connections();
        connections.add(connection);

        assertTrue(connections.has(connection));
    }

    @Test
    public void should_delete_connection() {
        Diagram diagram1 = new ClassDiagram("Car");
        Diagram diagram2 = new ClassDiagram("Ferrari");
        Connection connection = new Connection(diagram2, diagram1, EXTEND);

        Connections connections = new Connections();
        connections.add(connection);
        connections.delete(diagram1);

        assertFalse(connections.has(connection));
    }

    @Test
    public void should_not_contain_duplicated_connection() {
        Diagram diagram1 = new ClassDiagram("Car");
        Diagram diagram2 = new ClassDiagram("Ferrari");
        Connection connection1 = new Connection(diagram2, diagram1, EXTEND);
        Connection connection2 = new Connection(diagram2, diagram1, EXTEND);

        Connections connections = new Connections();
        connections.add(connection1);
        connections.add(connection2);

        assertEquals(1, connections.size());
    }
}
