import java.io.*;

class TestCheckedException {  

  public static void test1()
  {
     FileInputStream file = null;
     file = new FileInputStream("myfile.txt"); 
     int k; 

     while(( k = file.read() ) != -1) { 
      System.out.print((char)k); 
     } 
     file.close(); 	
  }
/** 
  public static void test2() throws IOException
  {
    FileInputStream file = null;
    file = new FileInputStream("myfile.txt"); 
    int k; 

    while(( k = file.read() ) != -1) { 
      System.out.print((char)k); 
    } 
    file.close(); 	
  }


  public static void test2check() {
    try {
      test2();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }


  public static void test3()
  {
    FileInputStream file = null;
    try {
      file = new FileInputStream("myfile.txt"); 
    }
    catch (FileNotFoundException e) {
      System.out.println("File 'myfile.txt' is not found");
    }
    int k; 
    try {
      while(( k = file.read() ) != -1) { 
       System.out.print((char)k); 
      } 
      file.close(); 	
    }
    catch (IOException e) {
      System.out.println("I/O error "+ e);
    }
    catch (NullPointerException e) {
      System.out.println("File was not open");
    }
  }
*/
  public static void main(String args[])
  {
    test1();
    // test2();
    // test2check();
    // test3();
  }
}