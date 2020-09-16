public class Program2 
{
  /**
   * Determine if a year ia a leap year (bissextile year)
   * @param year to determine
   * @return True if the year is a leap year, false otherwise.
   */
  static boolean isLeapYear(int year) {
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] years = {2015,2016,2017,2018,2019,2020,2021,2022};
    for (int year : years) {
      System.out.println(year+"? "+isLeapYear(year));
    }   
  }
}