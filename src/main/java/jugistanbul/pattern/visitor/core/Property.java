package jugistanbul.pattern.visitor.core;

import java.util.Objects;

public class Property {

    private final String name;
    private final PropertyType type;
    private final Diagram parent;

    public Property(String name, PropertyType type, Diagram parent) {
        this.name = name;
        this.type = type;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public PropertyType getType() {
        return type;
    }

    public Diagram getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return type.name() + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return name.equals(property.name) &&
                type == property.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

}
