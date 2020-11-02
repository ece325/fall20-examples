import java.time.LocalDate;

public class ISOWeek 
{
    public static void main( String[] args )
    {
        WeekCalculator wc = new WeekCalculator();
        LocalDate today = LocalDate.now();
        int isoWeek = wc.getISOWeek(today);
        System.out.println(today + " in ISO week: "+ isoWeek);
    }
}
