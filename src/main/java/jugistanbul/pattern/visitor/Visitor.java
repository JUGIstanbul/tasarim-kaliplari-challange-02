package jugistanbul.pattern.visitor;

import jugistanbul.pattern.visitor.core.*;

public interface Visitor {

    void visit(Diagram diagram);

    void visit(Property property);

    void visit(Connection connection);
}
