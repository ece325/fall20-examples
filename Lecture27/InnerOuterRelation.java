import java.util.*;

class Outer
{
  private ArrayList<Inner> slots;

  class Inner {
    private int value;
    
    Inner(int val) { 
      value = val; 
      slots.add(this); 
    }
  }

  public Outer() {
    slots = new ArrayList();
  }

  public void add(int value) {
    new Inner(value);
  }

  public int sumValues() {
    return slots.stream().mapToInt(e -> e.value).sum();
  }
}

public class InnerOuterRelation
{
  public static void main(String[] args) {
    
    Outer out = new Outer();
    
    out.add(5);
    out.add(8);
    out.add(3);

    System.out.println("Sum:"+out.sumValues());
  }
}