interface Shape
{
  void draw();
}

class Rectangle implements Shape
{
  public void draw() {
    System.out.println("-------\nDrawing a Rectangle");
  }
}

class Square implements Shape
{
  public void draw() {
    System.out.println("-------\nDrawing a Square");
  }
}

class Circle implements Shape
{
  public void draw() {
    System.out.println("-------\nDrawing a Circle");
  }
}

class RedDecorator implements Shape
{
  private Shape shape;

  public RedDecorator(Shape shape) {
    this.shape = shape;
  }

  public void draw() {
    shape.draw();
    System.out.println("Filled with Red colour");
  }  
}

class SmoothDecorator implements Shape
{
  private Shape shape;

  public SmoothDecorator(Shape shape) {
    this.shape = shape;
  }

  public void draw() {
    shape.draw();
    System.out.println("With Smooth texture");
  }  
}


public class Solution
{
  public static void main(String[] args) {
    
    Rectangle rect = new Rectangle();
    Square square = new Square();
    Circle circle = new Circle();

    rect.draw();
    square.draw();
    circle.draw();

    Shape redrect = new RedDecorator(rect);
    Shape smoothCircle = new SmoothDecorator(circle);
    
    redrect.draw();
    smoothCircle.draw();
    
    // If a want a Red Square with Smooth surface?
    Shape redSmoothSquare = new SmoothDecorator(new RedDecorator(square));
    redSmoothSquare.draw();
  }
}