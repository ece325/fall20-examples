import java.util.*;

class BasicProblem
{
  public static int sum(List<Integer> list) {
    int result = 0;
    for(Integer value : list) {
      result += value;
    }
    return result;
  }

  public static int product(List<Integer> list) {
    int result = 1;
    for(Integer value : list) {
      result *= value;
    }
    return result;
  }

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(4,3,6,7,2,1,5);

    for(Integer value : list) {
      System.out.print(value+", ");
    }
    System.out.println("\n-------------");
    System.out.println("Sum of elements: " + sum(list));

    System.out.println("-------------");
    System.out.println("Product of elements: " + product(list));
  }
}