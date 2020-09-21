#include <iostream>

class A
{
  int id;
protected:
  double value;
public:
  void inc() { ++value; }
};

struct B
  : virtual public A
{
  void inc() { value += 2; }
};

struct C
  : virtual public A
{
  void inc() { value += 5; }
};

struct D
  : virtual public B, 
    virtual public C
{
  // Error: Ambiguous invocation 
  void print1() const
  {
    std::cout << "value: " << value << std::endl;
  }
  
  // Ok
  void print2() const
  {
    std::cout << "B:value: " << B::value << std::endl;
    std::cout << "A:value: " << C::value << std::endl;
  }
};

int main(int argc, char const *argv[])
{
  D d;
  // d.inc();

  d.B::inc();
  d.C::inc();

  d.print1(); 
  d.print2();
}
