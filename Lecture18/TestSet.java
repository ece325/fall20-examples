import java.util.*;

public class TestSet
{
  public static <T> void print(Collection<T> collection) {
    int size = collection.size();
    for (T obj: collection) {
      String sep = (--size > 0) ? ", " : "\n";
      System.out.print(obj + sep);
    }
  }


  public static void main(String[] args) {
    Random numGenerator = new Random();
 
    Collection<Integer> list = new ArrayList<Integer>();
    Collection<Integer> set = new HashSet<>();
    // Collection<Integer> set = new TreeSet<>();

    for (Integer v : new Integer[] {34,10,22,10,30,60,30,22}) {
      list.add(v);
      set.add(v);
    }

    System.out.println("List of elements");
    print(list);
    System.out.println("Set of elements");
    print(set);

    System.out.println("Set contains value 10: " + set.contains(10));
    System.out.println("Set contains value 9: " + set.contains(9));

  }
}