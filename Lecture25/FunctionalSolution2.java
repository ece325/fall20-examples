import java.util.*;

class FunctionalSolution2
{
  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(4,3,6,7,2,1,5);

    list.forEach(x -> System.out.print(x+", "));

    System.out.println("\n-------------");
    int sumElements = list.stream().reduce(0, (a,b) -> a+b);
    System.out.println("Sum of elements: " + sumElements);

    System.out.println("-------------");
    int prodElements = list.stream().reduce(1, (a,b) -> a*b);
    System.out.println("Product of elements: " + prodElements);

    System.out.println("-------------");
    String res = list.stream().map(x->""+x).reduce("=", (a, b) -> a+","+b);
    System.out.println("Product of elements: " + res);
  }
}