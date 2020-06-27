package jugistanbul.pattern.visitor.export.ui;

public class DiagramUI implements UI {

    private String name;

    public DiagramUI(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void draw() {
        System.out.println("Draw diagram box");
        System.out.println("\tname: "+ name);
        System.out.println("\tposition: x,y");
        System.out.println("\tdimensions: w,h");
    }

    public void addAndRedraw(PropertyUI propertyUI) {
        System.out.println("Add property box of " + propertyUI.getText());
        System.out.println("\tCalc position of new box");
        System.out.println("\tResize diagram "+ name);
        System.out.println("\tRedraw diagram");
        propertyUI.draw();
    }
}
