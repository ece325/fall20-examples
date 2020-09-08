public class StringTest 
{
  public static void main(String[] args) {
    String myString = "Hello";
    String otherString = myString;

    myString = myString + " World!";

    System.out.println(myString);
    System.out.println(otherString);
  
    // ----
    myString = "Hello World!";
    otherString = "Hello World!";
    boolean same = myString == otherString;
    System.out.println("myString == otherString: " + same);

    boolean sameValue = myString.equals(otherString);
    System.out.println("myString.equals(otherString): " + sameValue);
  }
}