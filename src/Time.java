import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * A class that creates and manages the Time object
 * @author Himal Sharma
 * @version 1.0
 */
public class Time implements Serializable
{
  private int hour;
  private int minute;
  private int second;

  /**
   * A constructor time that creats a Time object
   * @param h  hours
   * @param m  minutes
   * @param s seconds
   */
  public Time(int h, int m, int s)
  {
    if (h <= 24 && h >= 0)
    {
      if (m <= 60 && m >= 0)
      {
        if (s <= 60 && s >= 0)
        {
          hour = h;
          minute = m;
          second = s;
        }
      }
    }
  }

  /**
   * A constructor that creates a Time with total time in seconds
   * @param totalTimeInSecond the total time in seconds
   */

  public Time(int totalTimeInSecond)
  {
    hour = (totalTimeInSecond / 3600);
    totalTimeInSecond = totalTimeInSecond - (hour * 3600);
    minute = totalTimeInSecond / 60;
    totalTimeInSecond -= (60 * minute);
    second = totalTimeInSecond;
  }
  /**
   * Compares given object with the Match
   * @param obj the object to compare with the match
   * @return boolean (true if the given object is a Time  object with all equal attributes), else false
   */

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Time))
    {
      return false;
    }
    else
    {
      Time other = (Time) obj;
      return other.second == second && other.minute == minute
          && other.hour == hour;
    }
  }

  /**
   * Gets hour,minute and second in a user-friendly way
   * @return hour,minute and seconds in String.
   */
  public String toString()
  {
    DecimalFormat formatter = new DecimalFormat("00");
    return formatter.format(hour) + ":" + formatter.format(minute) + ":"
        + formatter.format(second);
  }
}
