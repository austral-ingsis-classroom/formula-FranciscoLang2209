package edu.austral.ingsis.math;

import java.util.Map;

public class Root implements Function {
    Function base;

    public Root(Function base) {
        this.base = base;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return Math.sqrt(base.evaluate(variables));
    }

    @Override
    public double evaluate() {
        return Math.sqrt(base.evaluate());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Function getBase() {
        return base;
    }
}
