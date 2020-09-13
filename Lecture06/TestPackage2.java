import my.testpackage.*;

public class TestPackage2 {
  public static void main(String[] args) {
    System.out.println("TestPackage outside the package");
    Pair p = new Pair(15,34);
    System.out.println(p);
    p.setSecond(p.getFirst()+p.getSecond());
    System.out.println(p);    
  }
}