import ca.acme.*;

public class TestCompatibility
{
  public static void main(String[] args) {
    Manager scott = new Manager("Scott Tiger", "stiger@acme.ca", 50000, "Finance Director");
    Employee staff = scott;
    Employee staff1 = new Manager("Ann Mayer", "amayer@acme.ca", 60000, "Sales Manager");
    
    System.out.println(scott + " salary: $" + scott.getSalary());
    System.out.println("------------------");
    System.out.println(staff + " salary: $" + staff.getSalary());
    System.out.println("------------------");
    System.out.println(staff1 + " salary: $" + staff1.getSalary());
  }
}