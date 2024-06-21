package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double result = 4d;
    Variable x = new Variable("x");
    x.setValue(3);
    Function function = new Addition(new Number(1), x);

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double result = 3d;
    Variable div = new Variable("div");
    div.setValue(4);
    Function function = new Division(new Number(12), div);


    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result = 12d;
    Variable x = new Variable("x");
    x.setValue(3);
    Variable y = new Variable("y");
    y.setValue(4);
    Function function = new Multiplication(new Division(new Number(9), x), y);

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result = 27d;
    Variable a = new Variable("a");
    a.setValue(9);
    Variable b = new Variable("b");
    b.setValue(3);
    Function function = new Exponentiation(new Division(new Number(27), a), b);

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result = 6d;
    Variable z = new Variable("z");
    z.setValue(36);
    Function function = new Root(z);

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result = 0d;
    Variable value = new Variable("value");
    value.setValue(8);
    Function function = new Subtraction(new Absolute(value), new Number(8));

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case |value| - 8 where value = -8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result = 0d;
    Variable value = new Variable("value");
    value.setValue(-8);
    Function function = new Subtraction(new Absolute(value), new Number(8));

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result = 24d;
    Variable i = new Variable("i");
    i.setValue(2);
    Function function = new Multiplication(new Subtraction(new Number(5), i), new Number(8));

    assertThat(result, equalTo(function.evaluate()));
  }
}
