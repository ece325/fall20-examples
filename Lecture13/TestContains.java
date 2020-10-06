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

  public String toString() {
    return firstName+" "+lastName;
  }
}


public class TestContains
{
  public static boolean contains(Object[] elements, Object value) {
    boolean found = false;

    for (Object val : elements) {
      if (val.equals(value)) {
        found = true;
      }
    }
    return found;
  }


  public static void report(Object obj, boolean found) {
    if (found) {
      System.out.println(obj + " is in the list");
    }
    else {
      System.out.println(obj + " in NOT in the list");        
    }
  }

  public static void main(String[] args) {
    
    String[] foods = {"apple","cinnamon","eggs","sugar","flour"};
 
    String f = "Eggs".toLowerCase();

    boolean found = contains(foods, f);
    report(f, found);

    // -----------------------------------------------

    FullName[] names = {new FullName("John", "Smith"),
                        new FullName("Dennis", "Ritchie"),             
                        new FullName("Ada", "Lovelace"),
                        new FullName("Charles", "Babbage")};
 
    FullName p = new FullName("Ada", "Lovelace");

    found = contains(names, p);

    report(p, found);

  }
}