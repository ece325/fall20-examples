// *******************************
// Product with concrete implementations

interface Transport {
  void route();
  void costOfTransportation();
}

class Truck implements Transport
{
  public Truck() {}

  public void route() {
    System.out.println("Truck route method called");
  }

  public void costOfTransportation() {
    System.out.println("Truck costOfTransportation method called");
  }
}

class Ship implements Transport
{
  public Ship() {}

  public void route() {
    System.out.println("Ship route method called");
  }

  public void costOfTransportation() {
    System.out.println("Ship costOfTransportation method called");
  }
}

// *******************************
// Factory with concrete creators

abstract class Logistic
{
  public void planDelivery() {
    Transport trans = createTransport();
    trans.route();
    trans.costOfTransportation();
  }

  abstract Transport createTransport();
}

class RoadLogisticCreator extends Logistic
{
  Transport createTransport() {
    return new Truck();
  }
}

class SeaLogisticCreator extends Logistic
{
  Transport createTransport() {
    return new Ship();
  }
}


public class Solution
{
  public static void main(String[] args) {
    
    Transport transportation;
    
    Logistic logistic;
    
    if (args.length>0 && args[0].equals("sea"))
      logistic = new SeaLogisticCreator();
    else
      logistic = new RoadLogisticCreator();

    // transportation = logistic.createTransport();
    // transportation.costOfTransportation();

    logistic.planDelivery();
  }
}