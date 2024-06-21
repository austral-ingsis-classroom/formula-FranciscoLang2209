package edu.austral.ingsis.math;

public class Number implements Function {
    double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getValue() {
        return value;
    }
}
