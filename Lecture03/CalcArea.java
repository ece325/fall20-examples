public class CalcArea
{
  // Pi constant
  static double Pi = 3.14159;

  /**
   * Calculate the area of a rectangle given the specified dimension 
   * @param width rectangle width
   * @param height rectangle height
   * @return Rectangle area
   */
  public static double rectangleArea(int width, int height) {
    double area = width * height;
    return area;
  }

  /**
   * Calculate the area of a circle given the specified radius
   * @param radius radius of the circle
   * @return Circle area
   */
  public static double circleArea(int radius) {
    double area = Pi * radius * radius;
    return area;
  }
  
  public static void main(String[] args) {
    int w = 5;
    int h = 6;
    double rectArea = rectangleArea(w, h);
    double circArea;
    if (w < h) {
      circArea = circleArea(w/2);
    } else {
      circArea = circleArea(h/2);
    }
    System.out.println("Rectangle area ("+w+"x"+h+") = " + rectArea);
    System.out.println("Area of circumscribed circle = " + circArea);
  }
}