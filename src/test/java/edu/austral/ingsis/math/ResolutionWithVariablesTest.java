package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double result = 4d;
    Function function = new Addition(new Number(1), new Variable("x"));
    Map<String, Function> variables = new HashMap<>();
    variables.put("x", new Number(3));

    assertThat(result, equalTo(function.evaluate(variables)));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double result = 3d;
    Function function = new Division(new Number(12), new Variable("div"));
    Map<String, Function> variables = new HashMap<>();
    variables.put("div", new Number(4));

    assertThat(result, equalTo(function.evaluate(variables)));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result = 12d;
    Function function =
        new Multiplication(new Division(new Number(9), new Variable("x")), new Variable("y"));
    Map<String, Function> variables = new HashMap<>();
    variables.put("x", new Number(3));
    variables.put("y", new Number(4));

    assertThat(result, equalTo(function.evaluate(variables)));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result = 27d;
    Function function =
        new Exponentiation(new Division(new Number(27), new Variable("a")), new Variable("b"));
    Map<String, Function> variables = new HashMap<>();
    variables.put("a", new Number(9));
    variables.put("b", new Number(3));

    assertThat(result, equalTo(function.evaluate(variables)));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result = 6d;
    Function function = new Root(new Variable("z"));
    Map<String, Function> variables = new HashMap<>();
    variables.put("z", new Number(36));

    assertThat(result, equalTo(function.evaluate(variables)));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result = 0d;
    Function function = new Subtraction(new Absolute(new Variable("value")), new Number(8));
    Map<String, Function> variables = new HashMap<>();
    variables.put("value", new Number(8));

    assertThat(result, equalTo(function.evaluate(variables)));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result = 0d;
    Function function = new Subtraction(new Absolute(new Variable("value")), new Number(8));
    Map<String, Function> variables = new HashMap<>();
    variables.put("value", new Number(8));

    assertThat(result, equalTo(function.evaluate(variables)));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result = 24d;
    Function function =
        new Multiplication(new Subtraction(new Number(5), new Variable("i")), new Number(8));
    Map<String, Function> variables = new HashMap<>();
    variables.put("i", new Number(2));

    assertThat(result, equalTo(function.evaluate(variables)));
  }
}
