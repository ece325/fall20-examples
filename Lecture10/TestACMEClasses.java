import ca.acme.*;

public class TestACMEClasses
{
  public static void main(String[] args) {
    Manager ceo = new Manager("Scott Tiger", "stiger@acme.ca", 50000, "CEO");
    Manager m1 = new Manager("Ann Mayer", "amayer@acme.ca", 45000, "Finance Director");
    Worker w1 = new Worker("Jhon Smith", "jsmith@acme.ca","Ann Mayer","IT");
    Manager m2 = new Manager("Don Tompson", "dtom@acme.ca", 45000, "Production Manager");
    Worker w2 = new Worker("Carl Simpson", "carl@acme.ca","Don Tompson","Welder 1");
    Worker w3 = new Worker("Peter Griffin", "peter@acme.ca","Don Tompson","CNC Machinist");
    
    System.out.println(ceo + " salary: $" + ceo.getSalary());
    System.out.println(m1 + " salary: $" + m1.getSalary());
    System.out.println(w1 + " salary: $" + w1.getSalary());
    System.out.println(m2);
    System.out.println(w2);
    System.out.println(w3);

    System.out.println("Number of employees of ACME.ca: "+Employee.getNumEmployees());
  }
}