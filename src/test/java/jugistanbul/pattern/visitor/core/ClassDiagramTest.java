package jugistanbul.pattern.visitor.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static jugistanbul.pattern.visitor.core.PropertyType.STRING;

public class ClassDiagramTest {

    @Test
    public void should_add_property() {
        ClassDiagram clazz = new ClassDiagram("Car");

        clazz.addProperty("color", STRING);
        clazz.addProperty("maker", STRING);

        Assertions.assertEquals(2, clazz.getPropertySize());
    }
}
