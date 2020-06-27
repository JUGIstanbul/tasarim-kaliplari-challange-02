package jugistanbul.pattern.visitor.export;

import jugistanbul.pattern.visitor.core.*;

public interface Visitor {

    void visit(Diagram diagram);

    void visit(Property property);

    void visit(Connection connection);
}
