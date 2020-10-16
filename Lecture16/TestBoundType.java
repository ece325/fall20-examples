class MyInteger
{
  private int value;

  public MyInteger(int v) { value = v; }

  public int getInt() { return value; }
}


class CompareValuesNoCheck<T>
{
  public T compare(T n1, T n2) {
    if (n1.compareTo(n2) <= 0)
      return n1;
    else 
      return n2;
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


public class TestBoundType
{

  public static void testMyInteger() {
    CompareValuesNoCheck<MyInteger> comp = new CompareValuesNoCheck<MyInteger>();
    // CompareValues<MyInteger> comp = new CompareValues<MyInteger>();

    MyInteger a = new MyInteger(5);
    MyInteger b = new MyInteger(8);
    
    MyInteger res = comp.compare(a, b);

    System.out.println("(MyInteger) Minor value: "+res);
  }

  public static void testInteger() {
    CompareValuesNoCheck<Integer> comp = new CompareValuesNoCheck<Integer>();
    // CompareValues<Integer> comp = new CompareValues<Integer>();

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
