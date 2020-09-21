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
  
  public abstract double area();

  public abstract double perimeter();

  public abstract double[] dimensions();
  
  public abstract int numberOfSides();
}


public class TestGeometricFigures1
{
  public static void main(String[] args) {
    GeometricFigure fig = new GeometricFigure("Figure 1","red");
  }
}