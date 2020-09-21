package ca.acme;

public class Manager extends Employee
{
  private double bonus;
  private String department;
  private Boolean isDirector;
  private String role;

  public Manager(String name, String email, double baseSalary, double bonus)
  {
    super(name, email, baseSalary);
    this.bonus = bonus;
    isDirector = false;
  }

  public Manager(String name, String email, double baseSalary, String role)
  {
    super(name, email, baseSalary);
    this.role = role;
    this.bonus = baseSalary * 0.1; // %10
    isDirector = false;
    department = "";
  }

  @Override
  public double getSalary() {
    return super.getSalary() + bonus;
  }

  /**
   * Change the rank of director 
   * @param value true to set as director
   */
  public void setDirector(Boolean value) {
    isDirector = value;
  }

  @Override
  public String toString() {
    return role + " " + department+"\n  " + super.toString();
  }
}

