package zoo;

public abstract class Animal implements Eating, JSONSerializable
{
  public static String CATEGORY = "domestic";
  private String name;
  
  Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  protected abstract String getSound();

  public String toJSON() {
    String json = "";
    json += "{\n";
    json += "  CATEGORY : " + CATEGORY + ",\n";
    json += "  name : \"" + name + "\"\n";
    json += "}";
    return json;
  }
}

