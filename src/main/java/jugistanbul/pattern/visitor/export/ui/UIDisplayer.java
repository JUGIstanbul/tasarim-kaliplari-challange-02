package jugistanbul.pattern.visitor.export.ui;

import jugistanbul.pattern.visitor.core.Connection;
import jugistanbul.pattern.visitor.core.Diagram;
import jugistanbul.pattern.visitor.core.Property;
import jugistanbul.pattern.visitor.export.Visitor;

import java.util.*;

public class UIDisplayer implements Visitor {

    private Map<String, DiagramUI> diagrams  = new HashMap<>();
    private List<ArrowUI> connections  = new ArrayList<>();

    @Override
    public void visit(Diagram diagram) {
        var ui = new DiagramUI(diagram.getName());
        diagrams.put(diagram.getName(), ui);
        ui.draw();
    }

    @Override
    public void visit(Property property) {
        var diagram = property.getParent();
        var diagramUI = diagrams.get(diagram.getName());
        var ui = new PropertyUI(property.toString());
        diagramUI.addAndRedraw(ui);
    }

    @Override
    public void visit(Connection connection) {
        var source = connection.getSource();
        var target = connection.getTarget();
        var sourceUI = new DiagramUI(source.getName());
        var targetUI = new DiagramUI(target.getName());
        var arrow = new ArrowUI(sourceUI, targetUI, connection.getType());
        arrow.draw();
    }
}
