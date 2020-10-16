class MyInteger implements Comparable<MyInteger>
{
  private int value;

  public MyInteger(int v) { value = v; }

  public int getInt() { return value; }

  public int compareTo(MyInteger other) {
    if (value == other.getInt())
      return 0;
    else if (value < other.getInt())
      return -1;
    return 1;
  }

  @Override
  public String toString() {
    return ""+value;
  }
}


class Util {

  public static <T extends Comparable<T>> T compare(T n1, T n2) {
    if (n1.compareTo(n2) <= 0)
      return n1;
    else 
      return n2;
  }

}


public class TestGenMethod
{

  public static void testNonBounded() {
    MyInteger a = new MyInteger(5);
    MyInteger b = new MyInteger(8);
    
    MyInteger res = Util.<MyInteger>compare(a, b);

    System.out.println("(MyInteger) Minor value: "+res);
  }

  public static void testBounded() {
    Integer a = 5;
    Integer b = 8;
    
    Integer res = Util.<Integer>compare(a, b);

    System.out.println("(Integer) Minor value: "+res);
  }

  public static void main(String[] args) {
    testNonBounded();
    testBounded();
  }
}