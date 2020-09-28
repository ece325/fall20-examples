#include <iostream>
#include <chrono>
#include <sstream>

class Employee 
{
  static int numEmployees;
  using date_time_t = std::chrono::time_point<std::chrono::system_clock>;

  int          id;
  std::string  name;
  double       salary;
  date_time_t  start_date;
  std::string  email;

public:

  Employee(std::string _name, std::string _email, double _baseSalary) 
    : id{++numEmployees + 100},
      name{_name},
      salary{_baseSalary},
      start_date{std::chrono::system_clock::now()},
      email{_email}
  { }

  std::string getName() const {
    return name;
  }

  virtual double getSalary() const {
    return salary;
  }

  void raiseSalary(double byPercent) {
    salary *= byPercent;
  }

  virtual std::string toString() const {
    std::stringstream ss;
    ss << "(" << id << ") " << name << " <" << email << ">";
    return ss.str();
  }

};

int Employee::numEmployees = 0;


class Manager : public Employee
{
  double      bonus;
  std::string department;
  bool        isDirector;
  std::string role;

public:

  Manager(std::string _name, std::string _email, double _baseSalary, double _bonus)
    : Employee(_name, _email, _baseSalary),
      bonus{_bonus},
      isDirector{false}
  { }

  Manager(std::string _name, std::string _email, double _baseSalary, std::string _role)
    : Manager(_name, _email, _baseSalary, _baseSalary * 0.1)
  { 
    role = _role;
  }

  virtual double getSalary() const {
    return Employee::getSalary() + bonus;
  }

  void setDirector(bool value) {
    isDirector = value;
  }

  virtual std::string toString() const {
    std::stringstream ss;
    ss << role << " " << department << "\n  " << Employee::toString();
    return ss.str();
  }

};



int main(int argc, char const *argv[])
{
  Manager* scott = new Manager("Scott Tiger", "stiger@acme.ca", 50000, "Finance Director");
  Employee* staff = scott;
  Employee* staff1 = new Manager("Ann Mayer", "amayer@acme.ca", 60000, "Sales Manager");

  // Employee* scott = new Employee("Scott Tiger", "stiger@acme.ca", 50000);
  // Manager* staff = scott;
  // Manager* staff1 = new Employee("Ann Mayer", "amayer@acme.ca", 50000);

  std::cout << scott->toString() << " salary: $"  << scott->getSalary() << std::endl;
  std::cout << "------------------\n";
  std::cout << staff->toString() << " salary: $"  << staff->getSalary() << std::endl;
  std::cout << "------------------\n";
  std::cout << staff1->toString() << " salary: $"  << staff1->getSalary() << std::endl;

  return 0;
}
