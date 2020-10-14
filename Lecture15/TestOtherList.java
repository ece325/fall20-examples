import testinterface.*;

public class TestOtherList
{
  public static void main(String[] args) {
    
    MyList<Integer> list = new OtherList<Integer>();
    
    list.add(7);
    list.add(3);
    list.add(-2);

    list.print();

    MyList<String> list2 = new OtherList<String>();
    
    list2.add("Apple");
    list2.add("Cinnamon");
    list2.add("Sugar");

    list2.print();

  }
}