import java.util.*;

public class TestQueue
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
 
    Queue<Integer> queue = new LinkedList<Integer>();
    // Queue<Integer> queue = new PriorityQueue<>();

    for (Integer v : new Integer[] {2,5,6,8,2,3,4}) {
      queue.add(v);
    }

    System.out.println("Queue of elements");
    print(queue);
    System.out.println("Number of element in queue: "+queue.size());

    System.out.println("Element at the head: " + queue.element());
    System.out.println("Element at the head: " + queue.peek());

    Integer elem;
    elem = queue.remove();
    System.out.println("Element removed: " + elem);

    elem = queue.poll();
    System.out.println("Element removed: " + elem);

    System.out.println("Number of element in queue: "+queue.size());

  }
}