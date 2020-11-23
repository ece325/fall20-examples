#include <iostream>
#include <functional>

void test(std::function<int(int)> f, int n) {
  std::cout << "In test calling function f("<< n 
            << ") = " << f(n)
            << std::endl;
}

int main(int argc, char const *argv[])
{
  int a = 10;
  int b = 100;

  // auto f = [a](int x) -> int { return x+a; };

  auto f = [a](auto x) { return x+a; };

  std::cout << "f(5) = " << f(5.3) << std::endl;


  auto g = [a,&b](auto x) { b -=x; return b+a; };

  a = 20;

  std::cout << "g(5) = " << g(5) << std::endl;

  std::cout << " a = " << a << " b = " << b << std::endl;

  test(f,5);
  test(g,5);

  std::cout << " a = " << a << " b = " << b << std::endl;

  test([](int x) { return x*x;}, 5);
}
