package edu.austral.ingsis.math;

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

    public void setVariableValue(String name, double value) {
        Variable variable = variables.get(name);
        if (variable == null) {
            throw new IllegalArgumentException("Variable not found: " + name);
        }
        variable.setValue(value);
    }

    public List<String> getVariables() {
        return variables.keySet().stream().toList();
    }
}