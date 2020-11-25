import java.util.*;
import zoo.*;

public class TestJSONInterface
{
  public static String serialize(List<? extends JSONSerializable> list) {
    String json = "[\n";
    for(JSONSerializable obj : list) {
      json += obj.toJSON() + ",\n";
    }
    json += "]";
    return json;
  }


  public static void main(final String[] args) {

    Goat g = new Goat("goat");
    
    System.out.println(g.toJSON());

    // List<Animal> animals = new ArrayList();

    // animals.add(new Goat("Birdy the goat"));
    // animals.add(new Goat("Turtle goat"));
    // animals.add(g);

    // System.out.println(serialize(animals));
  }
}
