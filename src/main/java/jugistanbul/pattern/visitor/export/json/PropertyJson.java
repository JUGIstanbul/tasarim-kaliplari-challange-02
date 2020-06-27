package jugistanbul.pattern.visitor.export.json;

public class PropertyJson {

    private final String name;

    private final String type;

    public PropertyJson(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
