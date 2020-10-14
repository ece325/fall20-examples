public class TestTypeCastingMyList2
{
  static void print(MyLinkList list) {
    for(int i=0; i<list.getSize(); ++i) {
      Integer num = (Integer) list.getElem(i);
      System.out.println(num);
    }
  }

  public static void main(String[] args) {
    
    MyLinkList list = new MyLinkList();
    
    list.add(7);
    list.add(3);
    list.add(-2);

    print(list);

    // MyLinkList list2 = new MyLinkList();
    
    // list2.add("Apple");
    // list2.add("Cinnamon");
    // list2.add("Sugar");

    // print(list2);

  }
}