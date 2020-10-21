import java.util.*;

public class TestMap
{
  public static <T> void print(Collection<T> collection) {
    int size = collection.size();
    Iterator<T> iter = collection.iterator();
    while (iter.hasNext()) {
      String sep = (--size > 0) ? ", " : "\n";
      System.out.print(iter.next() + sep);
    }
  }

  public static void main(String[] args) {
    Random numGenerator = new Random();
 
    Map<String,Integer> map = new HashMap<>();
    // Map<String,Integer> map = new TreeMap<>();

    map.put("John",1903);
    map.put("Ada",1815);
    map.put("Charles",1791);
    map.put("James",1955);
    map.put("Guido",1956);
    map.put("Bjarne",1950);

    System.out.println(map);

    String name = "Ada";
    System.out.println(name + " born in " + map.get(name));

    System.out.print("Years: ");
    print(map.values());

    for (Map.Entry pair : map.entrySet()) {
      String k = (String) pair.getKey();
      Integer v = (Integer) pair.getValue();
      System.out.println(k + " born in " + v);
    }

  }
}