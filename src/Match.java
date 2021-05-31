import java.io.Serializable;

/**
 * An abstract class that initialize and manage Match object
 * @author Bartosz Zielinski
 */
public abstract class Match implements Serializable
{
  private String opponentTeam;
  private Date matchDate;
  private Time startTime;
  private boolean isHomeMatch;
  private String result;

  /**
   * A constructor that creates a Match object.
   * @param opponentTeam the team to face in a game
   * @param matchDate Date object that stores the date when match is happening
   * @param startTime Time object that stores the time when the match is starting
   * @param isHomeMatch boolean (true if the game is home game) else false
   */
  public Match(String opponentTeam, Date matchDate, Time startTime,
      boolean isHomeMatch)
  {
    this.opponentTeam = opponentTeam;
    this.matchDate = matchDate;
    this.startTime = startTime;
    this.isHomeMatch = isHomeMatch;
    this.result="";


  }

  /**
   * Sets/change the result of the Match
   * @param result the result of the match
   */
  public void setResult(String result)
  {
    this.result = result;
  }

  /**
   * Gets the date of the match
   * @return Date object inside the match
   */
  public Date getMatchDate()
  {
    return matchDate;
  }

  /**
   * Gets the opponent Team of the match
   * @return opponentTeam of the Match
   */

  public String getOpponentTeam()
  {
    return opponentTeam;
  }

  /**
   * Gets the starting time of the match
   * @return Time object of match
   */

  public Time getStartTime()
  {
    return startTime;
  }

  /**
   * Gets the result of the match
   * @return result of the Match object
   */
  public String getResult()
  {
    return result;
  }

  /**
   * Compares given object with the Match
   * @param obj the object to compare with the match
   * @return boolean (true if the given object is a Match object with all equal attributes), else false
   */

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Match))
    {
      return false;
    }
    else
    {
      Match temp = (Match) obj;
      return temp.isHomeMatch =
          isHomeMatch && temp.opponentTeam
              .equals(opponentTeam)
              && temp.matchDate.equals(matchDate);
    }
  }

  /**
   * An abstract method to pass that gets the type of match.
   * @return the type of the match i.e LeagueMatch, CupMatch or FriendlyMatch
   */
  public abstract String matchType();

  /**
   * A method for returning the information of the Match in String.
   * @return all the important attributes in readable String format
   */
  public String toString()
  {
    return opponentTeam;
  }
  public String homeOrAway()
  {
    if (isHomeMatch==true)
    {
      return "Home";
    }
    return "Away";
  }


}
