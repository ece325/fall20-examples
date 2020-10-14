// Runtime

#include <iostream>

long fibo(int n)
{
  return (n==0 || n==1) ? 1 : fibo(n-1)+fibo(n-2);
}


int main()
{
  int x = 34;
  long res = fibo(x);
  int c = 0;
  std::cout << "fibo("<<x<<"): " << res << std::endl;
  return 0;
}
