package edu.austral.ingsis.math;

import java.util.Map;

public class Variable implements Function {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        Function function = variables.get(name);
        if (function == null) {
            throw new IllegalStateException("Variable not initialized: " + name);
        }
        return function.evaluate(variables);
    }

    @Override
    public double evaluate() {
        throw new IllegalStateException("Variable not initialized: " + name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }
}
