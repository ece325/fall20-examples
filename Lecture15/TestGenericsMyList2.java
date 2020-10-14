import testinterface.*;

public class TestGenericsMyList2
{
  public static void main(String[] args) {
    
    MyList<Integer> list = new MyLinkListGen<Integer>();
    
    list.add(7);
    list.add(3);
    list.add(-2);

    list.print();

    MyLinkListGen<String> list2 = new MyLinkListGen<String>();
    
    list2.add("Apple");
    list2.add("Cinnamon");
    list2.add("Sugar");

    list2.print();

  }
}