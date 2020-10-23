#include <iostream>
#include <list>
#include <vector>
#include <algorithm>
#include <random>
#include <iomanip>

// Random values generator
class rand_int {
  std::default_random_engine generator;
  std::uniform_int_distribution<int> m_r;

public:
  // Constructor to generate values in the range [low..high]
  rand_int(int low, int high)
    : m_r{low,high}
  { }

  int operator()() { return m_r(generator); }
};


// Predicate to detect when an iteration reaches the requested position
class is_position {
  int m_pos;   // position requested
  int m_count; // current position
public:
  is_position(int p)
    : m_pos{p}, m_count{0} 
  { }

  bool operator()(int)
  {
    return m_pos == m_count++;
  }
};


class Timer {
  clock_t clk;
  double accum_time;
public:
  Timer()
    : clk(clock()), accum_time{0}
  { }

  void start() { clk = clock(); }

  double stop()
  {
    accum_time += double(clock()-clk)/CLOCKS_PER_SEC;
    return accum_time;
  }
};


// First algorithm:
// Insert n random generated values in the provided container keeping the container in order
template <typename C>
void order_insert(C& container, int n)
{
  rand_int rnd{1,n};
  for(int i=0;i<n;++i) {
    int elem = rnd();
    auto it = std::lower_bound(container.begin(),container.end(),elem);
    container.insert(it,elem);
  }
}


// Second algorithm:
// Remove n elements from the provided container.
// The elements are removed in random order 
template <typename C>
void random_pos_remove(C& container, int n)
{
  rand_int rnd{1,n};
  for(int i=0;i<n;++i) {
    int pos = rnd() % container.size();
    auto it = std::find_if(container.begin(),container.end(),is_position(pos));
    container.erase(it);
  }
}

// Computes the average time of running niter times the insertion and
// remove algorithms over n elements
template <typename Cont>
void profile(std::string label, int n, int niter)
{
  // Cont container;
  Timer t_ins;
  Timer t_rem;
  double time_ins;
  double time_rem;
  for(int j=0;j<niter;++j) {
    Cont container;
    t_ins.start();
    order_insert(container,n);
    time_ins = t_ins.stop();
    t_rem.start();
    random_pos_remove(container,n);
    time_rem = t_rem.stop();
    container.clear();
  }
  std::cout << label << ",\t"
	    << n << ",\t"
	    << std::setprecision(9)
	    << time_ins/niter << ",\t"
	    << time_rem/niter << std::endl;
}

int main()
{
  std::cout << "container,n,insert,remove" << std::endl;
  int base = 2;
  std::vector<int> points = {5,6,7,8,9,10,11,12,13,14};
  for(int n : points)
    profile<std::list<int>>("list",pow(base,n),10);

  for(int n : points)
    profile<std::vector<int>>("vector",pow(base,n),10);
  
  }
