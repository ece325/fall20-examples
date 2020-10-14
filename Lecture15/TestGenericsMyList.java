public class TestGenericsMyList
{
  public static void main(String[] args) {
    
    MyLinkListGen<Integer> list = new MyLinkListGen<Integer>();
    
    list.add(7);
    list.add(3);
    list.add(-2);
    list.add(9);
    list.add(4);

    Integer num = list.getElem(3);

    System.out.println("Number at 4th position: " + num);
  }
}