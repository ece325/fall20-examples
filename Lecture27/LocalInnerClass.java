import java.util.*;

class Outer
{
  int num = 0;

  public void report() {

    String varName = "num";
    int rate = 1;

    class LocalInner {
      public void print() {
        System.out.println("LocalInner print method "+varName + ":" + num*rate);
      }
    }

    LocalInner local = new LocalInner();
    local.print();
  } 
    
  public void add(int value) {
    num += value;
  }

}

public class LocalInnerClass
{
  public static void main(String[] args) {
    
    Outer out = new Outer();
    
    out.add(5);
    out.add(8);
    out.add(3);

    out.report();
  }
}