package edu.austral.ingsis.math;

import java.util.HashSet;
import java.util.Set;

public class VariableCollectorVisitor implements Visitor {
  private final Set<String> variableNames = new HashSet<>();

  @Override
  public void visit(Addition sum) {
    sum.getLeft().accept(this);
    sum.getRight().accept(this);
  }

  @Override
  public void visit(Subtraction subtraction) {
    subtraction.getLeft().accept(this);
    subtraction.getRight().accept(this);
  }

  @Override
  public void visit(Multiplication multiplication) {
    multiplication.getLeft().accept(this);
    multiplication.getRight().accept(this);
  }

  @Override
  public void visit(Division division) {
    division.getNumerator().accept(this);
    division.getDenominator().accept(this);
  }

  @Override
  public void visit(Root root) {
    root.getBase().accept(this);
  }

  @Override
  public void visit(Exponentiation exponentiation) {
    exponentiation.getBase().accept(this);
    exponentiation.getExponent().accept(this);
  }

  @Override
  public void visit(Absolute absolute) {
    absolute.getBase().accept(this);
  }

  @Override
  public void visit(Number number) {
    // Numbers don't have variable names
  }

  @Override
  public void visit(Variable variable) {
    variableNames.add(variable.getName());
  }

  public Set<String> getVariableNames() {
    return variableNames;
  }
}
