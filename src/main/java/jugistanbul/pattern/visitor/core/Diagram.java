package jugistanbul.pattern.visitor.core;

import jugistanbul.pattern.visitor.export.Visitable;

public abstract class Diagram implements Visitable {

    private final String name;
    private Connections inbound = new Connections();
    private Connections outbound = new Connections();

    public Diagram(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract DiagramType getType();

    protected Connections getOutboundConnections() {
        return outbound;
    }

    public Connection connect(Diagram target, ConnectionType type) {
        Connection connection = new Connection(this, target, type);
        outbound.add(connection);
        target.inbound.add(connection);
        return connection;
    }

    public void disconnect(Diagram target) {
        outbound.delete(target);
        target.inbound.delete(target);
    }

    public boolean isConnectedBy(Diagram source) {
        return inbound.hasConnectionFrom(source);
    }

    public boolean isConnectedTo(Diagram target) {
        return outbound.hasConnectionTo(target );
    }
}
