package jugistanbul.pattern.visitor.core;

import jugistanbul.pattern.visitor.export.Visitor;

import java.util.HashSet;
import java.util.Set;

public class Connections {

    private Set<Connection> list = new HashSet<>();

    public void add(Connection connection) {
        list.add(connection);
    }

    public void delete(Diagram target) {
        list.removeIf(c->c.isTo(target));
    }

    public boolean has(Connection connection) {
        return list.contains(connection);
    }

    public int size() {
        return list.size();
    }

    public boolean hasConnectionFrom(Diagram source) {
        return list.stream().anyMatch(c->c.isFrom(source));
    }

    public boolean hasConnectionTo(Diagram target) {
        return list.stream().anyMatch(c->c.isTo(target));
    }

    public void accept(Visitor visitor) {
        list.forEach(c->visitor.visit(c));
    }
}
