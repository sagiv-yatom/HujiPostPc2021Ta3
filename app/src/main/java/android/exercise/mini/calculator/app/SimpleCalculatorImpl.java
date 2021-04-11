package android.exercise.mini.calculator.app;

import java.io.Serializable;

public class SimpleCalculatorImpl implements SimpleCalculator {

  // todo: add fields as needed
  private String out = "0";

  @Override
  public String output() {
    // todo: return output based on the current state
    return out;
  }

  @Override
  public void insertDigit(int digit) {
    // todo: insert a digit
    if (0 <= digit && digit <= 9) {
      if (out.equals("0")) {
        out = String.valueOf(digit);
      }
      else {
        out += String.valueOf(digit);
      }
    }
    else {
      throw new IllegalArgumentException("digit is a char between 0-9");
    }
  }

  @Override
  public void insertPlus() {
    // todo: insert a plus
    int lastIndex = out.length() - 1;
    if (out.charAt(lastIndex) != '+' && out.charAt(lastIndex) != '-') {
      out += "+";
    }
  }

  @Override
  public void insertMinus() {
    // todo: insert a minus
    int lastIndex = out.length() - 1;
    if (out.charAt(lastIndex) != '+' && out.charAt(lastIndex) != '-') {
      out += "-";
    }
  }

  public static int insertEqualsHelper(String expression) {
    int i = 1;

    if (expression.equals("+") || expression.equals("-")) {
      return 0;
    }

    while (i < expression.length() &&
            expression.charAt(i) != '+'  &&
            expression.charAt(i) != '-') {
      i += 1;
    }

    if (i == expression.length()) {
      return Integer.parseInt(expression);
    }

    int numInt = Integer.parseInt(expression.substring(0, i));

    return numInt + insertEqualsHelper(expression.substring(i));
  }

  @Override
  public void insertEquals() {
    // todo: calculate the equation. after calling `insertEquals()`, the output should be the result
    //  e.g. given input "14+3", calling `insertEquals()`, and calling `output()`, output should be "17"
    int result = insertEqualsHelper(out);
    out = Integer.toString(result);
  }

  @Override
  public void deleteLast() {
    // todo: delete the last input (digit, plus or minus)
    //  e.g.
    //  if input was "12+3" and called `deleteLast()`, then delete the "3"
    //  if input was "12+" and called `deleteLast()`, then delete the "+"
    //  if no input was given, then there is nothing to do here
    if (out.length() > 1) {
      out = out.substring(0, out.length() - 1);
    }
    else { // out.length() == 1
      out = "0";
    }
  }

  @Override
  public void clear() {
    // todo: clear everything (same as no-input was never given)
    out = "0";
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    // todo: insert all data to the state, so in the future we can load from this state
    state.history = out;
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    // todo: use the CalculatorState to load
    out = casted.history;
  }

  private static class CalculatorState implements Serializable {
    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
    public String history;
  }
}
