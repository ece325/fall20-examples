import java.lang.reflect.*;
import java.util.*;

class Person
{
  private String name;
  private Integer age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String toString() {
    return "("+name+", "+age+")";
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}

class Worker extends Person
{
  private static int id_counter = 0;
  private Integer id;

  public Worker(String name, int age) {
    super(name, age);
    id = ++id_counter;
  }
}


class Point
{
  int x;
  int y;
 
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class SerializeToJSON
{
  public static String serializeObject(Object obj) {
    String json = "{\n";
    try {
      Class<?> clazz = obj.getClass();
      while (clazz!=null) {
        Field[] allfields = clazz.getDeclaredFields();
        for (Field field: allfields) {
          field.setAccessible(true);  
          json += "  "+field.getName()+": ";
          Type type = field.getType();
          if (type.equals(String.class))
            json += "\""+field.get(obj)+"\"";
          else
            json += field.get(obj);
          json += ",\n";
        }
        clazz = clazz.getSuperclass();
      }
    }
    catch (Exception e) {
      System.out.println(e);
    }
    return json+"}";
  }

  public static String serializeObject(List<?> list) {
    String json = "[\n";
    json += list.stream().map(o -> serializeObject(o)).reduce("", (a,b) -> a+b+",\n");
    return json+"\n]";
  }

  public static void main(String[] args) {
    List<Object> objects = new ArrayList();

    Person p = new Person("John Smith", 35);
    Worker w = new Worker("Scott Tiger", 28);    

    objects.add(p);
    objects.add(w);
    objects.add(new Point(5,8));
    System.out.println(serializeObject(objects));

  }

}