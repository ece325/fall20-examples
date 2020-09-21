abstract class GeometricFigure
{
  private String name;
  private String color;

  public GeometricFigure(String name, String color)
  {
    this.name = name;
    this.color = color;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the color
   */
  public String getColor() {
    return color;
  }

  /**
   * @param color the color to set
   */
  public void setColor(String color) {
    this.color = color;
  }
  
  public abstract double area();

  public abstract double perimeter();

  public abstract double[] dimensions();
  
  public abstract int numberOfSides();
}

class Rectangle extends GeometricFigure
{
  private double height;
  private double width;

  public Rectangle(String name, double h, double w)
  {
    super(name, "Blue");
    height = h;
    width = w;
  }

  public double area() { return height*width; }

  public double perimeter() { return 2*height + 2*width; }

  public double[] dimensions() { 
    double[] dim = { height, width };
    return dim; 
  }
  
  public int numberOfSides() { return 4; }
}

class Square extends Rectangle
{
  public Square(String name, double side)
  {
    super(name, side, side);
    setColor("Purple");
  }
}

public class TestGeometricFigures3
{
  public static void main(String[] args) {
    Rectangle fig = new Rectangle("Rect1", 10, 15);
    System.out.println(fig.getName()+" area:"+fig.area());

    Square fig2 = new Square("Square1", 12);
    System.out.println(fig2.getName()+" area:"+fig2.area());
  }
}