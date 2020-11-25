import java.lang.reflect.*;
import java.util.*;

import zoo.*;

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


public class Test1
{

  public static void getNameFromObject(Object obj) {
    System.out.println("------- getNameFromObject -------");
    Class<?> clazz = obj.getClass();
    System.out.println("Simple name: "+clazz.getSimpleName());
    System.out.println("Name: "+clazz.getName());
    System.out.println("Canonical name: "+clazz.getCanonicalName());
  }

  public static void getModifiersFromObject(Object obj) {
    System.out.println("------- getModifiersFromObject -------");
    Class<?> clazz = obj.getClass();
    int modifiers = clazz.getModifiers();
    System.out.println(Integer.toBinaryString(modifiers));  
    System.out.println("isPublic ("+clazz.getName()+"): " + Modifier.isPublic(modifiers));
    System.out.println("isAbstract ("+clazz.getName()+"): " + Modifier.isAbstract(modifiers));
    System.out.println("isStatic ("+clazz.getName()+"): " + Modifier.isStatic(modifiers));
    System.out.println("isFinal ("+clazz.getName()+"): " + Modifier.isFinal(modifiers));
  }

  public static void getSuperClass(Object obj) {
    System.out.println("------- getSuperClass -------");
    Class<?> clazz = obj.getClass();
    Class<?> superClazz = clazz.getSuperclass();
    System.out.println("Super class of "+ clazz.getSimpleName()+ " is "
                       +superClazz.getSimpleName());
  }

  public static void getImplementedInterfaces(String class_name) {
    System.out.println("------- getsImplementedInterfaces -------");
    try {
      Class<?> clazz = Class.forName(class_name);  
      Class<?>[] clazzInterfaces = clazz.getInterfaces();
      System.out.println(clazz.getName()+" implements:");
      for (int i=0; i<clazzInterfaces.length;++i) {
        System.out.println(" - " + clazzInterfaces[i].getName());
      }
    }
    catch(ClassNotFoundException e) {
      System.out.println("Classe "+class_name+" not found");
    }
  }

  public static void getConstructors(String class_name) {
    System.out.println("------- getConstructors -------");
    try {
      Class<?> clazz = Class.forName(class_name);      
      Constructor<?>[] constructors = clazz.getConstructors();
      System.out.println(clazz.getName() + " has " + constructors.length+" constructors");
      for (int i=0; i<constructors.length;++i) {
        System.out.println(" - " + constructors[i].getName());
      }
    }
    catch(ClassNotFoundException e) {
      System.out.println("Class "+class_name+" not found");
    }
  }

  public static <R> R useConstructor(String class_name) {
    try {
      Class<?> clazz = Class.forName(class_name);      
      Constructor<?> cons = clazz.getConstructor(String.class);
      R obj = (R) cons.newInstance("The-New-Instance");
      return obj;
    }
    catch (NoSuchMethodException e) {
        System.out.println("Class "+class_name+"does not have a constructor expecting a String");
    }
    catch(ClassNotFoundException e) {
      System.out.println("Class "+class_name+" not found");
    }
    catch (Exception e) {
      System.out.println("New instance of "+class_name+" was not created");
    }
    return null;
  }

  public static void getFields(String class_name) {
    System.out.println("------- getFields -------");
    try {
      Class<?> clazz = Class.forName(class_name);
      Field[] publicFields = clazz.getFields();
      Field[] allfields = clazz.getDeclaredFields();
      System.out.println("Public memebers of "+clazz.getName());
      for (Field field: publicFields) {
        System.out.println(" - " + field.getName()+": "+field.getType().getName());
      }
      System.out.println("All memebers of "+clazz.getName());
      for (Field field: allfields) {
        System.out.println(" - " + field.getName()+": "+field.getType().getName());
      }
    }
    catch(ClassNotFoundException e) {
      System.out.println("Class "+class_name+" not found");
    }
  }

  public static void changePrivateField(Object obj, String value) {
    System.out.println("------- changePrivateField -------");
    Class<?> clazz = obj.getClass();
    try {
      Field privateField = clazz.getDeclaredField("name");
      //turning off access check with below method call
      privateField.setAccessible(true);
      System.out.println("Old value: "+privateField.get(obj));
      privateField.set(obj, value);
      System.out.println("Updated value: "+privateField.get(obj));
    }
    catch(Exception e) {
      System.out.println("Problems updating name field");
    }
  }

  public static void getMethods(String class_name) {
    System.out.println("------- getMethods -------");
    try {
      Class<?> clazz = Class.forName(class_name);
      Method[] publicMethods = clazz.getMethods();
      Method[] allMethods = clazz.getDeclaredMethods();
      System.out.println("Public methods of "+clazz.getName());
      for (Method method: publicMethods) {
        System.out.println(" - " + method.getName()+" -> "+method.getReturnType().getName());
      }
      System.out.println("All methods of "+clazz.getName());
      for (Method method: allMethods) {
        System.out.println(" - " + method.getName()+" -> "+method.getReturnType().getName());
      }

    }
    catch(Exception e) {
      System.out.println("Class "+class_name+" not found");
    }
  }

  public static void invokePublicMethod(Object obj, int value) {
    System.out.println("------- invokeMethod -------");
    Class<?> clazz = obj.getClass();
    try {
      Class[] args = new Class[1];
      args[0] = Integer.class;
      Method method = clazz.getDeclaredMethod("setAge", args);
      method.invoke(obj, value); 
    }
    catch(Exception e) {
      System.out.println("Problems invoking setAge method\n"+e);
    }
  }
  

  public static void main(String[] args) {

    List<?> list = new ArrayList<Integer>();

    getNameFromObject(5.4);
    getNameFromObject(list);
    Goat g = new Goat("goat");
    getNameFromObject(g);

    getModifiersFromObject(5.4);
    getModifiersFromObject(list);
    getModifiersFromObject(g);

    getSuperClass(5.4);
    getSuperClass(list);
    getSuperClass(g);

    getImplementedInterfaces("java.lang.Double");
    getImplementedInterfaces("java.util.ArrayList");
    getImplementedInterfaces("zoo.Goat");

    getConstructors("java.lang.Double");
    getConstructors("java.util.ArrayList");
    getConstructors("zoo.Goat");
    Goat g2 = useConstructor("zoo.Goat");
    System.out.println("New Goat name:"+g2.getName());
    Double num = useConstructor("java.lang.Double");
    System.out.println("New Double name:"+num);

    getFields("java.lang.Double");
    getFields("java.util.ArrayList");
    getFields("zoo.Goat");
    
    getMethods("java.lang.Double");
    getMethods("java.util.ArrayList");
    getMethods("zoo.Goat");

    Person p = new Person("John Smith", 35);
    System.out.println("\nPerson: "+p);
    changePrivateField(p,"Hacked name");
    System.out.println("Person: "+p);

    System.out.println("\nPerson: "+p);
    invokePublicMethod(p,66);
    System.out.println("Person: "+p);
  }
}

