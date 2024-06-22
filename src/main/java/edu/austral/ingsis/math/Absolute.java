package edu.austral.ingsis.math;

import java.util.Map;

public class Absolute implements Function {
    Function base;

    public Absolute(Function base) {
        this.base = base;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return Math.abs(base.evaluate(variables));
    }

    @Override
    public double evaluate() {
        return Math.abs(base.evaluate());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Function getBase() {
        return base;
    }
}
