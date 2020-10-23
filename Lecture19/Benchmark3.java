import java.util.*;

public class Benchmark3
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

  public static <T extends Comparable<T>> int lowerBound(List<T> list, T elem) {
    if (list==null)
      return 0;
    int end = list.size();
    int begin = 0;
    boolean found = false;
    while (!found && begin < end) {
      int pos = (begin+end)/2;
      T elemPos = list.get(pos);
      if (elem.compareTo(elemPos) == 0)
        return pos;
      if (elem.compareTo(elemPos) > 0)
        begin = pos+1;
      else
        end = pos;
    }
    return end;
  }

  public static void benchmark(List<Integer> list, List<Integer> numElemens, int iterations) {
    Random numGenerator = new Random();
    
    for (int n : numElemens) {
      
      ExecTime timer1 = new ExecTime("Adding "+n+" elements","ns");
      ExecTime timer2 = new ExecTime("Removing "+n+" elements","ns");

      for (int i=0; i<iterations; ++i) {        
        list.clear();
        // Adding values
        timer1.start();
        for (int k=0; k < n; ++k) {
          int val = numGenerator.nextInt(n);
          int pos = lowerBound(list, val);
          list.add(pos, val);
        }
        timer1.stop();
        timer1.register();
        
        // Removing elements at random positions
        timer2.start();
        for (int k=0; k < n; ++k) {
          int pos = numGenerator.nextInt(n) % list.size();
          list.remove(list.get(pos));
        }
        timer2.stop();
        timer2.register();

      }
      
      System.out.println(list.getClass().getName()+",\t"+n+",\t"+timer1.average()+",\t"+timer2.average());
    }
  }

  public static void main(String[] args) {

    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new LinkedList<>();
    List<Integer> list3 = new Vector<>();

    List<Integer> seq = new ArrayList<Integer>();
    for (int i : Range.range(5,16)) {
      seq.add(i);
    }
    powerN(seq, 2);

    System.out.println("collection,n,add,remove");
    benchmark(list1, seq, 10);
    benchmark(list2, seq, 10);
    benchmark(list3, seq, 10);
  }
}