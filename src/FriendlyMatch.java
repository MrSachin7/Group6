import java.io.Serializable;

/**
 * @author Bartosz Zielinski
 */
public class FriendlyMatch extends Match implements Serializable
{
  /**
   * A constructor that creates a Friendly  Match object.
   *
   * @param opponentTeam the team to face in a game
   * @param matchDate    Date object that stores the date when match is happening
   * @param startTime    Time object that stores the time when the match is starting
   * @param isHomeMatch  boolean (true if the game is home game) else false
   */
  public FriendlyMatch(String opponentTeam, Date matchDate, Time startTime,
      boolean isHomeMatch)
  {
    super(opponentTeam, matchDate, startTime, isHomeMatch);
  }

  /**
   * A method that just returns "Friendly Match" (type of match)
   *
   * @return "Friendly Match"(type of a match)
   */
  public String matchType()
  {
    return "Friendly Match";
  }

  /**
   * Compares given object with the Match
   *
   * @param obj the object to compare with the match
   * @return boolean (true if the given object is a Friendly Match object with all equal attributes), else false
   */
  public boolean equals(Object obj)
  {
    return super.equals(obj);
  }

  /**
   * A method for returning the information of the Match in String.
   *
   * @return all the important attributes in readable String format
   */
  public String toString()
  {
    return super.toString();
  }
}
