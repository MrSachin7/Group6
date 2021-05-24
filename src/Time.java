import java.io.Serializable;
import java.text.DecimalFormat;

public class Time implements Serializable
{
  private int hour;
  private int minute;
  private int second;

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

  public Time(int totalTimeInSecond)
  {
    hour = (totalTimeInSecond / 3600);
    totalTimeInSecond = totalTimeInSecond - (hour * 3600);
    minute = totalTimeInSecond / 60;
    totalTimeInSecond -= (60 * minute);
    second = totalTimeInSecond;
  }

  public int convertToSecond()
  {
    return ((hour * 3600) + (minute * 60) + second);
  }

  public boolean isBefore(Time time)
  {
    if (this.convertToSecond() >= time.convertToSecond())
    {
      return false;
    }
    else
    {
      return true;
    }
  }

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

  public String toString()
  {
    DecimalFormat formatter = new DecimalFormat("00");
    return formatter.format(hour) + ":" + formatter.format(minute) + ":"
        + formatter.format(second);
  }
}
