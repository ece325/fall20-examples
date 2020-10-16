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

  public static <T> T writeAll(Collection<T> coll, Sink<T> snk) {
    T last = null;
    for (T t : coll) {
      last = t;
      snk.flush(last);
    }
    return last;
  }

  // public static <T> T writeAll(Collection<? extends T> coll, Sink<T> snk) {
  //   T last = null;
  //   for (T t : coll) {
  //     last = t;
  //     snk.flush(last);
  //   }
  //   return last;
  // }

  // public static <T> T writeAll(Collection<T> coll, Sink<? super T> snk) {
  //   T last = null;
  //   for (T t : coll) {
  //     last = t;
  //     snk.flush(last);
  //   }
  //   return last;
  // }

}


public class TestBoundedWildcard2
{
  public static void main(String[] args) { 

    Sink<Object> ptr = new Printer<Object>();
    List<String> list = new LinkedList<String>();
    
    list.add("Apple");
    list.add("Cinnamon");
    list.add("Sugar");
    
    String last = Util.writeAll(list, ptr);
    System.out.println("Last element: "+last);
  }
}