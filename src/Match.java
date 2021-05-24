import java.io.Serializable;

/**
 * An abstract class that initialize and manage Match object
 * @author Sachin Baral
 * @version 1.0
 */
public abstract class Match implements Serializable
{
  private String opponentTeam;
  private Date matchDate;
  private Time startTime;
  private boolean isHomeMatch;

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
   * Compares given object with the Match
   * @param obj the object to compare with the match
   * @return boolean (true if the given object is a Match object with all equal attributes), else false
   */

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

  /**
   * An abstract method to pass that gets the type of match.
   * @return the type of the match i.e LeagueMatch, CupMatch or FriendlyMatch
   */
  public abstract String matchType();


  public String toString()
  {
    return "Match Date :"+matchDate+"\n Starts at :"+startTime+"\n HomeMatch :"+isHomeMatch;
  }
}
