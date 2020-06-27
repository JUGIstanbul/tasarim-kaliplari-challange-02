package jugistanbul.pattern.visitor.export.json;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class DiagramJson {

    private final String name;

    private final String type;

    private volatile List<PropertyJson> properties;

    public DiagramJson(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public DiagramJson addProperty(PropertyJson property) {
        // TODO : make here thread safe
        properties = nonNull(properties) ? properties : new ArrayList<>();
        properties.add(property);
        return this;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
