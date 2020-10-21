import java.util.*;

public class TestCollection
{
  public static <T> void print(Collection<T> collection) {
    int size = collection.size();
    Iterator<T> iter = collection.iterator();
    while (iter.hasNext()) {
      String sep = (--size > 0) ? ", " : "\n";
      System.out.print(iter.next() + sep);
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
 
    Collection<Integer> list = new ArrayList<Integer>();
    // Collection<Integer> list = new LinkedList<>();
    // Collection<Integer> list = new TreeSet<>();

    for (int k=0; k < 20; ++k) {
      list.add(numGenerator.nextInt(100));
    }

    print(list);

    Integer min = minimum(list);
    System.out.println("Minimum value: " + min);

    for(Integer v : list) {
      System.out.print(v+", ");
    }
  }
}