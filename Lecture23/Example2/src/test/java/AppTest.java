import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.time.LocalDate;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static WeekCalculator wc = new WeekCalculator();

    @Test
    public void getISOWeekLast()
    {
        LocalDate date = LocalDate.of(2006,12,31);
        int isoWeek = wc.getISOWeek(date);
        assertEquals(200652, isoWeek);
    }

    @Test
    public void getISOWeekFirst()
    {
        LocalDate date = LocalDate.of(2019,1,1);
        int isoWeek = wc.getISOWeek(date);
        assertEquals(201901, isoWeek);
    }
}
