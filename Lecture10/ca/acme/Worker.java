package ca.acme;

public class Worker extends Employee
{
  private static double baseSalary = 40000;

  private String position;
  private String[] certificates;
  private Boolean allwodedOverTime;
  private String imidiateBoss;
  private double workedHours;

  public Worker(String name, String email, String boss, String position) {
    super(name, email, baseSalary);
    allwodedOverTime = false;
    imidiateBoss = boss;
    this.position = position;
  }

  /**
   * Register the amount of hours worked
   * @param hours worked
   */
  public void registerWorkedHours(double hours) {
    workedHours += hours;
  }

  /**
   * @return the imidiateBoss
   */
  public String getImidiateBoss() {
    return imidiateBoss;
  }

  @Override
  public String toString() {
    return "  worker\n    "+super.toString() + " -> "+ position;
  }

  /**
   * @param baseSalary the baseSalary to set
   */
  public static void setBaseSalary(double baseSalary) {
    Worker.baseSalary = baseSalary;
  }
}