import java.awt.event.MouseAdapter;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Match objects.
 *
 * @author Emil Vassilev
 * @version 1.0
 */
public class MatchList implements Serializable
{
  private ArrayList<Match> matchList;

  /**
   * No-argument constructor initializing the MatchList.
   */
  public MatchList()
  {
    matchList = new ArrayList<>();
  }

  /**
   * Gets the length/size of the list.
   *
   * @return int the size of the list
   */
  public int size()
  {
    return matchList.size();
  }

  /**
   * Adds a Match object to the list.
   *
   * @param match the match to add on the list.
   */
  public void addMatch(Match match)
  {
    matchList.add(match);
  }

  /**
   * Gets a Match object from position index from the list.
   *
   * @param index the position in the list of the Match object
   * @return the Match object at index if one exist, else null
   */
  public Match get(int index)
  {
    if (index < matchList.size())
    {
      return matchList.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * Removes the Match object from the list.
   *
   * @param match the Match object to remove from the list
   */
  public void removeMatch(Match match)
  {
    ArrayList<Match> temp = new ArrayList<>();
    for (int i = 0; i < matchList.size(); i++)
    {
      if (!matchList.get(i).equals(match))
      {
        temp.add(match);
      }
      matchList = temp;
    }
  }

  /**
   * Gets opponents of all Match object from the List.
   *
   * @return opponents of all Match object from the List.
   */
  public String getAllOpponents()
  {
    String temp = "";
    for (int i = 0; i < matchList.size(); i++)
    {
      temp += matchList.get(i).getOpponentTeam() + "\n";
    }
    return temp;
  }

  /**
   * Gets Time object of all Match object from the List.
   *
   * @return Time object of all Match object from the List.
   */
  public String getAllTimes()
  {
    {
      String temp = "";
      for (int i = 0; i < matchList.size(); i++)
      {
        temp += matchList.get(i).getStartTime() + "\n";
      }
      return temp;
    }
  }

  /**
   * Gets Date object of all Match object from the List.
   *
   * @return Date object of all Match object from the List.
   */
  public String getAllDates()
  {
    {
      String temp = "";
      for (int i = 0; i < matchList.size(); i++)
      {
        temp += matchList.get(i).getMatchDate() + "\n";
      }
      return temp;
    }
  }

  /**
   * Gets matchType of all Match object from the List.
   *
   * @return matchType object of all Match object from the List.
   */
  public String getAllMatchesTypes()
  {
    {
      String temp = "";
      for (int i = 0; i < matchList.size(); i++)
      {
        temp += matchList.get(i).matchType() + "\n";
      }
      return temp;
    }
  }

}
