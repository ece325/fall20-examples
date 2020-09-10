/**
 * Class to represent a Sport Car
 */
class Car
{
  // Variables to describe the state ...
  private String colour;
  private double enginePower;
  private boolean isConvertible;
  private boolean parkingBrakeOn;
  private boolean isEngineOn;

  /**
   * @return the enginePower
   */
  public double getEnginePower() {
    return enginePower;
  }

  // Some methods to define the behaviour ...
  // A default constructor
  public Car()
  {
    colour = "White";
    enginePower = 100;
    isConvertible = false;
    parkingBrakeOn = false;
    isEngineOn = false;
  }

  /**
   * Basic constructor with specific initial values
   * @param colour of the car
   * @param enginePower in HP
   * @param isConvertible true if the car is convertible, or false if it is normal
   */
  public Car(String colour, double enginePower, boolean isConvertible)
  {
    this.colour = colour;
    this.enginePower = enginePower;
    this.isConvertible = isConvertible;
    parkingBrakeOn = false;
    isEngineOn = false;
  }

  // Some other useful methods ...
  /**
   * Accelerates the car if it is possible
   */
  public void pressAccelerator()
  {
    if (!parkingBrakeOn && isEngineOn) {
      System.out.println("Accelerator pressed");
    } else {
      System.out.println("Can't move, parking brake is active");
    }
  }

  /**
   * Starts the car if is not already started
   */
  public void pressStartButton()
  {
    if (!isEngineOn) {
      System.out.println("Start Button pressed");
      isEngineOn = true;
    } else {
      System.out.println("Car already started");
    }
  }

  public void activateParkingBrake() 
  {
    parkingBrakeOn = true;  
  }

  public void deactivateParkingBrake() 
  {
    parkingBrakeOn = false;  
  }

  public void print() {
    System.out.println("Colour:" + colour +
                       ", Engine Power:" + enginePower +
                       ", Is converible:" + isConvertible +
                       ", Parking break active:" + parkingBrakeOn);   
  }
}
