import java.io.IOException;
import java.util.Collections;

public class Test
{

  public static void main(String[] args) throws IOException
  {
    Date sachinDate = new Date(25, 9, 2002);
    Date himalDate = new Date(02, 5, 1999);
    Date bartoszdate = new Date(4, 11, 1998);
    Date emilDate = new Date(6, 12, 1997);
    Date marianDate = new Date(29, 8, 1996);
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
    playerList.add(player1);
    playerList.add(player2);
    playerList.add(player3);
    playerList.add(player4);
    playerList.add(player5);
    modelManager.saveMatches(matchList);
    modelManager.savePlayers(playerList);
    modelManager.exportPlayersToXml();
    modelManager.exportUpcomingMatchesToXml();

  }
}
