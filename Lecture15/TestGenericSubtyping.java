import testinterface.*;

public class TestGenericSubtyping
{
  public static void main(String[] args) {
    
    MyList<String> list = new OtherList<String>();

    MyList<Object> list2 = list;

  }
}