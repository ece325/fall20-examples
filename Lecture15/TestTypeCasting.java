public class TestTypeCasting
{
 
  public static void main(String[] args) {

    Object[] list = new Object[10];
    
    list[0] = 7;
    list[1] = 3;
    list[2] = -2;
    list[3] = 9;
    list[4] = 4;

    Integer num = (Integer) list[3];

    System.out.println("Number at 4th position: " + num);
  }
}