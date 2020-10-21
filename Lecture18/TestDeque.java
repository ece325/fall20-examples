import java.util.*;

public class TestDeque
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
 
    Deque<Integer> queue = new ArrayDeque<Integer>();

    List<Integer> data = new ArrayList<>();
    int[] values = new int[] {1,2,3,4,5,6,7,8};
    for(int i=0; i<values.length; ++i)
      data.add(values[i]);
  
    Iterator iter = data.iterator();
    
    while (iter.hasNext()) {
      queue.addFirst((Integer)iter.next());
      if (iter.hasNext())
        queue.addLast((Integer)iter.next());
    }

    System.out.println("Queue of elements");
    print(queue);
    System.out.println("Number of element in queue: "+queue.size());

    System.out.println("Element at the head: " + queue.peekFirst());
    System.out.println("Element at the tail: " + queue.peekLast());

    Integer elem;
    elem = queue.removeFirst();
    System.out.println("Element removed: " + elem);

    elem = queue.pollLast();
    System.out.println("Element removed: " + elem);

    print(queue);
    System.out.println("Number of element in queue: "+queue.size());

  }
}