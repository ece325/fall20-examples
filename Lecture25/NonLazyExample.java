public class NonLazyExample 
{

  public static boolean compute(int number) {
    System.out.println("computing number : " + number);
    return number > 5 ? true : false;
  }

  public static boolean process(int number) {
    System.out.println("processing number : " + number);
    return number % 3 == 0 ? true : false;
  }

  public static void main(String[] args) {
    int number = 6;
    boolean computeResult = compute(number);
    boolean processResult = process(number);

    if (computeResult && processResult) {
      System.out.println("TRUE");
    } else {
      System.out.println("FALSE");
    }
  }

}