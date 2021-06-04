import java.io.Serializable;

public class CupMatch extends Match implements Serializable
{
  /**
   * A constructor that creates the Cup Match Object
   * @param opponentTeam the opponent team of the match
   * @param matchDate the date of the match
   * @param startTime the starting time of the match
   * @param isHomeMatch true if the match is a home match , else false
   */
  public CupMatch(String opponentTeam, Date matchDate, Time startTime,
      boolean isHomeMatch)
  {
    super(opponentTeam, matchDate, startTime, isHomeMatch);
  }

  /**
   * Gets the type of the match
   * @return "Cup Match"
   */
  public String matchType()
  {
    return "Cup Match";
  }

  /**
   * Compares the given object with the League Match
   * @param obj the object to compare with the match
   * @return true, if the given object is a Cup Match object with all equal attributes
   */
  public boolean equals(Object obj)
  {
     return super.equals(obj);
    }

  /**
   * A method for returning the information of the match in a string
   * @return the string with the inforamtion of the match
   */
  public String toString()
  {
    return super.toString();
  }
}
