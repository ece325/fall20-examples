import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WeekCalculator
{
  private LocalDate getISOWeekOne(int year) {
    // get the date for the 4th of Jan of this year
    LocalDate dt = LocalDate.of(year, 1, 4);
    // get the ISO day numberfor this date 1=Monday, 7=Sunday
    int dayNumber = dt.getDayOfWeek().ordinal() + 1;

    // Return the date of the Monday that is less that or equal 
    // to this date
    return dt.plusDays(1 - dayNumber);

  }

  public int getISOWeek(LocalDate dt) {
    LocalDate week1;
    int isoYear = dt.getYear();
    if (dt.isAfter(LocalDate.of(isoYear, 12, 28))) {
      week1 = getISOWeekOne(isoYear + 1);
      if (dt.isBefore(week1)) {
        week1 = getISOWeekOne(isoYear);
      }
      else {
        ++isoYear;
      }
    }
    else {
      week1 = getISOWeekOne(isoYear);
      if (dt.isBefore(week1)) {
        week1 = getISOWeekOne(--isoYear);
      }
    }
    int difference = (int)ChronoUnit.DAYS.between(week1, dt);
    return (isoYear*100) + (difference / 7 + 1);
  }

}