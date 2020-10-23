import java.util.*;

public class Benchmark2
{
  public static <T> void print(Collection<T> collection) {
    int size = collection.size();
    for (T obj: collection) {
      String sep = (--size > 0) ? ", " : "\n";
      System.out.print(obj + sep);
    }
  }

  public static void powerN(List<Integer> list, int base) {
    for (int i = 0; i<list.size(); ++i) {
      Integer oldVal = list.get(i);
      Integer newVal = (int)Math.pow(base,oldVal);
      list.set(i, newVal);
    }
  }

  public static void benchmark(List<Integer> list, List<Integer> numElemens, int iterations) {
    Random numGenerator = new Random();
    
    System.out.println("---- Benchmark: "+list.getClass().getName()+"----");
    for (int n : numElemens) {
      
      ExecTime timer1 = new ExecTime("Adding "+n+" elements", "s");
      ExecTime timer2 = new ExecTime("Removing "+n+" elements", "s");

      for (int i=0; i<iterations; ++i) {       
        list.clear(); 
        // Adding values
        timer1.start();
        for (int k=0; k < n; ++k) {
          list.add(numGenerator.nextInt(1000));
        }
        timer1.stop();
        timer1.register();

        // Removing elements at random positions
        timer2.start();
        for (int k=0; k < n; ++k) {
          int pos = numGenerator.nextInt(1000000) % list.size();
          list.remove(list.get(pos));
        }
        timer2.stop();
        timer2.register();

      }
      
      timer1.report();
      timer2.report();
      System.out.println("---------------------");
    }
  }

  public static void main(String[] args) {

    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new LinkedList<>();
    List<Integer> list3 = new Vector<>();

    List<Integer> seq = new ArrayList<Integer>();
    for (int i : Range.range(5,18)) {
      seq.add(i);
    }
    powerN(seq, 2);
    print(seq);

    benchmark(list1, seq, 10);
    benchmark(list2, seq, 10);
    benchmark(list3, seq, 10);
  }
}