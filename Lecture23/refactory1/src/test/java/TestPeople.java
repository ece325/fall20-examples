import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestPeople
{
    private People people = new People();

    @Test
    public void constructor() {
        People people = new People();
        assertNotEquals(null, people);
    }

    @Test
    public void setName() {
        people.name = "John Smith";
        assertEquals("John Smith", people.name);
    }

    @Test
    public void getName() {
        people.name = "John Smith";
        assertEquals("John Smith", people.name);
    }

}