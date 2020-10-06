
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import java.time.Duration;

public class CalculatorTest {

  private Calculator calculator = new Calculator();

  @BeforeEach
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
    assertEquals(5, calculator.getResult()); 
  }

  @Test
  public void divideByZero() {
    calculator.add(8); 
    Throwable exception = assertThrows(ArithmeticException.class, () -> { calculator.divide(0); } ); 
  }

  @Disabled("not ready yet")
  @Test
  public void multiply() {
    calculator.add(10); 
    calculator.multiply(10); 
    assertEquals(100, calculator.getResult(), 0); 
  }

  @Test
  public void squareRoot() {
    assertTimeoutPreemptively(Duration.ofMillis(100), () -> { calculator.squareRoot(144); } );
    assertEquals(12, calculator.getResult(), 0); 
  }
}
