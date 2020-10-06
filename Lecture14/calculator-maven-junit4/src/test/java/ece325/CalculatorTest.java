package ece325;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

public class CalculatorTest {

  private Calculator calculator = new Calculator();

  @Before
  public void clearCalculator() {
    calculator.clear();
  }

  @Test
  public void add() {
    calculator.add(1);
    calculator.add(1);
    assertEquals(2, calculator.getResult(), 0);
  }

  @Test
  public void subtract() {
    calculator.add(10);
    calculator.subtract(3);
    assertEquals(7, calculator.getResult(), 0);
  }

  @Test
  public void divide() {
    calculator.add(8); 
    calculator.divide(2); 
    assertEquals(4, calculator.getResult()); 
  }

  @Test // (expected = ArithmeticException.class)
  public void divideByZero() {
    calculator.add(8); 
    calculator.divide(0); 
  }

  @Ignore("not ready yet")
  @Test
  public void multiply() {
    calculator.add(10); 
    calculator.multiply(10); 
    assertEquals(100, calculator.getResult(), 0); 
  }

  @Test(timeout=1000)
  public void squareRoot() {
    calculator.squareRoot(144);
    assertEquals(12, calculator.getResult(), 0); 
  }
}
