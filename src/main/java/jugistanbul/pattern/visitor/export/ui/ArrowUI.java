package jugistanbul.pattern.visitor.export.ui;

import jugistanbul.pattern.visitor.core.ConnectionType;

public class ArrowUI implements UI {

    private final DiagramUI sourceUI;
    private final DiagramUI targetUI;
    private final ConnectionType type;

    public ArrowUI(DiagramUI sourceUI, DiagramUI targetUI, ConnectionType type) {

        this.sourceUI = sourceUI;
        this.targetUI = targetUI;
        this.type = type;
    }

    @Override
    public void draw() {
        System.out.println("Draw arrow: "+ sourceUI.getName() +"->"+targetUI.getName());
        System.out.println("\tcalc start point");
        System.out.println("\tcalc end point");
        System.out.println("\tappy style of "+type);
    }
}
