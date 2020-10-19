import java.util.Iterator;

class RangeIterator implements Iterator<Integer>, Iterable<Integer>
{
  private int value = 0;
  private int min = 0;
  private int max;

  public RangeIterator(int min, int max) {
    this.min = min;
    this.max = max;
    value = min;
  }

  public boolean hasNext() {
    return value < max - 1;
  }

  public Integer next() {
    if (this.hasNext())
      return value++;
    return null;
  }

  public Iterator<Integer> iterator() {
    return this;
  }
}

class Range
{
  public static RangeIterator range(int n) {
    return new RangeIterator(0,n);
  }

  public static RangeIterator range(int min, int max) {
    return new RangeIterator(min,max);
  }
}

public class TestRange
{
  public static void main(String[] args) {
    
    for (int i : Range.range(10)) {
      System.out.print(i+" ");
    }

    System.out.println("");

    for (int i : Range.range(3,10)) {
      System.out.print(i+" ");
    }

  }
}