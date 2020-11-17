import java.util.*;
import java.util.function.*;

public class Closure
{

  public static void main(String[] args) {
  
    BiFunction<Integer,Integer,Integer> plus = (a,b) -> a+b;
    int value10 = 10;
    Function plus10fn = b -> plus.apply(value10, (Integer)b);

    Consumer plus10 = b -> { 
      System.out.print(plus10fn.apply(b) + ", ");
    };

    System.out.println("plus10(8) = " + plus10fn.apply(8));
    plus10.accept(8);
    System.out.println("\n---------------");

    List<Integer> list = Arrays.asList(4,3,6,7,2,1,5);
    list.forEach(System.out::println);
    System.out.println("\n---------------");
    list.forEach(plus10);
  }
}