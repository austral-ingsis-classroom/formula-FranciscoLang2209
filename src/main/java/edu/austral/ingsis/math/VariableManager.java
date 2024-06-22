package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VariableManager {
  private final Map<String, Variable> variables = new HashMap<>();

  public VariableManager(Function function) {
    extractVariables(function);
  }

  private void extractVariables(Function function) {
    VariableCollectorVisitor visitor = new VariableCollectorVisitor();
    function.accept(visitor);
    Set<String> variableNames = visitor.getVariableNames();
    for (String name : variableNames) {
      variables.putIfAbsent(name, new Variable(name));
    }
  }

  public List<String> getVariables() {
    return new ArrayList<>(variables.keySet());
  }
}
