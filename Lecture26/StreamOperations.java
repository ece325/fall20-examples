import java.util.*;
import java.util.stream.*;

public class StreamOperations
{
  public static void main(String[] args) {
    
    List<Integer> list = Arrays.asList(2,7,3,8,4,5);
    List<Integer> square = list.stream().map(x->x*x).collect(Collectors.toList());
    list.forEach(x -> System.out.print(x+", "));
    System.out.println();
    square.forEach(x -> System.out.print(x+", "));

    System.out.println("\n-------------------");
    List<String> names = Arrays.asList("Ada","John","Charles","Alonso");
    List<String> result = names.stream().filter(s->s.startsWith("A")).collect(Collectors.toList());
    result.forEach(x -> System.out.print(x+", "));

    System.out.println("\n-------------------");
    List<String> resultSorted = names.stream().sorted().collect(Collectors.toList());
    resultSorted.forEach(x -> System.out.print(x+", "));
    System.out.println();
    resultSorted.forEach(System.out::println);

    System.out.println("-------------------");
    int even = list.stream().filter(x->x%2==0).reduce(0, (ans,i) -> ans+1);
    System.out.println("Sum of even numbers in the list: "+even);
  }
}