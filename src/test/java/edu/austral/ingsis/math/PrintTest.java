package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "(1.0 + 6.0)";
    Function function = new Addition(new Number(1), new Number(6));
    Printer printer = new Printer();
    function.accept(printer);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "(12.0 / 2.0)";
    Function function = new Division(new Number(12), new Number(2));
    Printer printer = new Printer();
    function.accept(printer);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "((9.0 / 2.0) * 3.0)";
    Function function = new Multiplication(new Division(new Number(9), new Number(2)),
            new Number(3));
    Printer printer = new Printer();
    function.accept(printer);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "((27.0 / 6.0) ^ 2.0)";
    Function function = new Exponentiation(new Division(new Number(27), new Number(6)),
            new Number(2));
    Printer printer = new Printer();
    function.accept(printer);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "(|value| - 8.0)";
    Function function = new Subtraction(new Absolute(new Variable("value")), new Number(8));
    Printer printer = new Printer();
    function.accept(printer);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "(|value| - 8.0)";
    Function function = new Subtraction(new Absolute(new Variable("value")), new Number(8));
    Printer printer = new Printer();
    function.accept(printer);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "((5.0 - i) * 8.0)";
    Function function = new Multiplication(new Subtraction(new Number(5), new Variable("i")),
            new Number(8));
    Printer printer = new Printer();
    function.accept(printer);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }
}
