class Transportation
{
  private String name;

  Transportation(String name) { this.name = name; }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
}

/**
 * Class to represent a Car
 */
class Car extends Transportation
{
  Car(int id) { super("Car"+id); }
}

/**
 * Class to represent a Plane
 */
class Plane extends Transportation implements CanFly
{
  Plane(int id) { super("Plane"+id); }

  public void takeoff() {
    System.out.println(this.getName() + " taking off" );
  }

  public void landing() {
    System.out.println(this.getName() + " landing" );
  }
}

// ----------------------------------

class Animal
{
  private String name;

  Animal(String name) { this.name = name; }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
}

class Dog extends Animal
{
  Dog() { super("Dog"); }
}

class Bird extends Animal implements CanFly
{
  Bird() { super("Bird"); }

  public void takeoff() {
    System.out.println(this.getName() + " starts flying" );
  }

  public void landing() {
    System.out.println(this.getName() + " stands in a tree" );
  }

}

// ----------------------------------


public class TestCanFly2
{
  public static void main(String[] args) {
    
    CanFly[] things = {new Plane(1), new Bird()};

    for (CanFly elem : things) {
      elem.takeoff();
      elem.landing();
    }
  }
}