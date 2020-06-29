package jugistanbul.pattern.visitor.core;

import jugistanbul.pattern.visitor.Visitor;

public class ClassDiagram extends Diagram {

    private Properties properties = new Properties();

    public ClassDiagram(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public DiagramType getType() {
        return DiagramType.CLASS;
    }

    public Properties getProperties() {
        return properties;
    }

    public Property addProperty(String name, PropertyType type) {
        var property = new Property(name, type, this);
        properties.add(property);
        return property;
    }

    public int getPropertySize() {
        return properties.size();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        properties.accept(visitor);
        getOutboundConnections().accept(visitor);
    }
}
