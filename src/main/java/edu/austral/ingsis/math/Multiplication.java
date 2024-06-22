package edu.austral.ingsis.math;

import java.util.Map;

public class Multiplication implements Function {
  Function left;
  Function right;

  public Multiplication(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public double evaluate(Map<String, Function> variables) {
    return left.evaluate(variables) * right.evaluate(variables);
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
