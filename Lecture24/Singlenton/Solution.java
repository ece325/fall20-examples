import java.io.*;

class Logger
{
  private static Logger instance = null;
  FileWriter fileWriter;

  private Logger() {
    try {
      fileWriter = new FileWriter("logResults.txt");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Logger getInstance() {
    if (instance == null)
      instance = new Logger();
    return instance;
  }

  public void log(String result) {
    try {
      fileWriter.write(result);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      fileWriter.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class TestA
{
  private String result;

  public void test() {
    result = "[test A] Result was ...";
  }

  public void log() {
    Logger logger = Logger.getInstance();
    logger.log(result+"\n");
  }
}


class TestB
{
  private String result;

  public void test() {
    result = "[test B] Result for the test was ...";
  }

  public void log() {
    Logger logger = Logger.getInstance();
    logger.log(result+"\n");
  }
}


public class Solution
{

  public static void main(String[] args) {
    TestA testA = new TestA();
    testA.test();
    testA.log();    

    TestB testB = new TestB();
    testB.test();
    testB.log();  
    
    System.out.println("Done!");
    // Logger l = new Logger();
    Logger.getInstance().close();
  }
}