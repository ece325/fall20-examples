import testinterface.MyList;

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

public class MyLinkListGen<T> implements MyList<T>
{
  public Node<T> values;
  private Node<T> last;
  private int size;

  public MyLinkListGen() {
    values = null;
    last = null;
    size = 0;
  }

  public void add(T obj) {
    Node<T> newNode = new Node<T>(obj);
    if (values == null) {
      values = newNode;
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

  public void print() {
    for(int i=0; i<this.getSize(); ++i) {
      T val = this.getElem(i);
      System.out.println(val);
    }
  }

}
