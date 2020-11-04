class Rectangle
{
  public void draw() {
    System.out.println("-------\nDrawing a Rectangle");
  }
}

class Square
{
  public void draw() {
    System.out.println("-------\nDrawing a Square");
  }
}

class Circle
{
  public void draw() {
    System.out.println("-------\nDrawing a Circle");
  }
}

class RedRectangle extends Rectangle
{
  public void draw() {
    super.draw();
    System.out.println("Filled with Red colour");
  }  
}

class SmoothCircle extends Circle
{
  public void draw() {
    super.draw();
    System.out.println("With Smooth texture");
  }  
}


public class Problem
{
  public static void main(String[] args) {
    
    Rectangle rect = new Rectangle();
    Square square = new Square();
    Circle circle = new Circle();

    rect.draw();
    square.draw();
    circle.draw();

    // RedRectangle redrect = new RedRectangle();
    // SmoothCircle smoothCircle = new SmoothCircle();
    
    // redrect.draw();
    // smoothCircle.draw();
    
    // If we want a Red Square with Smooth surface?
  }
}