class People
{
    public String name;
}

public class TestRefactory1
{
    public static void main(String[] args) {
        People p = new People();
        p.name = "John Smith";

        System.out.println(p.name);
    }
}