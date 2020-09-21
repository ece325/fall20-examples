import ca.acme.*;

public class TestACME
{
  public static void main(String[] args) {

    ACME org = new ACME(10,45000);

    org.hire(new Manager("Scott Tiger", "stiger@acme.ca", 50000, "CEO"));
    org.hire(new Manager("Ann Mayer", "amayer@acme.ca", 45000, "Finance Director"));
    org.hire(new Worker("Jhon Smith", "jsmith@acme.ca","Ann Mayer","IT"));
    org.hire(new Manager("Don Tompson", "dtom@acme.ca", 45000, "Production Manager"));
    org.hire(new Worker("Carl Simpson", "carl@acme.ca","Don Tompson","Welder 1"));
    org.hire(new Worker("Peter Griffin", "peter@acme.ca","Don Tompson","CNC Machinist"));

    org.reportEmployees();
  }
}