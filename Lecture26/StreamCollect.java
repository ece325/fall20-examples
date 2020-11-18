import java.util.*;
import java.util.stream.*;

public class StreamCollect
{
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Ada","John","Charles","Alonso");

    // Collectors.joining
    String result = names.stream().map(String::toLowerCase).collect(Collectors.joining(", "));
    System.out.println("Names: "+result);


    // // Collectors.partitioningBy
    // List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 3);
    // Map<Boolean, List<Integer>> isEven = intList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
    // System.out.print("Even numbers in list: ");
    // isEven.get(true).stream().forEach(e -> System.out.print(e+","));
    // System.out.print("\nOdd numbers in list: ");
    // isEven.get(false).stream().forEach(e -> System.out.print(e+","));


    // // Collectors.groupingBy
    // Map<Character, List<String>> groupByAlphabet = names.stream().collect(Collectors.groupingBy(e -> e.charAt(0)));
    // for (Character key : groupByAlphabet.keySet()) {
    //   System.out.print("\nlist of names starting with "+key+": ");
    //   groupByAlphabet.get(key).stream().forEach(e -> System.out.print(e+","));
    // }
  }
}