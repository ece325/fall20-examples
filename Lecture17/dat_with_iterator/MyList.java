package dat_with_iterator;

import java.util.*;

public interface MyList<T> extends Iterable<T>
{
  void add(T obj);
  T getElem(int pos);
  int getSize();
}
