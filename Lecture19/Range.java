import java.util.Iterator;

class RangeIterator implements Iterator<Integer>, Iterable<Integer>
{
  private int value = 0;
  private int max;

  public RangeIterator(int min, int max) {
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

public class Range
{
  public static RangeIterator range(int n) {
    return new RangeIterator(0,n);
  }

  public static RangeIterator range(int min, int max) {
    return new RangeIterator(min,max);
  }
}
