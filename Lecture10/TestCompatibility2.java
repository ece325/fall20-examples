import ca.acme.*;

public class TestCompatibility2
{
  public static void main(String[] args) {
    Employee scott = new Employee("Scott Tiger", "stiger@acme.ca", 50000);
    Manager staff = scott;
    Manager staff1 = new Employee("Ann Mayer", "amayer@acme.ca", 50000);
    
    System.out.println(scott + " salary: $" + scott.getSalary());
    System.out.println("------------------");
    System.out.println(staff + " salary: $" + staff.getSalary());
    System.out.println("------------------");
    System.out.println(staff1 + " salary: $" + staff1.getSalary());
  }
}