import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class MatchList
{
  private ArrayList<Match> matchList;

  public MatchList()
  {
    matchList = new ArrayList<>();
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
}
