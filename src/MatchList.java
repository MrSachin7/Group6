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

}
