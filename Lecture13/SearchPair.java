class FullName
{
  private String firstName;
  private String lastName;

  FullName(String fname, String lname) {
    firstName = fname;
    lastName = lname;
  }

  public String toString() {
    return firstName+" "+lastName;
  }
}


public class SearchPair
{
  public static void report(FullName name, boolean invited) {
    if (invited) {
      System.out.println(name + " is in the list!");
    }
    else {
      System.out.println(name + " was not invited!");        
    }
  }

  public static void main(String[] args) {
    
    FullName[] names = {new FullName("John", "Smith"),
                        new FullName("Dennis", "Ritchie"),             
                        new FullName("Ada", "Lovelace"),
                        new FullName("Charles", "Babbage")};
 
    // FullName p = new FullName("Scott", "Tiger");
    FullName p = new FullName("Ada", "Lovelace");

    boolean invited = false;

    for (FullName name : names) {
      if (p==name) {
        invited = true;
      }
    }
    
    report(p, invited);

    // -----------------------

    invited = false;

    for (FullName name : names) {
      if (p.equals(name)) {
        invited = true;
      }
    }

    report(p, invited);

  }
}