package edu.austral.ingsis.math;

import java.util.Map;

public class Number implements Function {
    double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return value;
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
