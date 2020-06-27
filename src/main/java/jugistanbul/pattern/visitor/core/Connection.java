package jugistanbul.pattern.visitor.core;

import java.util.Objects;

public class Connection {

    private final Diagram source;
    private final Diagram target;
    private final ConnectionType type;

    public Connection(Diagram source, Diagram target, ConnectionType type) {
        this.source = source;
        this.target = target;
        this.type = type;
    }


    public Diagram getSource() {
        return source;
    }

    public ConnectionType getType() {
        return type;
    }

    public Diagram getTarget() {
        return target;
    }



    public boolean isTo(Diagram diagram) {
        return this.target.equals(diagram);
    }

    public boolean isFrom(Diagram source) {
        return this.source.equals(source);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return source.equals(that.source) &&
                target.equals(that.target) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target, type);
    }
}
