import java.awt.event.MouseAdapter;
import java.io.Serializable;
import java.util.ArrayList;

public class MatchList implements Serializable
{
  private ArrayList<Match> matchList;

  public MatchList()
  {
    matchList = new ArrayList<>();
  }
  public int size()
  {
    return matchList.size();
  }

  public void addMatch(Match match)
  {
    matchList.add(match);
  }
  public Match get(int index)
  {
    return matchList.get(index);
  }
  public void removeMatch(Match match)
  {
    ArrayList<Match> temp = new ArrayList<>();
    for (int i=0; i<matchList.size();i++)
    {
      if (!matchList.get(i).equals(match))
      {
        temp.add(match);
      }
     matchList= temp;
    }
  }
  public String getAllOpponents()
  {
    String temp ="";
    for (int i=0; i<matchList.size(); i++)
    {
      temp+=matchList.get(i).getOpponentTeam()+"\n";
    }
    return temp;
  }
  public String getAllTimes()
  {
    {
      String temp ="";
      for (int i=0; i<matchList.size(); i++)
      {
        temp+=matchList.get(i).getStartTime()+"\n";
      }
      return temp;
    }
  }
  public String getAllDates()
  {
    {
      String temp ="";
      for (int i=0; i<matchList.size(); i++)
      {
        temp+=matchList.get(i).getMatchDate()+"\n";
      }
      return temp;
    }
  }
  public String getAllMatchesTypes()
  {
    {
      String temp ="";
      for (int i=0; i<matchList.size(); i++)
      {
        temp+=matchList.get(i).matchType()+"\n";
      }
      return temp;
    }
  }

}
