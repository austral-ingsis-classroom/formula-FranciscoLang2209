package edu.austral.ingsis.math;

import java.util.Map;

public class Division implements Function {
     Function numerator;
     Function denominator;

    public Division(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return numerator.evaluate(variables) / denominator.evaluate(variables);
    }

    @Override
    public double evaluate() {
        return numerator.evaluate() / denominator.evaluate();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Function getNumerator() {
        return numerator;
    }

    public Function getDenominator() {
        return denominator;
    }
}
