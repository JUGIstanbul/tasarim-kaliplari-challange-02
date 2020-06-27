package jugistanbul.pattern.visitor.export.ui;

public class PropertyUI implements UI {

    private String text;

    public PropertyUI(String text) {

        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void draw() {
        System.out.println("Draw property box");
        System.out.println("\ttext: "+ text);
        System.out.println("\tposition: x,y");
        System.out.println("\tdimensions: w,h");
    }
}
