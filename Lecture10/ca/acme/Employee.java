package ca.acme;

import java.util.Date;
import java.util.Calendar;

public class Employee
{
  private static int numEmployees;

  private int id;
  private String name;
  private double salary;
  private Date start_date;
  private String email;

  public Employee(String name, String email, double baseSalary)
  {
    id = ++numEmployees + 100;
    this.name = name;
    this.salary = baseSalary;
    start_date = new Date();
    this.email = email;
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

  public String toString() {
    return "("+id+") "+name + " <"+email+">";
  }

  /**
   * @return the numEmployees
   */
  public static int getNumEmployees() {
    return numEmployees;
  }
}
