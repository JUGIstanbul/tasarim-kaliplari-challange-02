package jugistanbul.pattern.visitor.export;

import jugistanbul.pattern.visitor.core.*;
import jugistanbul.pattern.visitor.export.ui.UIDisplayer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static jugistanbul.pattern.visitor.core.ConnectionType.EXTEND;
import static jugistanbul.pattern.visitor.core.PropertyType.STRING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


// NOT THREAD SAFE
public class UIDisplayerTest {

    private ByteArrayOutputStream baos;
    private PrintStream newOut;
    private PrintStream oldOut;

    @BeforeEach
    public void init() {
        this.baos = new ByteArrayOutputStream();
        this.newOut = new PrintStream(baos);

        this.oldOut = System.out;
        System.setOut(newOut);
    }

    @AfterEach
    public void close() {
        newOut.close();
        System.setOut(oldOut);
    }

    @Test
    public void should_display_diagram() {

        var car = new ClassDiagram("Car");

        var displayer = new UIDisplayer();

        displayer.visit(car);

        assertEquals("Draw diagram box\n" +
                "\tname: Car\n" +
                "\tposition: x,y\n" +
                "\tdimensions: w,h\n", baos.toString());

    }

    @Test
    public void should_display_property() {

        var car = new ClassDiagram("Car");
        Property property = car.addProperty("color", STRING);

        var displayer = new UIDisplayer();
        displayer.visit(car);
        displayer.visit(property);

        assertEquals("Draw diagram box\n" +
                    "\tname: Car\n" +
                    "\tposition: x,y\n" +
                    "\tdimensions: w,h\n" +
                    "Add property box of STRING color\n" +
                    "\tCalc position of new box\n" +
                    "\tResize diagram Car\n" +
                    "\tRedraw diagram\n" +
                    "Draw property box\n" +
                    "\ttext: STRING color\n" +
                    "\tposition: x,y\n" +
                    "\tdimensions: w,h\n" +
                    "",
                    baos.toString()
                );
    }

    @Test
    public void should_display_connection() {

        var car = new ClassDiagram("Car");
        var ferrari = new ClassDiagram("Ferrari");
        var connection = ferrari.connect(car, EXTEND);

        var displayer = new UIDisplayer();
        displayer.visit(connection);

        assertEquals("Draw arrow: Ferrari->Car\n" +
                        "\tcalc start point\n" +
                        "\tcalc end point\n" +
                        "\tappy style of EXTEND\n" +
                        "",
                baos.toString()
        );
    }
}
