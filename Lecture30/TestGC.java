import java.util.*;
import java.util.stream.*;

class SmallData
{
  private Double data;

  SmallData() {}
}

class MediumData
{
  private Double[] data;

  MediumData() { data = new Double[256]; }
}


public class TestGC
{
  static List objects = new ArrayList<Object>();
  static Random rand = new Random();
  static int counter = 0;

  public static void actionSmall(int option) {
    if (option % 3 == 0) {
      objects.add(new SmallData());      
    }
    if (option % 3 == 1) {
      int size = objects.size();
      if (size>0) {
        int pos = rand.nextInt(size); 
        objects.set(pos, new SmallData());      
      }
    }
    if (option % 3 == 2) {
      int size = objects.size();
      if (size>0) {
        int pos = rand.nextInt(size); 
        objects.remove(pos);      
      }
    }
  }

  public static void actionMedium(int option) {
    if (option % 4 == 0) {
      objects.add(new SmallData());      
    }
    if (option % 4 == 1) {
      int size = objects.size();
      if (size>0) {
        int pos = rand.nextInt(size); 
        objects.set(pos, new SmallData());      
      }
    }
    if (option % 4 == 2) {
      int size = objects.size();
      if (size>0) {
        int pos = rand.nextInt(size); 
        objects.remove(pos);      
      }
    }
    if (option % 4 == 3) {
      int size = objects.size();
      if (size>0) {
        int pos = rand.nextInt(size); 
        objects.set(pos, new MediumData());      
      }
    }
  }

  public static void TestSmall() {
    Stream.generate(Math::random)
          .peek(i -> { ++counter; if (counter==1000) { System.out.println(objects.size()); counter=0; }})
          .forEach(i -> actionSmall((int)(i*10))); 
  }

  public static void TestMedium() {
    Stream.generate(Math::random)
          .peek(i -> { ++counter; if (counter==1000) { System.out.println(objects.size()); counter=0; }})
          .forEach(i -> actionMedium((int)(i*10))); 
  }

  public static void main(String[] args) {
    TestSmall();
    // TestMedium();
  }

}