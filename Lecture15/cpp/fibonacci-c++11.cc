// C++11

#include <iostream>

constexpr long fibo(int n)
{
  return (n==0 || n==1) ? 1 : fibo(n-1) + fibo(n-2);
}


int main()
{
  constexpr int x = 34;
  constexpr long res = fibo(x);
  std::cout << "fibo("<<x<<"): " << res<< std::endl;
  return 0;
}
