package dat_with_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MyArrayListIterator<T> implements Iterator<T>
{
  private MyArrayList<T> list;
  private int current;

  public MyArrayListIterator(MyArrayList<T> list) {
    this.list = list;
    current = 0;
  }

  public boolean hasNext() {
    return current < list.getSize();
  }

  public T next() {
    if (!this.hasNext())
      throw new NoSuchElementException();
    return list.getElem(current++);
  }
}


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

  public Iterator<T> iterator() {
    return new MyArrayListIterator<T>(this);
  }
}
