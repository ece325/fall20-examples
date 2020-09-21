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
  public void inc() {
    value += 2;
  }
}

class C extends A
{
  public void inc() {
    value += 5;
  }
}

class D extends B,C // No possible
{
}

public class Diamond
{
  public static void main(String[] args) {
    D d = new D();
    d.inc();
    System.out.println("value:" + d.value);
  }
}
