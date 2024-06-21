package edu.austral.ingsis.math;

public class Subtraction implements Function {
    Function left;
    Function right;

    public Subtraction(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        left.accept(visitor);
        right.accept(visitor);
    }

    public Function getLeft() {
        return left;
    }

    public Function getRight() {
        return right;
    }
}
