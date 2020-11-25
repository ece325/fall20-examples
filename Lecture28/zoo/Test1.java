package zoo;

import java.lang.reflect.*;
import java.util.*;

class Person {
  private String name;
  private int age;
}

class Worker extends Person
{
  private int id;
}

public class Test1
{
  public static void getAttributesFromObject(Object obj) {
    Field[] fields = obj.getClass().getDeclaredFields();
 
    List<String> actualFieldNames = getFieldNames(fields);
    actualFieldNames.stream().forEach(System.out::println);
  } 

  private static List<String> getFieldNames(Field[] fields) {
    List<String> fieldNames = new ArrayList<>();
    for (Field field : fields)
      fieldNames.add(field.getName());
    return fieldNames;
  }

  public static void getNameFromObject(Object obj) {
    Class<?> clazz = obj.getClass();
    System.out.println("Simple name: "+clazz.getSimpleName());
    System.out.println("Name: "+clazz.getName());
    System.out.println("Canonical name: "+clazz.getCanonicalName());
  }

  public static void getModifiersFromObject() {
    try {
      Class<?> goatClass = Class.forName("zoo.Goat");
      Class<?> animalClass = Class.forName("zoo.Animal");
 
      int goatMods = goatClass.getModifiers();
      int animalMods = animalClass.getModifiers();
  
      System.out.println("isPublic (Goat): " + Modifier.isPublic(goatMods));
      System.out.println("isAbstract (Goat): " + Modifier.isAbstract(goatMods));
      System.out.println("isPublic (Animal): " + Modifier.isPublic(animalMods));
      System.out.println("isAbstract (Animal): " + Modifier.isAbstract(animalMods));
    }
    catch(Exception e) {
      System.out.println("Classes not found");
    }
  }

  public static void getPackageInfo() {
    Goat goat = new Goat();
    Class<?> goatClass = goat.getClass();
    Package pkg = goatClass.getPackage();
 
    System.out.println("Package name: " + pkg.getName());
  }

  public static void getsImplementedInterfaces(String class_name) {
    try {
      Class<?> clazz = Class.forName(class_name);
  
      Class<?>[] clazzInterfaces = clazz.getInterfaces();
  
      System.out.println(clazz.getName());
      for (int i=0; i<clazzInterfaces.length;++i) {
        System.out.println("Interface name: "+clazzInterfaces[i].getName());
      }
    }
    catch(Exception e) {
      System.out.println("Classe "+class_name+" not found");
    }
  }

  public static void getConstructors(String class_name) {
    System.out.println("------- getConstructors -------");
    try {
      Class<?> clazz = Class.forName(class_name);
      
      Constructor<?>[] constructors = clazz.getConstructors();
      
      System.out.println(clazz.getName());
      for (int i=0; i<constructors.length;++i) {
        System.out.println("Constructors: "+constructors[i].getName());
      }
    }
    catch(Exception e) {
      System.out.println("Classe "+class_name+" not found");
    }
  }


  public static void getFields(String class_name) {
    System.out.println("------- getFields -------");
    try {
      Class<?> clazz = Class.forName(class_name);
      Field[] fields = clazz.getDeclaredFields();
      
      List<String> actualFields = getFieldNames(fields);
      actualFields.stream().forEach(System.out::println);
    }
    catch(Exception e) {
      System.out.println("Classe "+class_name+" not found");
    }
  }

  public static void main(String[] args) {
    Person p = new Person();
    getAttributesFromObject(p);
    Worker w = new Worker();
    getAttributesFromObject(w);


    Goat g = new Goat();
    getAttributesFromObject(g);
    getNameFromObject(g);
    getModifiersFromObject();
    getPackageInfo();
    getsImplementedInterfaces("zoo.Goat");
    getsImplementedInterfaces("zoo.Animal");
    getConstructors("zoo.Goat");
    getConstructors("zoo.Animal");

    getFields("zoo.Goat");
    getFields("zoo.Animal");
  }
}

