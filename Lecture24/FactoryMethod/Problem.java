class Truck
{
  public Truck() {}

  public void route() {
    System.out.println("Truck route method called");
  }

  public void costOfTransportation() {
    System.out.println("Truck costOfTransportation method called");
  }

  public void planDelivery() {
    route();
    costOfTransportation();
  }

}

class Ship
{
  public Ship() {}
}


public class Problem
{
  public static void main(String[] args) {
    
    Truck truck = new Truck();
    
    truck.planDelivery();
  }
}