import java.util.ArrayList;
import java.util.List;

class Code
{
  private int number;

  Code(int num) { number = num; }

  public int getNumber() {
    return number;
  }
}

class Employee
{
  public static int counter = 0;
  private final int id;
  private String name;

  Employee(String name) {
    this.name = name;
    id = ++counter;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}

class Manager
{
  private Employee employee;

  Manager(String name) {
    employee = new Employee(name);
  }

  public int getId() { return employee.getId(); }

  public String getName() { return employee.getName(); }
}

class Assistant extends Employee
{
  Assistant(Employee emp) {
    super(emp.getName());
  }
}

/*
class Assistant
{
  private Employee employee;

  Assistant(Employee emp) {
    employee = emp;
  }
  public int getId() { return employee.getId(); }

  public String getName() { return employee.getName(); }
}
*/

class Department 
{
  private List<Employee> employees;
  private Manager manager;
  private Assistant assistant;
  private String name;

  Department(String name) {
    this.name = name;
    employees = new ArrayList<Employee>();
  }

  /**
   * @param manager the manager to set
   */
  public void setManager(Manager manager) {
    this.manager = manager;
  }

  /**
   * @param assistant the assistant to set
   */
  public void setAssistant(Employee emp) {
    this.assistant = new Assistant(emp);
  }
  
  public void enroll(Employee emp) {
    employees.add(emp);
    System.out.println(emp.getName()+" works now for "+name+" department");
  }

  public String toString() {
    String res = name+"\n";
    res += " Manager: " + manager.getName() + "\n";
    res += " Assistant: " + (assistant==null ? "" : assistant.getName()) + "\n";
    for (Employee e : employees) {
      res += " - " + e.getName() + "\n";
    }
    return res;
  }
}

public class TestDepartment
{
  public static void main(String[] args) {
    
    Department qc = new Department("Quality Control");
    
    Employee emp1 = new Employee("Scott Tiger");
    Employee emp2 = new Employee("Martha Henderson");
    Employee emp3 = new Employee("Issac Warken");
    Manager emp4 = new Manager("John Smith");


    qc.enroll(emp1);
    qc.enroll(emp2);
    qc.enroll(emp3);
    qc.setManager(emp4);
    qc.setAssistant(emp3);
  
    System.out.println("-----------------------------");
    System.out.println(qc);
    System.out.println("-----------------------------");
    System.out.println("Number of employees: " + Employee.counter);
  }
}