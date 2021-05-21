import java.io.Serializable;

public class CupMatch extends Match implements Serializable
{
  public CupMatch(String opponentTeam, Date matchDate, Time startTime,
      boolean isHomeMatch, Formation formation)
  {
    super(opponentTeam, matchDate, startTime, isHomeMatch, formation);
  }
  public CupMatch(String opponentTeam, Date matchDate, Time startTime,
      boolean isHomeMatch)
  {
    super(opponentTeam, matchDate, startTime, isHomeMatch);
  }

  public void setFormation(Formation formation)
  {
    super.setFormation(formation);
  }
  public String matchType()
  {
    return "Cup Match";
  }
  public boolean equals(Object obj)
  {
    if (!(obj instanceof CupMatch))
    {
      return false;
    }
    else
    {
      CupMatch temp = (CupMatch)obj;
      return super.equals(temp);
    }
  }

  public String toString()
  {
    return super.toString();
  }
}
