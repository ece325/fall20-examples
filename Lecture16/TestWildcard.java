import java.util.*;

public class TestWildcard
{

  public static void printList1(Collection list) {
    Iterator i = list.iterator();
    for (int k = 0; k < list.size(); k++) {
        System.out.println(i.next());
    }
  }

  public static void printList2(Collection<Object> list) {
    for (Object obj : list) {
      System.out.println(obj);
    }
  }

  public static void printList3(Collection<?> list) {
    for (Object obj : list) {
      System.out.println(obj);
    }
  }

  public static void main(String[] args) {

    List<Integer> list = new LinkedList<Integer>();
    
    list.add(7);
    list.add(3);
    list.add(-2);

    printList2(list);

    List<String> list2 = new LinkedList<String>();
    
    list2.add("Apple");
    list2.add("Cinnamon");
    list2.add("Sugar");

    printList2(list2);
  }
}
