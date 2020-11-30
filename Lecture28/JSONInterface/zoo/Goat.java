package zoo;

public class Goat extends Animal implements Locomotion {
  
  public Goat() {
    super("");
  }

  public Goat(String name) {
    super(name);      
  }

  @Override
  protected String getSound() {
    return "bleat";
  }

  @Override
  public String getLocomotion() {
    return "walks";
  }

  @Override
  public String eats() {
    return "grass";
  }

}