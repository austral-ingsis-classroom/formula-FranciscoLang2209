package edu.austral.ingsis.math;

import java.util.Map;

public class Exponentiation implements Function {
  Function base;
  Function exponent;

  public Exponentiation(Function base, Function exponent) {
    this.base = base;
    this.exponent = exponent;
  }

  @Override
  public double evaluate(Map<String, Function> variables) {
    return Math.pow(base.evaluate(variables), exponent.evaluate(variables));
  }

  @Override
  public double evaluate() {
    return Math.pow(base.evaluate(), exponent.evaluate());
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public Function getBase() {
    return base;
  }

  public Function getExponent() {
    return exponent;
  }
}
