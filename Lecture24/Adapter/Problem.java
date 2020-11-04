
class PolarPoint
{
  private double angle;
  private double length;

  public PolarPoint(double a, double l) {
    angle = a;
    length = l;
  }

  public double getAngle() {
    return angle;
  }

  public double getLength() {
    return length;
  }
}

class CartPoint
{
  private double x;
  private double y;

  public CartPoint(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }
  
  public double getY() {
    return y;
  }
}


class Calc 
{
  public static double distance(CartPoint p1, CartPoint p2) {
    double xdiff = Math.pow(Math.abs(p1.getX()-p2.getX()), 2);
    double ydiff = Math.pow(Math.abs(p1.getY()-p2.getY()), 2);
    return Math.sqrt(xdiff + ydiff);
  }
}

public class Problem
{

  public static void main(String[] args) {

    CartPoint p1 = new CartPoint(12, 12);
    CartPoint p2 = new CartPoint(0, 1);

    System.out.println("Distance: " + Calc.distance(p1,p2));


    PolarPoint p3 = new PolarPoint(Math.PI/4, 10);
    PolarPoint p4 = new PolarPoint(0, 1);

    System.out.println("Distance: " + Calc.distance(p3,p4));
  }
}