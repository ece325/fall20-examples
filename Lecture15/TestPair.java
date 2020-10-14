import pair.*;

public class TestPair
{
  public static void main(String[] args) {

    Pair<Integer,String> p1 = new Pair<Integer,String>(1,"John");

    Pair<Integer,String> p2 = new Pair<Integer,String>(2,"John");

    p2.setFirst(1);
    
    if (p1.equals(p2)) {
      System.out.println("Same information "+p1+"=="+p2);
    }
    else {
      System.out.println("Different information "+p1+"!="+p2);
    }
    
    Pair<Integer,Integer> point = new Pair<Integer,Integer>(2,7);
    System.out.println("Point: "+point);
  }
}