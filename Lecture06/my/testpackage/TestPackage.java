package my.testpackage;

public class TestPackage {
  public static void main(String[] args) {
    Pair p = new Pair(10,24);
    System.out.println("TestPackage inside the package");
    System.out.println(p);
    p.setSecond(p.getFirst() * p.getSecond());
    System.out.println(p);    
  }
}