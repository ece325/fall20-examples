class Node {
  private Object value;
  Node next;

  public Node(Object obj) { 
    value = obj;
    next = null; 
  }
  
  public Object getValue() {
    return value;
  }
}

public class MyLinkList
{
  public Node values;
  private Node last;
  private int size;

  public MyLinkList() {
    values = null;
    last = null;
    size = 0;
  }

  public void add(Object obj) {
    Node newNode = new Node(obj);
    if (values == null) {
      values = newNode;
    }
    else {
      last.next = newNode;
    }
    ++size;
    last = newNode;
  }

  public Object getElem(int pos) {
    Node tmp = values;
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
}
