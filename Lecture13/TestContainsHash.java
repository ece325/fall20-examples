import java.util.Objects;

class FullName
{
  private String firstName;
  private String lastName;

  public FullName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }


  @Override
  public boolean equals(Object obj) {
    if (obj == this)
      return true;
    if (!(obj instanceof FullName)) {
        return false;
    }
    FullName fullName = (FullName) obj;
    return firstName.equals(fullName.firstName) && lastName.equals(fullName.lastName);
  }

/** */
  // @Override
  // public int hashCode()
  // {
  //   int prime = 31;
  //   int result = 1;
  //   result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
  //   result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
  //   return result;
  // }
/* */

/** */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
/**/

  public String toString() {
    return firstName+" "+lastName;
  }
}


/**
 * A simple Set data structure
 */
class Set 
{
  private static final int PRIME = 31;
  
  private Object[] data;

  Set() {
    data = new Object[PRIME];
  }

  int hash(Integer k) {
    return Math.abs(k) % PRIME;
  }

  public void insert(Object elem) {
    if (!contains(elem)) {
      int i = hash(elem.hashCode());
      data[i] = elem;
    }
    else {
      System.out.println(elem+" already in set");
    }
  }

  public boolean contains(Object elem) {
    int k = elem.hashCode();
    int i = hash(k);
    if (data[i]!=null)
      return true;
    return false;
  }

  public String toString() {
    String out = "";
    for (Object obj : data) {
      out += obj+", ";
    }
    return out;
  }
}


public class TestContainsHash
{
  public static void report(Object obj, boolean found) {
    if (found) {
      System.out.println(obj + " is in the list");
    }
    else {
      System.out.println(obj + " in NOT in the list");        
    }
  }

  public static void main(String[] args) {
    
    Set foodSet = new Set();

    String[] foods = {"apple","cinnamon","eggs","sugar","flour"};
 
    for(String food : foods) {
      foodSet.insert(food);
    }

    String f = "Eggs".toLowerCase();

    boolean found = foodSet.contains(f);
    report(f, found);

    System.out.println(foodSet);

    System.out.println("------------------------");

    Set nameSet = new Set();

    FullName[] names = {new FullName("John", "Smith"),
                        new FullName("Dennis", "Ritchie"),             
                        new FullName("Ada", "Lovelace"),
                        new FullName("Charles", "Babbage")};
 
    for(FullName name : names) {
      nameSet.insert(name);
    }

    FullName p = new FullName("John", "Smith");

    found = nameSet.contains(p);

    report(p, found);

    System.out.println(nameSet);

  }
}