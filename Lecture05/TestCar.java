public class TestCar
{
  public static void main(String[] args) {
    Car c1 = new Car();
    Car c2 = new Car("Red",150,true);

    c1.pressStartButton();
    c1.pressStartButton();
    c2.activateParkingBrake();
    c2.pressAccelerator();
  }
}