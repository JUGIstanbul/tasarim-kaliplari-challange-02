package jugistanbul.pattern.visitor.export.json;

public class ConnectionJson {

    private final String source;

    private final String target;

    private final String type;

    public ConnectionJson(String source, String target, String type) {
        this.source = source;
        this.target = target;
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public String getType() {
        return type;
    }
}
