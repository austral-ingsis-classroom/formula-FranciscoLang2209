package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = 7d;
    Function function = new Addition(new Number(1), new Number(6));

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = 6d;
    Function function = new Division(new Number(12), new Number(2));

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result = 13.5;
    Function function = new Multiplication(new Division(new Number(9), new Number(2)), new Number(3));

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result = 20.25;
    Function function = new Exponentiation(new Division(new Number(27), new Number(6)),
            new Number(2));

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result = 6d;
    Function function = new Exponentiation(new Number(36),
            new Division(new Number(1), new Number(2)));

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = 136d;
    Function function = new Absolute(new Number(136));

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = 136d;
    Function function = new Absolute(new Number(-136));

    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result = 0d;
    Function function = new Multiplication(new Subtraction(new Number(5), new Number(5)),
            new Number(8));

    assertThat(result, equalTo(function.evaluate()));
  }
}
