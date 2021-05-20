public class Test
 {

  public static void main(String[] args)
  {
    Time time = new Time(4, 5, 2);

    Date date1 = new Date(25, 9, 2002);
    CupMatch match1 = new CupMatch("Levamte", date1, time, true);
    MatchList matchList = new MatchList();
    matchList.addMatch(match1);
    System.out.println(matchList.get(0).matchType());
  }
}
