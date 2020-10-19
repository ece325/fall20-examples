import java.util.*;
import dat.*;

public class TestIterable
{
  public static <T> void print(MyList<T> collection) {
    int size = collection.getSize();
    while (collection.hasNext()) {
      String sep = (--size > 0) ? ", " : "\n";
      System.out.print(collection.next() + sep);
    }
  }

  public static <T extends Comparable<T>> T minimum(MyList<T> collection) {
    int pos = 0;
    if (collection == null)
      return null;
    T min = null;
    while (collection.hasNext()) {
      Comparable<T> val = collection.next();
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
 
    MyList<Integer> list = new MyArrayList<Integer>();
    // MyList<Integer> list = new MyLinkList<Integer>();

    for (int k=0; k < 18; ++k) {
      list.add(numGenerator.nextInt(100));
    }

    print(list);
    list.reset();

    Integer min = minimum(list);
    System.out.println("Minimum value: " + min);

  }
}