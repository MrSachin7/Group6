public class FriendlyMatch extends Match
{
  public FriendlyMatch(String opponentTeam, Date matchDate, Time startTime,
      boolean isHomeMatch, Formation formation)
  {
    super(opponentTeam, matchDate, startTime, isHomeMatch, formation);
  }

  public String matchType()
  {
    return "Friendly Game";
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof FriendlyMatch))
    {
      return false;
    }
    else
    {
      FriendlyMatch temp = (FriendlyMatch) obj;
      return super.equals(temp);
    }
  }

  public String toString()
  {
    return super.toString();
  }
}
