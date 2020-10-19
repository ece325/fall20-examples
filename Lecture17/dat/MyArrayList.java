package dat;

import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T>
{
  public Object[] values;
  private int size;
  private int maxSize;
  private int current;

  public MyArrayList() {
    values = new Object[10];
    size = 0;
    maxSize = 10;
    current = 0;
  }

  public void add(T obj) {
    if (size == maxSize) {
      Object[] tmp = values;
      maxSize = (int)(maxSize*1.5);
      values = new Object[maxSize];
      for (int i=0; i<size; ++i) {
        values[i] = tmp[i];
      }
    }
    values[size++] = obj;
  }

  public T getElem(int pos) {
    return (T) values[pos];
  }

  public int getSize() { return size; }

  public boolean hasNext() {
    return current < this.getSize();
  }

  public T next() {
    if (!this.hasNext())
      throw new NoSuchElementException();
    return this.getElem(current++);
  }
}
