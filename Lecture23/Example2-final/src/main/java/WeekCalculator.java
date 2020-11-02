import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WeekCalculator
{
  // get the ISO day numberfor this date 1=Monday, 7=Sunday
  private int getISODayNumber(LocalDate date) {
    return date.getDayOfWeek().ordinal() + 1;
  }

  // Return the date of the Monday that is less than or equal 
  // to this date
  private LocalDate getPreviousMonday(LocalDate date) {
    return date.plusDays(1 - getISODayNumber(date));
  }

  // get the date for the 4th of Jan of this year
  private LocalDate get4thOfJanuary(int year) {
    return LocalDate.of(year, 1, 4);
  }

  private LocalDate getISOWeekOne(int year) {
    return getPreviousMonday(get4thOfJanuary(year));
  }

  private int calculateISOWeek(LocalDate dt, int isoYear) {
    int difference = (int)ChronoUnit.DAYS.between(getISOWeekOne(isoYear), dt);
    return (isoYear*100) + (difference / 7 + 1);
  }

  public int getISOWeek(LocalDate dt) {
    if (dt.isBefore(getISOWeekOne(dt.getYear()))) {
      return calculateISOWeek(dt, dt.getYear() - 1);
    }
    if (dt.isAfter(getISOWeekOne(dt.getYear() + 1))) {
      return calculateISOWeek(dt, dt.getYear() + 1);
    }
    return calculateISOWeek(dt, dt.getYear());
  }

}