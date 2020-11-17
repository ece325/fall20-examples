import java.util.function.*;

public class LazyExample 
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
    Supplier<Boolean> computeResult = () -> compute(number);
    Supplier<Boolean> processResult = () -> process(number);

    if (computeResult.get() && processResult.get()) {
      System.out.println("TRUE");
    } else {
      System.out.println("FALSE");
    }
  }

}