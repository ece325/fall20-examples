package dat_with_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Node<T> {
  private T value;
  Node<T> next;

  public Node(T obj) { 
    value = obj;
    next = null; 
  }
  
  public T getValue() {
    return value;
  }
}

class MyLinkListIterator<T> implements Iterator<T>
{
  private Node<T> current;

  public MyLinkListIterator(Node<T> start) {
    current = start;
  }

  public boolean hasNext() {
    return current != null;
  }

  public T next() {
    if (!this.hasNext())
      throw new NoSuchElementException();
    T result = current.getValue();
    current = current.next;
    return result;
  }
}

public class MyLinkList<T> implements MyList<T>
{
  public Node<T> values;
  private Node<T> last;
  private int size;
  private Node<T> current;

  public MyLinkList() {
    values = null;
    last = null;
    size = 0;
    current = null;
  }

  public void add(T obj) {
    Node<T> newNode = new Node<T>(obj);
    if (values == null) {
      values = newNode;
      current = values;
    }
    else {
      last.next = newNode;
    }
    ++size;
    last = newNode;
  }

  public T getElem(int pos) {
    Node<T> tmp = values;
    int i = 0;
    while (i != pos && tmp != null) {
      tmp = tmp.next;
      ++i;
    }
    if (tmp!=null)
      return tmp.getValue();
    return null;
  }

  public int getSize() { return size; }

  public Iterator<T> iterator() {
    return new MyLinkListIterator<T>(values);
  }
}
