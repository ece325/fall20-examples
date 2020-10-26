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
  private static int counter = 0;
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


public class TestAssociation
{
  public static void main(String[] args) {
    Manager mng = new Manager("John Smith");
    int mngId = mng.getId();
    System.out.println(mng.getName() + " id:"+mngId);
  }
}