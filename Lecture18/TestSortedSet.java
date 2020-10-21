import java.util.*;

public class TestSortedSet
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
 
    SortedSet<String> list = new TreeSet<>();

    list.add("John");
    list.add("Ada");
    list.add("Charles");
    list.add("James");
    list.add("Guido");
    list.add("Bjarne");

    print(list);

    String min = minimum(list);
    System.out.println("Minimum value: " + min);
    System.out.println("Minimum value: " + list.first());

    String name = "Carol";
    System.out.print("Names before "+name+": ");
    print(list.headSet(name));

    name = "Alan";
    System.out.print("Names after "+name+": ");
    print(list.tailSet(name));

  }
}