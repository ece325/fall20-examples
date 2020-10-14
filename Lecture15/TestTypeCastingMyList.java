public class TestTypeCastingMyList
{
  public static void main(String[] args) {
    
    MyLinkList list = new MyLinkList();
    
    list.add(7);
    list.add(3);
    list.add(-2);
    list.add(9.0);
    list.add(4);

    Integer num = (Integer) list.getElem(3);

    System.out.println("Number at 4th position: " + num);
  }
}