class Employee
{
  private String name;
  private double salary;
  
  Employee(String name, double baseSalary)
  {
    this.name = name;
    this.salary = baseSalary;
  }

  /**
   * @return the employee's name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the employee salary
   */
  public double getSalary() {
    return salary;
  }

  /**
   * Modify the employee's salary by the specified percent
   * @param byPercent porcent amount to change the salary
   */
  public void raiseSalary(double byPercent) {
    salary *= byPercent;
  }
}

class Manager extends Employee
{
  private double bonus;

  Manager(String name, double baseSalary, double bonus)
  {
    super(name, baseSalary);
    this.bonus = bonus;
  }

  @Override
  public double getSalary() {
    return super.getSalary() + bonus;
  }
}

public class TestHR
{
  public static void main(String[] args) {
    Employee p = new Employee("Jhon", 40000);
    Manager m = new Manager("Scott", 50000, 4000);
    
    System.out.println(p.getName() + " salary: $" + p.getSalary());
    System.out.println(m.getName() + " salary: $" + m.getSalary());

    p.raiseSalary(1.2); // %20
    System.out.println(p.getName() + " New salary: $" + p.getSalary());
  }
}