public class Calculator {

  private int result;

  public void add(int n) {
    result = result + n;
  }

  public void subtract(int i) {
    result = result - i;
  }

  public void multiply(int n) {}

  public void divide(int n) {
    result = result / n;
  }

  public void square(int n) {
    result = n * n;
  }

  public void squareRoot(int n) {
    for(;;);
  }

  public void clear() {
    result = 0;
  }

  public void swithOn() {
    clear();
  }

  public void switchOff() { }

  /**
   * @return the result
   */
  public int getResult() {
    return result;
  }
}