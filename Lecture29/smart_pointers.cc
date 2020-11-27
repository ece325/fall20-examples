#include <iostream>
#include <memory>
#include <string>
#include <cassert>

class Foo
{
  std::string value;

public:
  Foo(std::string val) : value{val} {
    std::cout << "+ Foo constructor value:"<< value << std::endl;
  }

  Foo(const Foo& other) : value{other.value} {
    std::cout << "+ Foo COPY constructor value:"<< value << std::endl;
  }

  ~Foo() {
    std::cout << "- Foo destructor value:"<< value << std::endl;
  }

  void test(std::string flag="") {
    std::cout << "  * Testing " << value << flag << std::endl;
  }
};

template<typename P>
P test_function(P p) {
  p->test(" (fun)");
  return p;
}

void test_raw_memory() {
  std::cout << "/Begin of test_raw_memory\n";
  Foo* foo = new Foo("raw_memory");
  auto q = test_function(foo);
  foo->test();
  q->test(" (q)");
  delete foo;
  std::cout << "\\End of test_raw_memory\n";
}

void test_unique_ptr() {
  std::cout << "/Begin of test_unique_ptr\n";
  std::unique_ptr<Foo> foo = std::make_unique<Foo>("unique_ptr");
  // auto q = test_function(foo);
  auto q = test_function(std::move(foo));
  q->test(" (q)");
  if (!foo)
    std::cout << "[foo is nullptr]\n";
  else
    foo->test();
  std::cout << "\\End of test_unique_ptr\n";
}

void test_shared_ptr() {
  std::cout << "/Begin of test_shared_ptr\n";
  std::shared_ptr<Foo> foo = std::make_shared<Foo>("shared_ptr");
  auto q = test_function(foo);
  q->test(" (q)");
  {
    auto p = q;
    p->test(" (p)");
  }
  if (!foo)
    std::cout << "[foo is nullptr]\n";
  else
    foo->test();
  std::cout << "foo reference counting: " << foo.use_count() << std::endl;
  std::cout << "\\End of test_unique_ptr\n";
}


int main(int argc, char const *argv[])
{
  test_raw_memory();
  std::cout << "\n\n";
  test_unique_ptr();
  std::cout << "\n\n";
  test_shared_ptr();
}
