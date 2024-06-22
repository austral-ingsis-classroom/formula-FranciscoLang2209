package edu.austral.ingsis.math;

import java.util.Map;

public interface Function {
  double evaluate(Map<String, Function> variables);

  double evaluate();

  void accept(Visitor visitor);
}
