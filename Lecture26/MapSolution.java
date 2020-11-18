import java.util.*;
import java.util.function.*;

class MapSolution
{
  private static <E,R> List<R> map_impl(List<E> list, Function<E,R> f, List<R> result)
  {
    if (list.isEmpty()) {
      return result;
    }
    E head = list.get(0);
    List<E> tail = list.subList(1, list.size());
    result.add(f.apply(head));
    return map_impl(tail, f, result);
  }

  public static <E,R> List<R> map(List<E> list, Function<E,R> f)
  {
    return map_impl(list, f, new ArrayList<R>());
  }

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

    List<Integer> list2 = map(list, x -> x*x);

    list2.forEach(x -> System.out.print(x+", "));

    System.out.println("\n-------------");
    int sumElements = fold(list, 0, a -> b -> a + b);
    System.out.println("Sum of elements: " + sumElements);

    System.out.println("-------------");
    int prodElements = fold(list, 1, a -> b -> a * b);
    System.out.println("Product of elements: " + prodElements);

    System.out.println("-------------");
    String appendElements = fold(map(list,a -> a.toString()), "", a -> b -> a+"-"+b);
    System.out.println("Append of elements: " + appendElements);
  }
}