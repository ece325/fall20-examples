import java.util.*;

public class TestAlgorithms
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
 
    List<Integer> list = new ArrayList<Integer>();
    // List<Integer> list = new LinkedList<>();
   
    for (int k=0; k < 20; ++k) {
      list.add(numGenerator.nextInt(100));
    }

    print(list);

    Integer min = Collections.min(list);
    System.out.println("Minimum value: " + min);
 
    System.out.println("\nBinary Search");
    Integer value = list.get(10);
    int pos = Collections.binarySearch(list, value);
    System.out.println("Position of element "+value+": " + pos);

    System.out.println("\nSort");
    Collections.sort(list);
    print(list);
    pos = Collections.binarySearch(list, value);
    System.out.println("Position of element "+value+": " + pos);

    System.out.println("\nRotate 5");
    Collections.rotate(list,5);
    print(list);


    System.out.println("\nShuffle");
    Collections.shuffle(list);
    print(list);

  }
}