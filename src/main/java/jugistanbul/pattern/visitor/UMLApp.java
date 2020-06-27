package jugistanbul.pattern.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import jugistanbul.pattern.visitor.core.*;
import jugistanbul.pattern.visitor.export.json.JSONExporter;
import jugistanbul.pattern.visitor.export.ui.UIDisplayer;
import jugistanbul.pattern.visitor.export.xml.XMLExporter;

import static jugistanbul.pattern.visitor.core.ConnectionType.EXTEND;

public class UMLApp {

    public static void main(String[] args) throws JsonProcessingException {

        UML uml = new UML();

        var car = new ClassDiagram("Car");
        var ferrari = new ClassDiagram("Ferrari");
        var mustang = new ClassDiagram("Mustang");

        ferrari.connect(car, EXTEND);
        mustang.connect(car, EXTEND);

        car.addProperty("color", PropertyType.STRING);
        car.addProperty("speed", PropertyType.DOUBLE);
        car.addProperty("price", PropertyType.FLOAT);

        ferrari.addProperty("flying", PropertyType.BOOLEAN);
        mustang.addProperty("swimming", PropertyType.BOOLEAN);

        uml.addDiagram(car).addDiagram(ferrari).addDiagram(mustang);

        var uiDisplayer = new UIDisplayer();
        uml.accept(uiDisplayer);

        var xmlExporter = new XMLExporter();
        uml.accept(xmlExporter);
        xmlExporter.export();

        var jsonExporter = new JSONExporter();
        uml.accept(jsonExporter);
        jsonExporter.export();

    }
}
