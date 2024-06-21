package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function function = new Addition(new Number(1), new Number(6));
    VariableManager variableManager = new VariableManager(function);
    final List<String> result = variableManager.getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function function = new Division(new Number(12), new Variable("div"));
    VariableManager variableManager = new VariableManager(function);
    final List<String> result = variableManager.getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function function = new Multiplication(new Division(new Number(9),
            new Variable("x")), new Variable("y"));
    VariableManager variableManager = new VariableManager(function);
    final List<String> result = variableManager.getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function function = new Exponentiation(new Division(new Number(27),
            new Variable("a")), new Variable("b"));
    VariableManager variableManager = new VariableManager(function);
    final List<String> result = variableManager.getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function function = new Root(new Variable("z"));
    VariableManager variableManager = new VariableManager(function);
    final List<String> result = variableManager.getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function function = new Subtraction(new Absolute(new Variable("value")), new Number(8));
    VariableManager variableManager = new VariableManager(function);
    final List<String> result = variableManager.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function function = new Subtraction(new Absolute(new Variable("value")), new Number(8));
    VariableManager variableManager = new VariableManager(function);
    final List<String> result = variableManager.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function function = new Multiplication(new Subtraction(new Number(5),
            new Variable("i")), new Number(8));
    VariableManager variableManager = new VariableManager(function);
    final List<String> result = variableManager.getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
