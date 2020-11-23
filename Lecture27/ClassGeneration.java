// Main class
class Main {

	// Inner class Test1
	class Test1 {
	}

	// Inner class Test2
	class Test2 {
	}

	public void someMethod() {
  
    // Local inner call
    class Test3 {
    }

		// Anonymous inner class 1
		new Object() {
		};

		// Anonymous inner class 2
		new Object() {
		};

		System.out.println("Hello World");
	}
}

public class ClassGeneration
{
  public static void main(String[] args) {
    Main m = new Main();
    m.someMethod();
  }
}