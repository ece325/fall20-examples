import java.util.*;

interface Sink<T> {
  void flush(T t);
}

/* --------------------------------------------------- */
class Printer<T> implements Sink<T>
{ 
  private static int lineNumber = 0;

  public void flush(T val) {
    System.out.println("["+lineNumber++ +"] "+val);
  }
}

class Display<T> implements Sink<T>
{
  public void flush(T val) {
    System.out.println(val);
  }
}

/* --------------------------------------------------- */
class Util {

  public static <T> void writeAll(Collection<T> coll, Sink<T> snk) {
    for (T t : coll) {
      snk.flush(t);
    }
  }

  // public static <T,U> void writeAll(Collection<T> coll, Sink<U> snk) {
  //   for (U t : coll) {
  //     snk.flush(t);
  //   }
  // }

  // public static <T> void writeAll(Collection<? extends T> coll, Sink<T> snk) {
  //   for (T t : coll) {
  //     snk.flush(t);
  //   }
  // }

  // public static <T> void writeAll(Collection<T> coll, Sink<? super T> snk) {
  //   for (T t : coll) {
  //     snk.flush(t);
  //   }
  // }

}


public class TestBoundedWildcard
{
  public static void main(String[] args) { 
    Sink<String> ptr = new Printer<String>();
    // Sink<Object> ptr = new Printer<Object>();

    List<String> list = new LinkedList<String>();
    
    list.add("Apple");
    list.add("Cinnamon");
    list.add("Sugar");
    
    Util.writeAll(list, ptr);

    // ------------------------------
    // List<Integer> list2 = new LinkedList<Integer>();
    
    // list2.add(7);
    // list2.add(3);
    // list2.add(-2);

    // Util.writeAll(list2, ptr);
  }
}