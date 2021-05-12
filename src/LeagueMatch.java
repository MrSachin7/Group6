public class LeagueMatch extends Match
{
  public LeagueMatch(String opponentTeam, Date matchDate, Time startTime,
      boolean isHomeMatch, Formation formation)
  {
    super(opponentTeam, matchDate, startTime, isHomeMatch, formation);
  }
  public String matchType()
  {
    return "League Match";
  }
  public boolean equals(Object obj)
  {
    if (!(obj instanceof LeagueMatch))
    {
      return false;
    }
    else
    {
      LeagueMatch temp = (LeagueMatch)obj;
      return super.equals(temp);
    }
  }

  public String toString()
  {
    return super.toString();
  }

}
