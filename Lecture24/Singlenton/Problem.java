import java.io.IOException;

import java.io.*;

class TestA
{
  private String result;

  public void test() {
    result = "[test A] Result was ...";
  }

  public void log() {
    try {
      FileWriter fileWriter = new FileWriter("logResults.txt");
      fileWriter.write(result+"\n");
      fileWriter.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}


class TestB
{
  private String result;

  public void test() {
    result = "[test B] Result for the test was ...";
  }

  public void log() {
    try {
      FileWriter fileWriter = new FileWriter("logResults.txt");
      fileWriter.write(result+"\n");
      fileWriter.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}


public class Problem
{

  public static void main(String[] args) {
    
    TestA testA = new TestA();
    testA.test();
    testA.log();    

    TestB testB = new TestB();
    testB.test();
    testB.log();  
    
    System.out.println("Done!");
  }
}