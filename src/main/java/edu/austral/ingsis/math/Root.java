package edu.austral.ingsis.math;

public class Root implements Function {
    Function base;

    public Root(Function base) {
        this.base = base;
    }

    @Override
    public double evaluate() {
        return Math.sqrt(base.evaluate());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        base.accept(visitor);
    }

    public Function getBase() {
        return base;
    }
}
