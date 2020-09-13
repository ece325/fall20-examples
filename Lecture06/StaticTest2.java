class Element {
  private static int numElements = 0;
  public int id;
  
  Element() {
    id = ++numElements;
  }

  public static int getNumElements() {
    return numElements;
  }
}

public class StaticTest2 {
  public static void main(String[] args) {
    Element x;
    Element y = new Element();
    Element z = new Element();
    System.out.println("Number of Elements created: " + Element.getNumElements());
    System.out.println("Element Id of y: " + y.id);
  }
}
