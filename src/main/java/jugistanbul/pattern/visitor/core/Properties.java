package jugistanbul.pattern.visitor.core;

import jugistanbul.pattern.visitor.Visitable;
import jugistanbul.pattern.visitor.Visitor;

import java.util.*;

public class Properties implements Visitable {

    private Set<Property> list = new HashSet<>();

    public Optional<Property> getByName(String name) {
        return list.stream().filter(p->name.equals(p.getName())).findFirst();
    }

    public void add(Property property) {
        this.list.add(property);
    }

    public void delete(Property property) {
        list.remove(property);
    }

    public int size() {
        return list.size();
    }

    @Override
    public void accept(Visitor visitor) {
        list.forEach(p->visitor.visit(p));
    }
}
