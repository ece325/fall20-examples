package testinterface;

public interface MyList<T>
{
  void add(T obj);
  T getElem(int pos);
  int getSize();
  void print();
}
