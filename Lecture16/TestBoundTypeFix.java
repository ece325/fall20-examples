class MyInteger implements Comparable<MyInteger>
{
  private int value;

  public MyInteger(int v) { value = v; }

  public int getInt() { return value; }

  public int compareTo(MyInteger o) {
    MyInteger other = (MyInteger) o;
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


class CompareValues<T extends Comparable<T>>
{
  public T compare(T n1, T n2) {
    if (n1.compareTo(n2) <= 0)
      return n1;
    else 
      return n2;
  }
}


public class TestBoundTypeFix
{

  public static void testMyInteger() {
    CompareValues<MyInteger> comp = new CompareValues<MyInteger>();

    MyInteger a = new MyInteger(5);
    MyInteger b = new MyInteger(8);
    
    MyInteger res = comp.compare(a, b);

    System.out.println("(MyInteger) Minor value: "+res);
  }

  public static void testInteger() {
    CompareValues<Integer> comp = new CompareValues<Integer>();

    Integer a = 5;
    Integer b = 8;
    
    Integer res = comp.compare(a, b);

    System.out.println("(Integer) Minor value: "+res);
  }

  public static void main(String[] args) {
    testMyInteger();
    testInteger();
  }
}