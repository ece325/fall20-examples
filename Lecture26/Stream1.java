import java.util.*;
import java.util.function.*;

public class Stream1
{
  public static int sumGreaterThan10(List<Integer> list) {
    Iterator<Integer> it = list.iterator();
    int sum = 0;
    while (it.hasNext()) {
      int num = it.next();
      if (num > 10) {
        sum += num;
      }
    }
    return sum;
  }

  public static int sumGreaterThan10Stream(List<Integer> list) {
    return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
  }
  
  
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(4,31,6,2,17,20,1,5);

    int greaterThan10 = sumGreaterThan10(list);
    System.out.println("Sum of elements greater than 10: "+ greaterThan10);

    int greaterThan10Stream = sumGreaterThan10Stream(list);
    System.out.println("Sum of elements greater than 10 (Stream): "+ greaterThan10Stream);

    list.forEach(x -> System.out.print(x+", "));

  }
}