package edu.austral.ingsis.math;

import java.util.HashMap;
import java.util.Map;

public class VariableManager {
    private final Map<String, Variable> variables = new HashMap<>();

    public Variable getVariable(String name) {
        return variables.computeIfAbsent(name, Variable::new);
    }

    public void setVariableValue(String name, double value) {
        Variable variable = getVariable(name);
        variable.setValue(value);
    }

    public double evaluateVariable(String name) {
        Variable variable = variables.get(name);
        if (variable == null) {
            throw new IllegalArgumentException("Variable not found: " + name);
        }
        return variable.evaluate();
    }
}
