public class TestThrow
{
  static int counter = 0;
  static int ok = 0;


  public static double operation1(int n)
  {
    return 25/n;
  }

  public static double operation2(int n) //throws ArithmeticException
  {
    if (n <= 0)
      throw new ArithmeticException("0 is not a valid value");
    return 25/n;
  }

  public static void testDivisible(int n) {
    double result = 0;
    try {
      counter++;
      // result = operation1(n);
      result = operation2(n);
      System.out.println("result: "+result);
      ok++;
    } 
    catch (ArithmeticException e) {
      System.out.println(e);
    }
    finally {
      System.out.println("In finally block, result: "+result +
          " tries: "+counter + " succesfull: "+ok);
    }
  }


  public static void main(String[] args) {
    testDivisible(0);
    testDivisible(5);
  }
}