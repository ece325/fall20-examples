import java.util.*;

public class TestList
{
  public static <T> void print(Collection<T> collection) {
    int size = collection.size();
    for (T obj: collection) {
      String sep = (--size > 0) ? ", " : "\n";
      System.out.print(obj + sep);
    }
  }

  public static void power2(List<Integer> list) {
    for (int i = 0; i<list.size(); ++i) {
      Integer oldVal = list.get(i);
      Integer newVal = (int)Math.pow(oldVal, 2);
      list.set(i, newVal);
    }
  }

  public static <T extends Comparable<T>> T minimum(Collection<T> collection) {
    int pos = 0;
    if (collection == null)
      return null;
    T min = null;
    Iterator<T> iter = collection.iterator();
    while (iter.hasNext()) {
      Comparable<T> val = iter.next();
      if (min == null)
        min = (T) val;
      else
        if (val.compareTo(min) < 0)
          min = (T) val;
    }
    return (T) min;
  }

  public static void main(String[] args) {
    Random numGenerator = new Random();
 
    List<Integer> list = new ArrayList<Integer>();
    // List<Integer> list = new LinkedList<>();
    // List<Integer> list = new Vector<>();

    for (int k=0; k < 20; ++k) {
      list.add(numGenerator.nextInt(100));
    }

    print(list);
    System.out.println("Element in position 6: "+ list.get(5));

    Integer min = minimum(list);
    System.out.println("Minimum value: " + min);
    System.out.println("Position of the minimum element: " + list.indexOf(min));
    System.out.println("Position of the value -500: " + list.indexOf(-500));

    power2(list);
    print(list);

    

  }
}