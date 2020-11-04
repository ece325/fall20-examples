
class Subject {
  private int state;

  public int getState() {
      return state;
  }

  public void setState(int value) {
      this.state = value;
      convert();
  }

  private void convert() {
    System.out.print(" hex:" + Integer.toHexString(this.getState()));
    System.out.print(" oct:" + Integer.toOctalString(this.getState()));
  }
}

public class Problem 
{
  public static void main( String[] args ) {
      Subject sub = new Subject();
      
      int num = 356;
      System.out.println("\n-------\n"+num+":");
      sub.setState(num);

      // num = 1752;
      // System.out.println("\n-------\n"+num+":");
      // sub.setState(num);

      // If we want also a binary representation?
    }
}