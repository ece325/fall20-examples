import java.util.Objects;
import java.util.*;

class DictEntry<K,V>
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


/**
 * A simple Hash map (Dictionary) data structure
 */
class MyDictionary<K,V> 
{
  private static final int PRIME = 31;
  
  private ArrayList<Object> data;

  public MyDictionary() {
    data = new ArrayList();
    for(int i=0;i<PRIME;++i) data.add(null);
    System.out.println("Data size:"+data.size()); 
  }

  private int hash(Integer k) {
    return Math.abs(k) % PRIME;
  }

  public void insert(Object elem) {
    if (!contains((K) ((DictEntry)elem).getKey())) {
      int i = hash(((DictEntry)elem).getKey().hashCode());
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

  Object get(K key) {
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

class Pair
{
  private Integer key;
  private String value;

  Pair(int k, String v) {
    key = k;
    value = v;
  }

  public Integer getKey() { return key; }
}

public class SimpleDictionaryObject
{

  public static void main(String[] args) {
    
    MyDictionary<Integer,String> data = new MyDictionary();

    data.insert(new DictEntry<Integer,String>(10, "Red"));
    data.insert(new DictEntry<Integer,String>(8, "Yellow"));
    data.insert(new DictEntry<Integer,String>(14, "Blue"));
    data.insert(new DictEntry<Integer,String>(5, "Black"));
    // data.insert(new Pair(7, "White"));

    System.out.println(data);

    DictEntry elem = (DictEntry) data.get(14);
    System.out.println("Element with key=14: "+elem);
  }
}