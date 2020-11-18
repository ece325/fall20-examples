import java.util.*;
import java.util.function.*;

public class FunctionalSolution
{
  public static <E> E fold(List<E> list, E acc, Function<E,Function<E,E>> f) {
    if (list.isEmpty()) {
        return acc;
    } else {
      E head = list.get(0);
      List<E> tail = list.subList(1, list.size());
      return (E) f.apply(head).apply((fold(tail, acc, f)));
    }
  }

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(4,3,6,7,2,1,5);

    list.forEach(x -> System.out.print(x+", "));

    System.out.println("\n-------------");
    int sumElements = fold(list, 0, a -> b -> a + b);
    System.out.println("Sum of elements: " + sumElements);

    System.out.println("-------------");
    int prodElements = fold(list, 1, a -> b -> a * b);
    System.out.println("Product of elements: " + prodElements);
  }
}