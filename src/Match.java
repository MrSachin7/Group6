import java.io.Serializable;
//try
public abstract class Match implements Serializable
{
  private String opponentTeam;
  private Date matchDate;
  private Time startTime;
  private boolean isHomeMatch;


  public Match(String opponentTeam, Date matchDate, Time startTime,
      boolean isHomeMatch)
  {
    this.opponentTeam = opponentTeam;
    this.matchDate = matchDate;
    this.startTime = startTime;
    this.isHomeMatch = isHomeMatch;
  }
  public Date getMatchDate()
  {
    return matchDate;
  }

  public String getOpponentTeam()
  {
    return opponentTeam;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Math))
    {
      return false;
    }
    else
    {
      Match temp = (Match) obj;
      return temp.isHomeMatch =
          isHomeMatch && temp.opponentTeam
              .equals(opponentTeam) && temp.startTime.equals(startTime)
              && temp.matchDate.equals(matchDate);
    }
  }
  public abstract String matchType();

  public String toString()
  {
    return "Match Date :"+matchDate+"\n Starts at :"+startTime+"\n HomeMatch :"+isHomeMatch;
  }
}
