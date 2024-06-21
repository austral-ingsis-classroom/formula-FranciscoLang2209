package edu.austral.ingsis.math;

public interface Function {
    double evaluate();
    void accept(Visitor visitor);
}
