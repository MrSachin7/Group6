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
   * Removes match from matchList
   * @param opponent
   * @param startDate
   */
  public void removeMatch(String opponent, Date startDate)
  {
    ArrayList<Match> temp = new ArrayList<>();
    for (int i = 0; i < matchList.size(); i++)
    {

      if (!(matchList.get(i).getOpponentTeam().equals(opponent) && matchList.get(i).getMatchDate().equals(startDate)))
      {
        temp.add(matchList.get(i));
      }

    }
    matchList = temp;
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

  /**
   * Gets results from all the matches of the list
   * @return result pf all Match object of from a list
   */
  public String getAllResults()
  {
    String temp = "";
    for (int i = 0; i < matchList.size(); i++)
    {
      if (matchList.get(i).getMatchDate().isBefore(Date.today()))
      {
        temp += matchList.get(i).getResult() + "\n";
      }
    }
    return temp;
  }
}
