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


public class TestCanFly
{
  public static void main(String[] args) {
    Transportation[] trans = {new Car(1), new Plane(1)};

    for (Transportation elem : trans) {
      System.out.println(elem.getName());
    }

    // trans[1].takeoff();
    ((Plane)trans[1]).takeoff();

    
    Plane plane2 = new Plane(2);
    plane2.takeoff();

    CanFly thing = plane2;
    thing.getName();
    

  }
}