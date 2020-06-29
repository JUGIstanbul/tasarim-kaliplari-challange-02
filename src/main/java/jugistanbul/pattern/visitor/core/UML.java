package jugistanbul.pattern.visitor.core;

import jugistanbul.pattern.visitor.Visitable;
import jugistanbul.pattern.visitor.Visitor;

import java.util.HashSet;
import java.util.Set;

public class UML implements Visitable {

    private Set<Diagram> diagrams = new HashSet<>();

    public UML addDiagram(Diagram diagram) {
        this.diagrams.add(diagram);
        return this;
    }

    public void accept(Visitor visitor) {
        diagrams.forEach(d->d.accept(visitor));
    }
}
