public class TestTryCatchFinally
{
  static int counter = 0;
  static int ok = 0;

  public static void testDivisible(int n) {
    double result = 0;
    try {
      counter++;
      result = 25 / n;
      System.out.println("result: "+result);
      ok++;
    } 
    catch (Exception e) {
      System.out.println("0 is not valid");
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