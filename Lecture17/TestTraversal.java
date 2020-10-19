import java.util.*;
import dat_no_iterator.*;

public class TestTraversal
{
  public static void print(MyList<?> collection) {
    int size = collection.getSize();
    for (int i=0; i < size; ++i) {
      String sep = (i < size-1) ? ", " : "\n";
      System.out.print(collection.getElem(i) + sep);
    }
  }


  public static <T extends Comparable<T>> T minimum(MyList<T> collection) {
    int pos = 0;
    if (collection == null)
      return null;
    Comparable<T> minValue = collection.getElem(0);
    for (int i=0; i< collection.getSize(); ++i) {
      if (minValue.compareTo((T) collection.getElem(i)) > 0)
        minValue = collection.getElem(i);
    }
    return (T) minValue;
  }

  public static void main(String[] args) {
    Random numGenerator = new Random();
 
    MyList<Integer> list = new MyArrayList<Integer>();
    // MyList<Integer> list = new MyLinkList<Integer>();

    for (int k=0; k < 18; ++k) {
      list.add(numGenerator.nextInt(100));
    }

    print(list);

    Integer min = minimum(list);
    System.out.println("Minimum value: " + min);

  }
}