import java.util.*;

interface Operation<T> {
  T apply(T a, int b);
  T getEmpty();
}

class Sum implements Operation<Integer>
{  
  public Integer apply(Integer a, int b) { return a+b; }

  public Integer getEmpty() { return 0; }
}

class Product implements Operation<Integer>
{
  public Integer apply(Integer a, int b) { return a*b; }

  public Integer getEmpty() { return 1; }
}

class Append implements Operation<String>
{  
  public String apply(String a, int b) { return a+"->"+b; }

  public String getEmpty() { return ""; }
}


class MoreOOP
{
  public static <T> T for_each(List<Integer> list, Operation<T> oper) {
    T result = oper.getEmpty();
    for(Integer value : list) {
      result = oper.apply(result, value);
    }
    return result;
  }

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(4,3,6,7,2,1,5);

    for(Integer value : list) {
      System.out.print(value+", ");
    }
    System.out.println("\n-------------");
    System.out.println("Sum of elements: " + for_each(list, new Sum()));

    System.out.println("-------------");
    System.out.println("Product of elements: " + for_each(list, new Product()));

    System.out.println("-------------");
    System.out.println("String of elements: " + for_each(list, new Append()));
  }
}