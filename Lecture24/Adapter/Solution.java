interface Point
{
  double getX();
  double getY();
}

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

class CartPoint implements Point
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

class PointAdapter implements Point
{
  private PolarPoint point;

  public PointAdapter(double x, double y) {
    double angle = Math.atan2(x,y);
    double length = Math.sqrt(x*x + y*y);
    point = new PolarPoint(angle,length);
  }

  public double getX() {
    return point.getLength() * Math.cos(point.getAngle());
  }

  public double getY() {
    return point.getLength() * Math.sin(point.getAngle());
  }
}


class Calc 
{
  public static double distance(Point p1, Point p2) {
    double xdiff = Math.pow(Math.abs(p1.getX()-p2.getX()), 2);
    double ydiff = Math.pow(Math.abs(p1.getY()-p2.getY()), 2);
    return Math.sqrt(xdiff + ydiff);
  }
}


public class Solution
{

  public static void main(String[] args) {

    Point p1 = new CartPoint(12, 12);
    Point p2 = new CartPoint(0, 1);

    System.out.println("Distance: " + Calc.distance(p1,p2));

    
    Point p3 = new PointAdapter(12, 12);
    Point p4 = new PointAdapter(0, 1);

    System.out.println("Distance: " + Calc.distance(p3,p4));
  }
}