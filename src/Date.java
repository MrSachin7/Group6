import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;

/**
 * A class creating and managing the Date object
 * @author Sachin Baral
 * @version 1.0
 */

public class Date implements Serializable
{

    private int day;
    private int month;
    private int year;

  /**
   * A constructor creating a Date object
   * @param day the day of the year
   * @param month the month of the year
   * @param year the year
   */
    public Date(int day, int month, int year)
    {
      this.year = year;
      if (month <= 12)
      {
        this.month = month;
      }
      else
        throw new IllegalDateException("The month is not valid");

      if (day <= daysInMonth())
        this.day = day;
      else
        throw new IllegalDateException(" The day is not valid");
    }

  /**
   * Compares two Date object which comes earlier in a Calendar
   * @param date2 the Date object to compare
   * @return boolean (true if the given Date object comes before date2 in calendar) else false
   */
  public boolean isBefore(Date date2)
  {
    if (date2.year > year)
    {
      return true;
    }
    else if (date2.year == year && date2.month > month)
    {
      return true;
    }
    else if (date2.year == year && date2.month == month && date2.day > day)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**
   * A helping method for sorting matches by date
   * @param date2 the date to compare
   * @return -5 if the given match is after the match, else 1
   */
  public int sortAscending(Date date2)
  {
    if (this.isBefore(date2))
    {
      return -5;
    }
   else return 1;
  }


  /**
   * Checks if a Date object is a leap year
   * @return boolean (true if the given Date object is a leap year),else false
   */

  private boolean isLeapYear()
  {
    if ((year % 4 == 0) && (year % 100 != 0))
    {
      return true;
    }
    else if (year % 400 == 0)
    {
      return true;
    }
    else
      return false;
  }

  /**
   * Calculates the days in month of a Date object
   * @return the number of days in month of a Date object
   */
  private int daysInMonth()
  {
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
        || month == 10 || month == 12)
    {
      return 31;
    }
    else if (month == 2 && isLeapYear())
    {
      return 29;
    }
    else if (month == 2)
    {
      return 28;
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    else
    {
      return 0;
    }
  }

  /**
   * A static method for the current day.
   * @return Date Object of current day
   */
  public static Date today()
  {
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    return new Date(currentDay, currentMonth, currentYear);
  }
  /**
   * Compares given object with the Match
   * @param obj the object to compare with the match
   * @return boolean (true if the given object is a Date object with all equal attributes), else false
   */

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
    {
      return false;
    }
    else
    {
      Date other = (Date) obj;
      return other.day == day && other.month == month && other.year == year;
    }
  }

  /**
   * Gets the date object in a readable formatted manner
   * @return the information of the object in readable and understandable String.
   */
  public String toString()
  {
    DecimalFormat formatter = new DecimalFormat("00");
    return formatter.format(day) + "/" + formatter.format(month)+ "/" + formatter.format(year);
  }

}
