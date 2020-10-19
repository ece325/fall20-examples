#include <iostream>

// ----------------------------
// Iterator
template <typename T, typename F>
class lazyIterator {
  int m_index;
  F   m_f;
    
public:
  typedef T value_type;
  
  lazyIterator(int i, const F& f=F())
    : m_index(i), m_f(f)
  { }

  lazyIterator& operator++()
  {
    ++m_index;
    return *this;
  }
  
  value_type operator*()
  {
    return m_f(m_index);
  }
  
  bool operator!=(lazyIterator const& other) const
  {
    return (m_index!=other.m_index);
  }
};

// ----------------------------
// Functores
struct identity {
  int operator()(int i) { return i; }
};

struct plus1 {
  int operator()(int i) { return i+1; }
};

struct even {
  int operator()(int i) { return i*2; }
};


// ----------------------------
// Contenedor
template <typename F=identity>
class lazyContainer {
  int m_size;
  F m_f;
public:
  typedef decltype(m_f(int()))         value_type;
  typedef lazyIterator<value_type, F>  iterator;
  
  lazyContainer(int n, F const& f=F())
    : m_size(n), m_f(f)
  { }

  iterator begin()
  {
    return iterator(0,m_f);
  }

  iterator end()
  {
    return iterator(m_size,m_f);
  }
};


int main(int argc, const char * argv[])
{
  std::cout << "Identity\n";
  auto c = lazyContainer<>(10);
  for(auto x : c)
    std::cout << x << " ";
  std::cout << std::endl;

  
  std::cout << "Plus one\n";
  auto w = lazyContainer<plus1>(10);
  for(auto x : w)
    std::cout << x << " ";
  std::cout << std::endl;


  std::cout << "Even numbers\n";
  auto y = lazyContainer<even>(10);
  for(auto x : y)
    std::cout << x << " ";
  std::cout << std::endl;
 return 0;
}

