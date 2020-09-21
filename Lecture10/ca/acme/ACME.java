package ca.acme;

public class ACME 
{
  private Employee[] employees;
  private static int maxNumEmployees;
  private int numEmployees;

  public ACME(int maxNumEmployees, double baseSalary)
  {
    ACME.maxNumEmployees = maxNumEmployees;
    employees = new Employee[maxNumEmployees];
    Worker.setBaseSalary(baseSalary);
    numEmployees = 0;
  }

  public void hire(Employee newEmployee)
  {
    if (numEmployees < ACME.maxNumEmployees) { 
      employees[numEmployees++] = newEmployee;
    } else {
      System.out.println("Can't hire more employees");
    }
  }

  public void reportEmployees()
  {
    for (Employee emp : employees) {
      if (emp != null)
        System.out.println(emp);
    }
  }
}