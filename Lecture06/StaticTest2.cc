#include <iostream>

class Element {
  static int numElements;
public:
  int id;

  Element() 
    : id{++numElements}
  { }

  static int getNumElements() {
    return numElements;
  }
};

int Element::numElements = 0;

int main(int argc, char const *argv[])
{
  Element* x;
  Element* y = new Element();
  Element* z = new Element();

  std::cout << "Number of Elements created: " << Element::getNumElements() << std::endl;
  std::cout << "Element Id of y: " << y->id << std::endl;

  return 0;
}
