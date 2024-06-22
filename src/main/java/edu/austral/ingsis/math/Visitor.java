package edu.austral.ingsis.math;

public interface Visitor {
  void visit(Addition sum);

  void visit(Subtraction subtraction);

  void visit(Multiplication multiplication);

  void visit(Division division);

  void visit(Root root);

  void visit(Exponentiation exponentiation);

  void visit(Absolute absolute);

  void visit(Number number);

  void visit(Variable variable);
}
