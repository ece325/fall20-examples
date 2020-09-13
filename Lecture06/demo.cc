#include <iostream>

struct Integer
{
  int value;

  Integer(int x) : value{x} {}

  operator int() {
    return value;
  }
};

int main(int argc, char const *argv[])
{
  Integer num = 100;
  int m = 200;
  Integer num2 = m;
  num = 500;

  std::cout << "num:" << num 
            << " num2:" << num2
            << std::endl;
  return 0;
}
