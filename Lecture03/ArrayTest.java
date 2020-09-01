public class ArrayTest {
  
  /**
   * Prints all the elements in the given array, one for each line
   * @param data array containing the element to print
   */
  public static void printArray(double[] data) {
    System.out.println("-------------------");
    for(int i = 0; i < data.length; ++i) {
      System.out.println(i + " -> " + data[i]);
    }
  } 

  /**
   * Multiplies each element of the given array by two
   * @param data array to multiply by two each element
   */
  public static void times2Array(double[] data) {
    for(int i = 0; i < data.length; ++i) {
      data[i] *= 2;
    }
  }

  /**
   * Returns a new array with the elements in reverse order from the given array
   * @param data array to reverse
   * @return New array with the element from data but in reverse order
   */
  public static double[] reverseArray(double[] data) {
    double[] newData = new double[data.length];
    for (int i=0, j=data.length-1; i < data.length; ++i, --j) {
      newData[i] = data[j];
    }
    return newData;
  }

  public static void main(String[] args) {
    double[] myArray = new double[10];
    myArray[1] = 3.45;
    myArray[4] = -13.9;
    myArray[6] = myArray[1] - myArray[4] * 2;
    int size = myArray.length;
    System.out.println("myArray size: "+size);
    
    // copying reference but not content
    double[] otherArray = myArray;

    // copying content and creates a new array
    otherArray = myArray.clone();
    otherArray[0] = 100;

    // traversing using C like for-loop
    for(int i = 0; i < otherArray.length; ++i) {
      System.out.println(i + " -> " + otherArray[i]);
    }

    // traversing using for-each style
    for (double elem : myArray) {
      System.out.println(elem);
    }
  
    printArray(otherArray);
    times2Array(otherArray);
    printArray(otherArray);

    double[] myData = {1,3,5,7,9,11,13};
    printArray(myData);
    myArray = reverseArray(myData);
    printArray(myArray);
  }
}