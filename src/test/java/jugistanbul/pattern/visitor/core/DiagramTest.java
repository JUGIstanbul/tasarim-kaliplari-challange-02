package jugistanbul.pattern.visitor.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static jugistanbul.pattern.visitor.core.ConnectionType.EXTEND;

public class DiagramTest {

    @Test
    public void should_put_connection_into_inbound_of_target() {
        Diagram diagram1 = new ClassDiagram("Car");
        Diagram diagram2 = new ClassDiagram("Ferrari");

        diagram2.connect(diagram1, EXTEND);

        Assertions.assertTrue(diagram1.isConnectedBy(diagram2));
    }

    @Test
    public void should_put_connection_into_outbound_of_source() {
        Diagram diagram1 = new ClassDiagram("Car");
        Diagram diagram2 = new ClassDiagram("Ferrari");

        diagram2.connect(diagram1, EXTEND);

        Assertions.assertTrue(diagram2.isConnectedTo(diagram1));
    }
}
