import java.util.*;

class Outer
{
  private static List<Inner> slots = Arrays.asList(null,null,null,null,null);
  private static int index = 0;

  public static class Inner {
    private int value;
    
    Inner(int val) { 
      value = val; 
      slots.set(index++,this); 
    }

    public String toString() {
      return ""+value;
    }
  }

  public void add(int value) {
    new Inner(value);
  }

  public int sumValues() {
    return slots.stream().mapToInt(e -> e.value).sum();
  }

  public String toString() {
    String cad = "";
    for (Object e : slots) {
      cad += e+",";
    }
    return cad;
  }
}

public class StaticIneerClass
{
  public static void main(String[] args) {
    
    Outer.Inner a = new Outer.Inner(100);
    Outer.Inner b = new Outer.Inner(1000);

    Outer out = new Outer();
    
    out.add(5);
    out.add(8);
    out.add(3);

    System.out.println(out);
    System.out.println(new Outer());
  }
}