import java.util.*;

public class Benchmark1
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
  
  public static void benchmark(List<Integer> list, int[] numElemens, int iterations) {
    Random numGenerator = new Random();
    
    System.out.println("---- Benchmark: "+list.getClass().getName()+"----");
    for (int n : numElemens) {
      
      ExecTime timer1 = new ExecTime("Adding "+n+" elements","s");
      ExecTime timer2 = new ExecTime("Calculating the minimum of "+n+" elements","s");
      ExecTime timer3 = new ExecTime("Power of 2 "+n+" elements","s");

      for (int i=0; i<iterations; ++i) {        
        list.clear();
        // Adding values
        timer1.start();
        for (int k=0; k < n; ++k) {
          list.add(numGenerator.nextInt(1000));
        }
        timer1.stop();
        timer1.register();

        // Finding the minimum
        timer2.start();
        Integer min = minimum(list);
        timer2.stop();
        timer2.register();

        // Traversing and seting each element to power of 2
        timer3.start();
        power2(list);
        timer3.stop();
        timer3.register();
      }
      
      timer1.report();
      timer2.report();
      timer3.report();
      System.out.println("---------------------");
    }
  }

  public static void main(String[] args) {

    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new LinkedList<>();
    List<Integer> list3 = new Vector<>();

    int[] ns = new int[] {100, 1000, 10000, 100000, 1000000, 10000000};

    benchmark(list1, ns, 5);
    // benchmark(list2, ns, 5);
    benchmark(list3, ns, 5);
  }
}