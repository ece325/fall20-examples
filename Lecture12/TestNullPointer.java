class ExceptionExample1
{
  public String[] myList;
  public void problemCode(String item) {
    myList[0] = item;
  }
}

class ExceptionExample2
{
  public String[] myList;
  public void problemCode(String item) {
    try {
      myList[0] = item;
    }
    catch(NullPointerException e) {
      System.out.println("Problem!");
      myList = new String[10];
      System.out.println("Now try again");
    }
  }
}

public class TestNullPointer
{
  public static void main(String[] args) {
    // ExceptionExample1 e = new ExceptionExample1();
    // e.problemCode("demo");

    /** */
     ExceptionExample2 e = new ExceptionExample2();
     e.problemCode("demo");
     e.problemCode("demo");
     System.out.println("myList[0]: " + e.myList[0]);
    //*/
  }
}