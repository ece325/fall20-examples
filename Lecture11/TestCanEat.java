// --------- Interface -------------

interface CanEat
{
  // default method (requires Java 8)
  default void eat() {
    System.out.println("Eating");
  }
}

// ----------------------------------

// ----------- Classes --------------

abstract class Animal
{
  private String name;

  Animal(String name) { this.name = name; }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  public abstract void die();
}


class Dog extends Animal implements CanEat
{
  Dog(int id) { super("Dog"+id); }

  @Override
  public void die() {
      System.out.println(this.getName()+" has died");
  }

  @Override
  public void eat() {
    CanEat.super.eat();
    
    System.out.println(this.getName()+" is eating dog food");
  }
}

class Bird extends Animal implements CanFly, CanEat
{
  Bird(int id) { super("Bird"+id); }

  public void takeoff() {
    System.out.println(this.getName() + " starts flying" );
  }

  public void landing() {
    System.out.println(this.getName() + " stands in a tree" );
  }

  @Override
  public void die() {
    System.out.println(this.getName()+" has died");    
  }
}

// ----------------------------------


public class TestCanEat
{
  public static void main(String[] args) {
    
    // Animal animal = new Animal();

    // CanEat caneat = new CanEat();

    Dog dog = new Dog(1);
    dog.eat();
    dog.die();

    System.out.println("-------------------");

    Bird bird = new Bird(1);
    bird.eat();
    bird.takeoff();
    bird.landing();
    bird.die();

  }
}