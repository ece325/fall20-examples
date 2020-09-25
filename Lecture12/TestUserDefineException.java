class NonPositiveException extends Exception
{
  public NonPositiveException(String message) {
    super(message);
  }
}

class SignedInt
{
  private int value;

  public SignedInt(int n) throws NonPositiveException
  { 
    if (n < 0) {
      throw new NonPositiveException("Given number is not positive");
    }
    value = n;
  }

  public SignedInt add(SignedInt other) {
    this.value += other.value;
    return this;
  }

  public SignedInt add(int other) throws NonPositiveException
  { 
    this.add(new SignedInt(other));
    return this;
  }


  public String toString() {
    return ""+value;
  }
}


public class TestUserDefineException
{
  public static void main(String[] args) {
    SignedInt a = null;
    // try {
      a = new SignedInt(1);
      a = a.add(5);
    // }
    // catch (NonPositiveException e) {
      // System.out.println(e);
    // }
    System.out.println(a);
  }
}