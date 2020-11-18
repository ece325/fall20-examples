import java.util.*;
import java.util.stream.*;

public class ParallelStream
{
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(4,3,6,7,2,1,5,9,11,2,34,7,31,5,7,8);

    list.stream().forEach(e -> System.out.print(e+","));
    System.out.println("\n-------------------");
    list.stream().parallel().forEach(e -> System.out.print(e+","));
    System.out.println("\n-------------------");
    list.parallelStream().forEach(e -> System.out.print(e+","));

  }
}