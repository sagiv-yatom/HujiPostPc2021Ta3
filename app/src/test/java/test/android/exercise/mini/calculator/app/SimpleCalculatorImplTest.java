package test.android.exercise.mini.calculator.app;

import android.exercise.mini.calculator.app.SimpleCalculatorImpl;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SimpleCalculatorImplTest {

  @Test
  public void when_noInputGiven_then_outputShouldBe0(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_inputIsPlus_then_outputShouldBe0Plus(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertPlus();
    assertEquals("0+", calculatorUnderTest.output());
  }

  @Test
  public void when_inputIsMinus_then_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertMinus();
    String expected = "0-"; // TODO: decide the expected output when having a single minus
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_thereIsNoEqualsYet_then_outputShouldBeCorrect_forSimpleInput(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertMinus();
    assertEquals("4-", calculatorUnderTest.output());
  }

  @Test
  public void when_thereIsNoEqualsYet_then_outputShouldBeCorrect_forComplicatedInput(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.clear();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertDigit(6);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(8);
    assertEquals("0-45+388", calculatorUnderTest.output());
  }

  @Test
  public void when_thereIsAnEquals_then_outputShouldBeCorrect_forSimpleInput(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertEquals();
    assertEquals("-1", calculatorUnderTest.output());
  }

  @Test
  public void when_thereIsAnEquals_then_outputShouldBeCorrect_forComplicatedInput1(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.clear();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus();
    assertEquals("0-45+", calculatorUnderTest.output());
  }

  @Test
  public void when_thereIsAnEquals_then_outputShouldBeCorrect_forComplicatedInput2(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.clear();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertDigit(6);
    assertEquals("0-45+386", calculatorUnderTest.output());
  }

  @Test
  public void when_thereIsAnEquals_then_outputShouldBeCorrect_forComplicatedInput3(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.clear();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertDigit(6);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertEquals();
    assertEquals("343", calculatorUnderTest.output());
  }

  @Test
  public void when_thereIsAnEquals_then_outputShouldBeCorrect_forComplicatedInput4(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertEquals();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertDigit(8);
    assertEquals("348-88", calculatorUnderTest.output());
  }

  @Test
  public void when_inputHasMinusMinusOrders_then_onlyFirstOrderSeenInOutput(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertMinus();
    assertEquals("4-", calculatorUnderTest.output());
  }

  @Test
  public void when_inputHasMinusPlusOrders_then_onlyFirstOrderSeenInOutput(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertPlus();
    assertEquals("4-", calculatorUnderTest.output());
  }

  @Test
  public void when_inputHasPlusPlusOrders_then_onlyFirstOrderSeenInOutput(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertPlus();
    assertEquals("4+", calculatorUnderTest.output());
  }

  @Test
  public void when_inputHasPlusMinusOrders_then_onlyFirstOrderSeenInOutput(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus();
    assertEquals("4+", calculatorUnderTest.output());
  }

  @Test
  public void when_callingInsertDigitWithIllegalNumber_then_exceptionShouldBeThrown(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    try {
      calculatorUnderTest.insertDigit(357);
      fail("should throw an exception and not reach this line");
    } catch (RuntimeException e) {
      // good :)
    }
  }

  @Test
  public void when_callingDeleteLast_then_lastOutputShouldBeDeleted(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();

    // test with no initialized input
    calculatorUnderTest.deleteLast();
    assertEquals("0", calculatorUnderTest.output());

    // test with input.length() > 1
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.deleteLast();
    assertEquals("5", calculatorUnderTest.output());

    // test with input.length() == 1
    calculatorUnderTest.deleteLast();
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_callingClear_then_outputShouldBeCleared(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();

    // test with no initialized input
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    // test with initialized input
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_savingState_should_loadThatStateCorrectly(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();

    // give some input
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);

    // save current state
    Serializable savedState = calculatorUnderTest.saveState();
    assertNotNull(savedState);

    // call `clear` and make sure calculator cleared
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    // load the saved state and make sure state was loaded correctly
    calculatorUnderTest.loadState(savedState);
    assertEquals("5+7", calculatorUnderTest.output());
  }

  @Test
  public void when_savingStateFromFirstCalculator_should_loadStateCorrectlyFromSecondCalculator(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();
    // TODO: implement the test based on this method's name.
    //  you can get inspiration from the test method `when_savingState_should_loadThatStateCorrectly()`

    // give some input
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(5);
    firstCalculator.insertPlus();
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(7);
    firstCalculator.insertDigit(3);
    firstCalculator.insertDigit(2);
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(1);

    secondCalculator.insertDigit(9);

    // save current state
    Serializable savedState = firstCalculator.saveState();
    assertNotNull(savedState);

    // load the saved state to secondCalculator and make sure state was loaded correctly
    secondCalculator.loadState(savedState);
    assertEquals("0-5+732-1", secondCalculator.output());
  }

  // TODO:
  //  the existing tests are not enough since they only test simple use-cases with small inputs.
  //  write at least 10 methods to test correct behavior with complicated inputs or use-cases.
  //  examples:
  //  - given input "5+7-13<DeleteLast>25", expected output is "5+17-125"
  //  - given input "9<Clear>12<Clear>8-7=", expected output is "1"
  //  - given input "8-7=+4=-1=", expected output is "4"
  //  - given input "999-888-222=-333", expected output is "-111-333"
  //  - with 2 calculators, give them different inputs, then save state on first calculator and load the state into second calculator, make sure state loaded well
  //  etc etc.
  //  feel free to be creative in your tests!
}