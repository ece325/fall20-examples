import java.util.*;


public class AnonymousClasses
{
  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(4,3,8,5,7,2,6,1);
    list.stream().forEach(x->System.out.print(x+" "));

    System.out.println("\n--------------------");
    Collections.sort(list);
    list.stream().forEach(x->System.out.print(x+" "));
  
    System.out.println("\n--------------------");
    List<Integer> list2 = Arrays.asList(4,3,8,5,7,2,6,1);
    
    Comparator<Integer> comp = new Comparator<Integer>() {
      public int compare(Integer a, Integer b) {
        return a - b;
      }
    };

    Collections.sort(list2, comp);

    list2.stream().forEach(x->System.out.print(x+" "));

    System.out.println("\n--------------------");
    List<Integer> list3 = Arrays.asList(4,3,8,5,7,2,6,1);
    
    Comparator<Integer> reverse = new Comparator<Integer>() {
      public int compare(Integer a, Integer b) {
        return b - a;
      }
    };

    Collections.sort(list3, reverse);

    list3.stream().forEach(x->System.out.print(x+" "));
  
    System.out.println("\n--------------------");
    List<Integer> list4 = Arrays.asList(4,3,8,5,7,2,6,1);
    
    Comparator<Integer> foo = new Comparator<Integer>() {
      public int compare(Integer a, Integer b) {
        return (a % 2) - (b % 2);
      }
    };

    Collections.sort(list4, foo);

    list4.stream().forEach(x->System.out.print(x+" "));
  }
}