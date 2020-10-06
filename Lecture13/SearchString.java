public class SearchString
{
  public static void report(String food, boolean to_buy) {
    if (to_buy) {
      System.out.println(food + " is in the recipe");
    }
    else {
      System.out.println(food + " is not needed");        
    }
  }

  public static void main(String[] args) {
    
    String[] foods = {"apple","cinnamon","eggs","sugar","flour"};
 
    // String f = "bannanas";
    String f = "Eggs".toLowerCase();
    // String f = "eggs";

    boolean to_buy = false;

    for (String food : foods) {
      if (f == food) {
        to_buy = true;
      }
    }
    
    report(f, to_buy);

    // -----------------------

    /** */
    to_buy = false;

    for (String food : foods) {
      if (f.equals(food)) {
        to_buy = true;
      }
    }

    report(f, to_buy);
    /***/
  }
}