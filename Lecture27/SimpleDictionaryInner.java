import java.util.Objects;
import java.util.*;



/**
 * A simple Hash map (Dictionary) data structure
 */
class MyDictionary<K,V> 
{
  private static final int PRIME = 31;

  public class DictEntry
  {
    private K key;
    private V value;

    public DictEntry(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public String toString() {
      return "("+key+":"+value+")";
    }
  }

  private ArrayList<DictEntry> data;

  public MyDictionary() {
    data = new ArrayList();
    for(int i=0;i<PRIME;++i) data.add(null);
  }

  private int hash(Integer k) {
    return Math.abs(k) % PRIME;
  }

  public void insert(DictEntry elem) {
    if (!contains(elem.key)) {
      int i = hash(elem.key.hashCode());
      data.set(i,elem);
    }
    else {
      System.out.println(elem+" already in the Dictionary");
    }
  }

  public boolean contains(K key) {
    int k = key.hashCode();
    int i = hash(k);
    if (data.get(i)!=null)
      return true;
    return false;
  }

  DictEntry get(K key) {
    if (contains(key)) {
      int k = key.hashCode();
      int i = hash(k);
      return data.get(i);
    }
    else {
      System.out.println(key+" is not in the Dictionary");
      return null;
    }
  }

  public String toString() {
    String out = "";
    for (Object obj : data) {
      out += obj+", ";
    }
    return out;
  }
}


public class SimpleDictionaryInner
{

  public static void main(String[] args) {
    
    MyDictionary<Integer,String> data = new MyDictionary();

    data.insert(data.new DictEntry(10, "Red"));
    data.insert(data.new DictEntry(8, "Yellow"));
    data.insert(data.new DictEntry(14, "Blue"));
    data.insert(data.new DictEntry(5, "Black"));

    System.out.println(data);

    MyDictionary.DictEntry elem = data.get(14);
    System.out.println("Element with key=14: "+elem);

  }
}