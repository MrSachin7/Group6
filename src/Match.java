import java.io.Serializable;
import java.text.Normalizer;
//try
public abstract class Match implements Serializable
{
  private String opponentTeam;
  private Date matchDate;
  private Time startTime;
  private boolean isHomeMatch;
  private Formation formation;

  public Match(String opponentTeam, Date matchDate, Time startTime,
      boolean isHomeMatch, Formation formation)
  {
    this.opponentTeam = opponentTeam;
    this.matchDate = matchDate;
    this.startTime = startTime;
    this.isHomeMatch = isHomeMatch;
    this.formation = formation;
  }

  public Match(String opponentTeam, Date matchDate, Time startTime,
      boolean isHomeMatch)
  {
    this.opponentTeam = opponentTeam;
    this.matchDate = matchDate;
    this.startTime = startTime;
    this.isHomeMatch = isHomeMatch;
    this.formation = null;
  }

  public void setFormation(Formation formation)
  {
    this.formation = formation;
  }

  public Date getMatchDate()
  {
    return matchDate;
  }

  public Formation getFormation()
  {
    return formation;
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
          isHomeMatch && temp.formation.equals(formation) && temp.opponentTeam
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
