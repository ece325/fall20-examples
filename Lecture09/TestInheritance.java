class A 
{
  private int id;
  protected double value;

  A() {
    this.id = 0;
  }

  public void inc() {
    ++value;
  }
}

class B extends A
{
  public void dec() {
    --value;
  }
}

public class TestInheritance
{
  public static void main(String[] args) {
    B b = new B();
    b.inc();
    System.out.println("value:" + b.value);
    b.dec();
    System.out.println("value:" + b.value);
  }
}
