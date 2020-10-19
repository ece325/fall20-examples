package dat;

import java.util.*;

public interface MyList<T> extends Iterator<T>
{
  void add(T obj);
  T getElem(int pos);
  int getSize();
}
