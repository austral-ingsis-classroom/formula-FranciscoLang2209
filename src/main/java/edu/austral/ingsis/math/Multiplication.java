package edu.austral.ingsis.math;

public class Multiplication implements Function {
    Function left;
    Function right;

    public Multiplication(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Function getLeft() {
        return left;
    }

    public Function getRight() {
        return right;
    }
}
