import java.io.IOException;


public class Test
{

  public static void main(String[] args) throws IOException
  {
    Date sachinDate = new Date(25, 9, 2002);
    Date himalDate = new Date(02, 5, 1999);
    Date bartoszdate = new Date(4, 11, 1998);
    Date emilDate = new Date(6, 12, 1997);
    Date marianDate = new Date(29, 8, 1996);
    Date matchDate= new Date(8,6,2021);
    Date matchdate2= new Date(30,5,2021);
    Time time = new Time(20,45,0);
    ModelManager modelManager = new ModelManager("Matches.bin", "Players.bin");
    PlayerList playerList = new PlayerList();
    MatchList matchList = new MatchList();
    Player player1 = new Player("Sachin", "Baral", sachinDate, "Striker");
    Player player2 = new Player("Cristian-Marian", "Radu", marianDate,
        "Midfielder");
    Player player3 = new Player("Emil", "Vassilev", emilDate, "Left Winger");
    Player player4 = new Player("Himal", "Sharma", himalDate, "Defender");
    Player player5 = new Player("Bartosz", "Zielenski", bartoszdate,
        "GoalKeeper");
    player1.setShirtNumber(7);
    player2.setShirtNumber(8);
    player3.setShirtNumber(9);
    player4.setShirtNumber(10);
    player5.setShirtNumber(11);
    playerList.add(player1);
    playerList.add(player2);
    playerList.add(player3);
    playerList.add(player4);
    playerList.add(player5);
    LeagueMatch match1 = new LeagueMatch("Juventus",matchDate,time,true);
    CupMatch match2 = new CupMatch("Barcelona",matchdate2,time,false);
    matchList.addMatch(match1);
    matchList.addMatch(match2);
    modelManager.saveMatches(matchList);
    modelManager.savePlayers(playerList);


  }
}
